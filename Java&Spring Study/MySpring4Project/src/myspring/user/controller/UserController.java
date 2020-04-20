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

	// ����� ��� ��ȸ
	@RequestMapping("/userList.do")
	public ModelAndView userList() {
		List<UserVO> userList = userService.getUserList();

//		//2. DAO�� �޾ƿ� List ��ü�� JSP���� ����� �� �ֵ��� reguest ��ü�� �����Ѵ�.
//		request.setAttribute("userList", users);
//		//3. ����� ������� JSP - UserList.jsp�� ������(�������� ����)
//		rd = request.getRequestDispatcher("userList.jsp");
//		rd.forward(request, response);
		// ���� �ڵ带 ������ ���� ǥ���� �� �ִ�.
		return new ModelAndView("userList", "userList", userList);
	}

	// ����� ������ ��ȸ
	@RequestMapping("/userDetail.do")
	// @RequestParam : request.getParameter()�� �����ϴ�.
	public String userDetail(@RequestParam String userid, Model model) {
		UserVO user = userService.getUser(userid);
		model.addAttribute("user", user);
		return "userDetail";
	}

	// ����� ���Form ��ȸ
	@RequestMapping("/userInsertForm.do")
	public String insertUserForm(HttpSession session) {
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		
		//session�� genderList�� �����غ���
		session.setAttribute("genderList", genderList);

		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("���");
		cityList.add("�λ�");
		cityList.add("�뱸");
		cityList.add("����");
		
		//session�� cityList�� �����غ���
		session.setAttribute("cityList", cityList);

		//session�� �����߱� ������ Map�� �ʿ����.
//		Map<String, List<String>> map = new HashMap<>();
//		map.put("genderList", genderList);
//		map.put("cityList", cityList);

		return "userInsert";
	}
	
	//����� ��� ó��
	//post����̱� ������ ������ ���� ����ؾ��Ѵ�. method ����� ���ϰ� �Ǹ� get���� �ν�
	//<form method="post" action="userInsert.do" >
	//value = "/userInsert.do",method = RequestMethod.POST
	@RequestMapping(value = "/userInsert.do",method = RequestMethod.POST)
	public String userInsert(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.insertUser(user);
		//����� ��� ��ȸ�� ó���ϴ� ��û���� �������� �ϰڴ�.(����� ��� �������� ������)
		return "redirect:/userList.do";
	}
	
	//����� ���� ó��
	@RequestMapping("/userDelete.do/{id}")
	public String userDelete(@PathVariable("id") String userid) {
		userService.deleteUser(userid);
		//����� ��� ��ȸ�� ó���ϴ� ��û���� �������� �ϰڴ�.(����� ��� �������� ������)
		return "redirect:/userList.do";
	}
	
	//����� ����Form ��ȸ
	@RequestMapping("/userUpdateForm.do")
	public ModelAndView updateUserForm(@RequestParam String userid) {
		UserVO user = userService.getUser(userid);
		List<String> genderList = new ArrayList<String>();
		genderList.add("��");
		genderList.add("��");
		List<String> cityList = new ArrayList<String>();
		cityList.add("����");
		cityList.add("�λ�");
		cityList.add("�뱸");
		cityList.add("����");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("genderList", genderList);
		map.put("cityList", cityList);
		map.put("user", user);
		return new ModelAndView("userUpdate", "map", map);
	}
	
	//����� ���� ó��
	@RequestMapping(value = "/userUpdate.do",method = RequestMethod.POST)
	public String userUpdate(@ModelAttribute UserVO user) {
		System.out.println(">>> UserVO " + user);
		userService.updateUser(user);;
		//����� ��� ��ȸ�� ó���ϴ� ��û���� �������� �ϰڴ�.(����� ��� �������� ������)
		return "redirect:/userList.do";
	}
	
}
