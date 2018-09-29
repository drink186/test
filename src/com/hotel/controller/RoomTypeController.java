package com.hotel.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.hotel.entity.RoomType;
import com.hotel.service.IRoomTypeService;
import com.hotel.service.impl.RoomTypeServiceImpl;

/**
 * Servlet implementation class RoomTypeController
 */
@WebServlet("/action/roomtypeaction.do")
public class RoomTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IRoomTypeService roomTypeService=new RoomTypeServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RoomTypeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opt=request.getParameter("opt");
		switch(opt) {
		//添加数据
		case "add":
			this.add(request, response);
			break;
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
	 * 添加数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void add(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		int beds=Integer.parseInt(request.getParameter("beds"));
		double price=Double.parseDouble(request.getParameter("price"));
		RoomType roomType=new RoomType(id, name, beds, price);
		try {
			//添加数据
			roomTypeService.add(roomType);
			//查询数据
			roomType=roomTypeService.findById(id);
			//转换成json
			PrintWriter out=response.getWriter();
			String json=JSON.toJSONString(roomType,SerializerFeature.PrettyFormat);
			out.print(json);
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

}
