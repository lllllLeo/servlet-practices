package com.douzone.guestbook.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestBookDao;
import com.douzone.guestbook.vo.GuestBookVO;

public class GuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GuestBookController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("a");
		
		if ("add".equals(action)) {
			String name = request.getParameter("name");
			String password= request.getParameter("password");
			String message = request.getParameter("message");
			
			GuestBookVO vo = new GuestBookVO();
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			
			new GuestBookDao().insert(vo);
			response.sendRedirect("/gb");
			
		} else if ("deleteform".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
			rd.forward(request, response);
			
		} else if ("delete".equals(action)) {
			Long no = Long.parseLong(request.getParameter("no"));
			String password= request.getParameter("password");
			
			GuestBookVO vo = new GuestBookVO();
			vo.setNo(no);
			vo.setPassword(password);
			new GuestBookDao().delete(vo);
			
			response.sendRedirect("/gb");
		} else {
			List<GuestBookVO> list = new GuestBookDao().findAll();
			request.setAttribute("list", list); // request scope범위
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
