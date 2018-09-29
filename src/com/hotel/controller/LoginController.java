package com.hotel.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hotel.entity.User;
import com.hotel.service.IUserService;
import com.hotel.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/loginaction.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IUserService userService=new UserServiceImpl();
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");
		if(opt==null) {
			opt="url";
		}
		switch (opt) {
		//��¼����
		case "login":
			this.login(request, response);
			break;
		//ӳ��·��
		case "url":
			this.goUrl(request, response);
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * ӳ��URL
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void goUrl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "", password = "";
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals("name")) {
					name = cookies[i].getValue();
				} else if (cookies[i].getName().equals("password")) {
					password = cookies[i].getValue();
				}
			}
		}
		request.setAttribute("name", name);
		request.setAttribute("password",password );
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
	/**
	 * ��¼
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ��ȡ�ͷ�����
		String inputName = request.getParameter("inputName");
		String inputPwd = request.getParameter("inputPassword");
		String remember = request.getParameter("remember");
		// ����ҵ��ģ��
		List<User> list;
		try {
			list = userService.login(inputName, inputPwd);
			if (list.size() > 0) {
				// дSession
				HttpSession session = request.getSession();
				session.setAttribute("login", inputName);
				session.setMaxInactiveInterval(5*60);
				// дCookie
				if (remember != null && remember.equals("1")) {
					Cookie cookieName = new Cookie("name", inputName);
					Cookie cookiePassword = new Cookie("password", inputPwd);
					cookieName.setMaxAge(7 * 24 * 60 * 60);
					cookiePassword.setMaxAge(7 * 24 * 60 * 60);
					response.addCookie(cookieName);
					response.addCookie(cookiePassword);
				}
				// �ɹ���ת
				request.getRequestDispatcher("WEB-INF/main.html").forward(request, response);
			} else {
				// ʧ����ת
				request.setAttribute("err", "�û������������");
				request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		

	}

}
