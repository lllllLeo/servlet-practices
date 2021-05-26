package com.douzone.emaillist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.emaillist.dao.EmaillistDao;
import com.douzone.emaillist.vo.EmailVO;

public class EmaillistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmaillistController() { super(); }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post 방식으로 전달받는 파라미터 값의 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("a");
		
		if ("form".equals(action)) {
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/form.jsp");
			rd.forward(request, response);
		} else if ("add".equals(action)) {
			String firstName = request.getParameter("fn");
			String lastName = request.getParameter("ln");
			String email = request.getParameter("email");
			EmailVO vo = new EmailVO();
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);
			new EmaillistDao().insert(vo);
			
			response.sendRedirect(request.getContextPath() + "/el");
		} else {
			// default request(action)
			// 1. 요청 처리
			List<EmailVO> list = new EmaillistDao().findAll();
			// 2. request범위에 데이터(객체) 저장
			request.setAttribute("list", list); // request scope범위 
			// 3. view로 포워딩
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
