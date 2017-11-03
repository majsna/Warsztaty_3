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

	<h4>EDIT USER FORM</h4>
 	<form action='./EditUser' method='post'>
 		NEW NAME:<br>
 		<input type='text' name='newName'><br>
 		NEW E-MAIL:<br>
 		<input type='text' name='newEmail'><br>
 		NEW GROUP ID:<br>
 		<input type='number' name='newGroup'><br>
 		NEW PASSWORD:<br>
 		<input type='text' name='newPassword'><br>
 		
 		<input type='hidden' name='id' value='${userId}'>
 		<input type='submit' value ='Submit'>
 	</form>

</body>
</html>
<%@	include	file="footer.jsp"	%>