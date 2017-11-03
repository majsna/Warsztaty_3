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

<h3>USERS ADMINISTRATIVE PANEL</h3>

	
	<table border=1>
	<tr>
		<th>ID</th>
		<th>USER NAME</th>
		<th>E-MAIL</th>
		<th>GROUP ID</th>
		<th>EDITION</th>
	</tr>	
	<c:forEach var="u" items="${users}">

		<tr>
			<td>${u.id}</td>
			<td>${u.username}</td>
			<td>${u.email}</td>
			<td>${u.groupId}
			<td><a href='./EditUser?id=${u.id}'>EDIT</a></td>
		</tr>

	</c:forEach>
</table>

<h4>ADD NEW USER</h4>
	
	<form action='./AddUser' method='post'>
	
		NAME:<br>
		<input type='text' name='newName'><br>
		E-MAIL:<br>
		<input type='text' name='newMail'><br>
		GROUP ID:<br>
		<input type='number' name='newGroup'><br>
		PASSWORD:<br>
		<input type='text' name='newPassword'><br>
		<input type='submit' value='Submit'>
	
	</form>

</body>
</html>
<%@	include	file="footer.jsp"	%>