package myspring.user.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import myspring.user.service.UserService;
import myspring.user.vo.UserVO;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	// 사용자 목록 조회
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();

//		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
//		request.setAttribute("userList", users);
//		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		// 위의 코드를 다음과 같이 표시할 수 있다.
		return new ModelAndView("userList", "userList", userList);
	}

	// 사용자 상세정보 조회
	@RequestMapping("/userDetail.do")
	// @RequestParam : request.getParameter()와 동일하다.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail";
	}

	// 사용자 등록Form 조회
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		
		//session에 genderList를 저장해보기
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("경기");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		
		//session에 cityList를 저장해보기
		session.setAttribute("cityList", cityList);

		//session에 저장했기 때문에 Map은 필요없다.
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert";
	}
	
	//사용자 등록 처리
	//post방식이기 때문에 다음과 같이 사용해야한다. method 언급을 안하게 되면 get으로 인식
	//<form method="post" action="userInsert.do" >
	//value = "/userInsert.do",method = RequestMethod.POST
	@RequestMapping(value = "/userInsert.do",method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.insertUser(user);
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
	
	//사용자 삭제 처리
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
	
	//사용자 수정Form 조회
	@RequestMapping("/userUpdateForm.do")
	public ModelAndView updateUserForm(@RequestParam String userid) {
		UserVO user = userService.getUser(userid);
		List<String> genderList = new ArrayList<String>();
		genderList.add("남");
		genderList.add("여");
		List<String> cityList = new ArrayList<String>();
		cityList.add("서울");
		cityList.add("부산");
		cityList.add("대구");
		cityList.add("제주");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		map.put("user", user);
		return new ModelAndView("userUpdate", "map", map);
	}
	
	//사용자 수정 처리
	@RequestMapping(value = "/userUpdate.do",method = RequestMethod.POST)
	public String userUpdate(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.updateUser(user);;
		//사용자 목록 조회를 처리하는 요청으로 포워딩을 하겠다.(사용자 목록 페이지로 포워딩)
		return "redirect:/userList.do";
	}
	
}
