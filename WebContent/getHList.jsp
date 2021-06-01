<%@page import="VO.KoronaVO"%>
<%@page import="korona.MainApp"%>
<%@page import="VO.KVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.DAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	DAO dao = new DAO();
    	ArrayList<KVO> list = dao.H();
    	MainApp main = new MainApp();
    	KoronaVO Ko = main.K();
    	KoronaVO Ch = main.china();
    	KoronaVO Ja = main.Japan();
    	KoronaVO Ho = main.Hong_Kong();
    	KoronaVO Ta = main.Taiwan();
    	KoronaVO Si = main.Singapore();
    	KoronaVO Th = main.Thailan();
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
		<h2>코로나 국가별 확진자등수</h2>
		<table border="1">
			<tr>
				<th>나라이름</th>
				<th>확진자수</th>
				<th>사망자수</th>		
			</tr>
			<tr>
				<td>한국</td>
				<td><%=Ko.getConfirmation() %>명</td>
				<td><%=Ko.getDead() %>명</td>
			</tr>
			<tr>
				<td>중국</td>
				<td><%=Ch.getConfirmation() %>명</td>
				<td><%=Ch.getDead() %>명</td>
			</tr>
			<tr>
				<td>일본</td>
				<td><%=Ja.getConfirmation() %>명</td>
				<td><%=Ja.getDead() %>명</td>
			</tr>
			<tr>
				<td>홍콩</td>
				<td><%=Ho.getConfirmation() %>명</td>
				<td><%=Ho.getDead() %>명</td>
			</tr>
			<tr>
				<td>대만</td>
				<td><%=Ta.getConfirmation() %>명</td>
				<td><%=Ta.getDead() %>명</td>
			</tr>
			<tr>
				<td>싱가포르</td>
				<td><%=Si.getConfirmation() %>명</td>
				<td><%=Si.getDead() %>명</td>
			</tr>
			<tr>
				<td>태국</td>
				<td><%=Th.getConfirmation() %>명</td>
				<td><%=Th.getDead() %>명</td>
			</tr>
		</table>
	</div>
</body>
</html>