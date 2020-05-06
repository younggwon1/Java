package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.user.dao.UserDAO;
import jdbc.user.vo.UserVO;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("*.do")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO dao;
	
	private RequestDispatcher rd;
	
	@Override
	public void init() throws ServletException {
		System.out.println("UserServlet init() method called!");
		dao = new UserDAO();
	}
	
	@Override
	public void destroy() {
		System.out.println("UserServlet destroy() method called!");
	}
       
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public UserServlet() {
//        super();
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("UserServlet doGet() method called!" + request.getMethod());
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//요청(request) 데이터의 인코딩(getParameter를 하기전에 해야한다.요청데이터에 한글이 있을 수 있기 때문에.)
		request.setCharacterEncoding("utf-8");
		String cmd = request.getParameter("cmd"); //cmd라는 단어의 userDetail, userList가 온다. 분기처리 한다.
		System.out.println(">>>>>>>command : " + cmd);
		if(cmd.equals("userList")) {
			userList(request, response);
		}
		else if(cmd.equals("userDetail")) {
			userDetail(request, response);
		}
		else if(cmd.equals("userForm")) {
			userForm(request, response);
		}
		else if(cmd.equals("userInsert")) {
			userInsert(request, response);
		}
	}
	
	
	private void userInsert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//1. form data를 추출해서 UserVO에 저장한다. 
		UserVO user = new UserVO(request.getParameter("userid"),
								 request.getParameter("name"), 
								 request.getParameter("gender").charAt(0), 
								 request.getParameter("city"));
		System.out.println(user);
		//2. DAO의 InserUser() 메서드 호출
		int cnt = dao.insertUser(user);
		if(cnt==1) { // 등록 성공
			userList(request, response);
		}
	}
	
	
	private void userForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//객체를 넘기지 않고 해당페이지로만 포워딩하는 것
		response.sendRedirect("userForm.html");
		
	}

	
	
	private void userDetail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String userid = request.getParameter("id");
		System.out.println(">>>>>>userid : " + userid);
		
		//1. DAO 호출
		UserVO userVO = dao.getUser(userid);
		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
		request.setAttribute("user", userVO);
		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
		rd = request.getRequestDispatcher("userDetail.jsp");
		rd.forward(request, response);
	}
	
	

	private void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1. DAO 호출
		List<UserVO> users = dao.getUsers();
		//2. DAO로 받아온 List 객체를 JSP에서 사용할 수 있도록 reguest 객체를 저장한다.
		request.setAttribute("userList", users);
		//3. 결과를 출력해줄 JSP - UserList.jsp를 포워딩(브라우저에 찍어보기)
		rd = request.getRequestDispatcher("userList.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("UserServlet doPost() method called!" + request.getMethod());
		doGet(request, response);
	}

}
