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

	<h4>EDIT GROUP FORM</h4>
 	<form action='./EditGroup' method='post'>
 		NEW NAME:<br>
 		<input type='text' name=name><br>
 		<input type='hidden' name='grId' value='${grId}'>
 		<input type='submit'>
 	</form>

</body>
</html>
<%@	include	file="footer.jsp"	%>