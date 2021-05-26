<%@page import="com.douzone.guestbook.dao.GuestBookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestBookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");
	String no = request.getParameter("no");
	String password= request.getParameter("password");
	
	GuestBookVO vo = new GuestBookVO();
	vo.setNo(Long.parseLong(no));
	vo.setPassword(password);
	
	boolean result = new GuestBookDao().delete(vo);
	
	if(result) {
		response.sendRedirect(request.getContextPath());
	}
%>
<script>
	alert("비밀번호가 틀렸습니다");
	history.go(-1);
</script>