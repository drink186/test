package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jbit.util.Page;

import com.hotel.entity.Guest;
import com.hotel.entity.Room;
import com.hotel.entity.RoomState;
import com.hotel.entity.RoomType;
import com.hotel.enums.State;
import com.hotel.service.IGuestService;
import com.hotel.service.IRoomTypeService;
import com.hotel.service.impl.GuestServiceImpl;
import com.hotel.service.impl.RoomTypeServiceImpl;

/**
 * Servlet implementation class GuestController
 */
@WebServlet("/action/guestaction.do")
public class GuestController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomTypeService roomTypeService=new  RoomTypeServiceImpl();
	private IGuestService guestService=new GuestServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String opt=request.getParameter("opt");
		try {
			switch(opt) {
			case "add":
				this.regist(request, response);
				break;
			case "url":
				this.goUrl(request, response);
				break;
			case "query":
				this.findAnd(request, response);
				break;
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	/**
	 * 登记
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void regist(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		
			
			String name = request.getParameter("name");
			String idcard = request.getParameter("idcard");
			String inDate = request.getParameter("indate");
			String deposit = request.getParameter("deposit");
			String roomId = request.getParameter("room");
			String number=request.getParameter("number");
			
			RoomState roomState=new RoomState();
			roomState.setId(State.FULL.getId());
			Room room=new Room();
			room.setId(Integer.parseInt(roomId));
			room.setRoomState(roomState);
			room.setNumber(Integer.parseInt(number));
			Guest guest=new Guest(name, idcard, room, inDate,Double.parseDouble(deposit));
			int key=guestService.regist(guest);
			Guest newGuest=guestService.findById(key);
			
			request.setAttribute("guest", newGuest);
			request.getRequestDispatcher("../WEB-INF/reginfo.jsp").forward(request, response);
		
	}
	/**
	 * 映射URL
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void goUrl(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//读取房间类型数据
		List<RoomType> list=roomTypeService.findAll();
		request.setAttribute("roomTypes", list);
		request.getRequestDispatcher("../WEB-INF/register.jsp").forward(request, response);
	}
	
	/**
	 * 按条件查询
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void findAnd(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String name=request.getParameter("name");
		
		int room=-1,currentPage=1,pageSize=10;
		String strPage=request.getParameter("page");
		String strPageSize=request.getParameter("pageSize");
		String strRoom=request.getParameter("room");
		if(strRoom!=null && strRoom.length()>0) {
			room=Integer.parseInt(request.getParameter("room"));
		}
		
		if(strPage!=null && strPage.length()>0) {
			currentPage=Integer.parseInt(request.getParameter("page"));
		}
		if(strPageSize!=null && strPageSize.length()>0) {
			pageSize=Integer.parseInt(request.getParameter("pageSize"));
		}
		
		List<Guest> list=guestService.findAnd(name, room, currentPage, pageSize);
	    int count=guestService.count(name, room);
		Page<Guest> page=new Page<>(currentPage, pageSize, count, list);
	    request.setAttribute("page", page);
	    request.setAttribute("name", name);
	    request.setAttribute("room", room);
		request.getRequestDispatcher("../WEB-INF/guestlist.jsp").forward(request, response);
	}
	

}
