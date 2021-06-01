<%@page import="DAO.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	DAO dao = new DAO();
    	String no = request.getParameter("no");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header id="header">
		<%@ include file="header.jsp" %>
	</header>
	
	<div id="menu">
		<%@ include file="menu.jsp" %>
	</div>
	
	<div id="main">
		<h2>검색</h2>
		<form action="getSCtrl.jsp" method="post" onsubmit="return ask()">
			나라이름 : <input type="text" id="no" name="no" value="">
			<button type="submit">검색</button>
			<table border="1">
				<tr>
					<th>나라이름</th><td><input type="text" id="name" name="name" value=""></td>
					<th>확진자수</th><td><input type="text" id="h" name="h" value=""></td>
					<th>사망자수</th><td><input type="text" id="k" name="k" value=""></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>