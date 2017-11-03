<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@	include	file="header.jsp"	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3>USER DETAILS</h3>
<ul>
	<li>Id: ${user.id}</li>
	<li>Name: ${user.username}</li>
	<li>E-mail: ${user.email}</li>
	<li>Group Id: ${user.groupId}</li>
</ul>

<h4>USERS SOLUTIONS</h4>
<table border=1>
	<tr>
		<th>ID</th>
		<th>CREATED</th>
		<th>UPDATED</th>
		<th>USER ID</th>
		<th>EXERCISE ID</th>
		<th>SOLUTION</th>
	</tr>	
	<c:forEach var="s" items="${solutions}">

		<tr>
			<td>${s.id}</td>
			<td>${s.created}</td>
			<td>${s.updated}</td>
			<td>${s.userId}</td>
			<td>${s.exerciseId}</td>
			<td>${s.description}</td>
		</tr>

	</c:forEach>
</table>

</body>
</html>
<%@	include	file="footer.jsp"	%>