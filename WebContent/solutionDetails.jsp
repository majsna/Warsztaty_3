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

<h3>SOLUTION DETAILS</h3>

	
	<c:forEach var="s" items="${solutions}">

		<ul>
			<li>Id - ${s.id}</li>
			<li>Created - ${s.created}</li>
			<li>Updated - ${s.updated}</li>
			<li>User Id - ${s.userId}</li>
			<li>Exercise Id - ${s.exerciseId}</li>
			<li>Solution:<br> ${s.description}</li>
			
		</ul>

	</c:forEach>


</body>
</html>
<%@	include	file="footer.jsp"	%>