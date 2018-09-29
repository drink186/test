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
 * Servlet implementation class UserController
 */
@WebServlet("/action/useraction.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// ÒÀÀµ×¢ÈëService
	private IUserService userService = new UserServiceImpl();

	/**
	 * Default constructor.
	 */
	public UserController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String opt = request.getParameter("opt");

		
			switch (opt) {
			// ×¢²á
			case "add":
				this.regist(request, response);
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
	 * ÓÃ»§×¢²á
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String inputName = request.getParameter("inputName");
		String inputPwd = request.getParameter("inputPassword");
		User user=new User(inputName, inputPwd);
		try {
			userService.regist(user);
			response.sendRedirect("login.jsp");
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		
	}
}
