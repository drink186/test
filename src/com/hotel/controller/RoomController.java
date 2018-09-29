package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jbit.util.Page;

import com.alibaba.fastjson.JSON;
import com.hotel.entity.Room;
import com.hotel.entity.RoomType;
import com.hotel.enums.State;
import com.hotel.service.IRoomService;
import com.hotel.service.IRoomTypeService;
import com.hotel.service.impl.RoomServiceImpl;
import com.hotel.service.impl.RoomTypeServiceImpl;

/**
 * Servlet implementation class RoomController
 */
@WebServlet("/action/roomaction.do")
public class RoomController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomService roomService = new RoomServiceImpl();
	private IRoomTypeService roomTypeService = new RoomTypeServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomController() {
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
		switch (opt) {
		// �����б�
		case "list":
			this.findAll(request, response);
			break;
		// ���ҳ��ӳ��
		case "addurl":
			this.goAddUrl(request, response);
			break;
		// ������ݴ���
		case "add":
			this.add(request, response);
			break;
		// �޸�ҳ��ӳ��
		case "editurl":
			this.goEditUrl(request, response);
			break;
		// �޸����ݴ���
		case "edit":
			this.edit(request, response);
			break;
		// �����ͺ�״̬��ѯ
		case "type":
			this.findByRoomType(request, response);
			break;

		// ��ѯ���з���
		case "all":
			this.find(request, response);
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
	 * �����б�
	 * 
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findAll(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ȡ��������ǰҳ��ҳ���С
		int currentPage = 1, pageSize = 10;
		String inputCurrentPage = request.getParameter("page");
		String inputPageSize = request.getParameter("pageSize");
		if (inputCurrentPage != null) {
			currentPage = Integer.parseInt(inputCurrentPage);
		}
		if (inputPageSize != null) {
			pageSize = Integer.parseInt(inputPageSize);
		}
		try {
			// ȡҳ������
			List<Room> content = roomService.findAll(currentPage, pageSize);
			// ȡ�ܼ�¼��
			int count = roomService.count();
			// ��װ���ݵ�ҳ��
			Page<Room> page = new Page<>(currentPage, pageSize, count, content);
			// ת�����ݵ�ҳ��
			request.setAttribute("page", page);
			request.getRequestDispatcher("../WEB-INF/roomlist.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * ���ҳ��ӳ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goAddUrl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ȡ�ͷ�����
		try {
			List<RoomType> list = roomTypeService.findAll();
			request.setAttribute("roomTypes", list);
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		request.setAttribute("opt", "add");
		request.getRequestDispatcher("../WEB-INF/roomadd.jsp").forward(request, response);
	}

	/**
	 * �������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		int roomTypeId = Integer.parseInt(request.getParameter("roomType"));

		Room room = new Room();
		room.setDescription(description);
		RoomType roomType = new RoomType();
		roomType.setId(roomTypeId);
		room.setRoomType(roomType);

		try {
			// �������
			roomService.add(room);
			response.sendRedirect("?opt=list");
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * �޸�ҳ��ӳ��
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void goEditUrl(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("roomId"));
		try {
			// ȡ�ͷ�����
			List<RoomType> list = roomTypeService.findAll();
			request.setAttribute("roomTypes", list);
			// ȡ�޸ĵ�����
			Room room = roomService.findById(id);
			request.setAttribute("room", room);
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
		request.setAttribute("opt", "edit");
		request.getRequestDispatcher("../WEB-INF/roomadd.jsp").forward(request, response);
	}

	/**
	 * �������
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String description = request.getParameter("description");
		int type = Integer.parseInt(request.getParameter("roomType"));
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			// �޸�����
			roomService.update(description, type, id);
			response.sendRedirect("?opt=list");
		} catch (Exception e) {

			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	/**
	 * �����ͺ�״̬��ѯ
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void findByRoomType(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int type = Integer.parseInt(request.getParameter("roomType"));

		try {

			List<Room> list = roomService.findByRoomType(type, State.EMPTY.getId());
			String json = JSON.toJSONString(list);
			PrintWriter out = response.getWriter();
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}
	/**
	 * ��ѯ���з���
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void find(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Room> list = roomService.findAll();
			String json = JSON.toJSONString(list);
			PrintWriter out = response.getWriter();
			out.print(json);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
