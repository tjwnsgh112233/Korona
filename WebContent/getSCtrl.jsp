<%@page import="korona.MainApp"%>
<%@page import="VO.KoronaVO"%>
<%@page import="DAO.DAO"%>
<%@page import="VO.KVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String no = request.getParameter("no");
    	String name = request.getParameter("name");
    	String k = request.getParameter("k");
    	String h = request.getParameter("h");
    
    	KoronaVO K = new KoronaVO();
    	
    	K.setName(name);
    	K.setConfirmation(h);
    	K.setDead(k);
    	
    	MainApp main = new MainApp();
    	
    	int cnt = main.add(K);
    	
    	if(cnt > 0){
    		response.sendRedirect("getSList.jsp");
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>