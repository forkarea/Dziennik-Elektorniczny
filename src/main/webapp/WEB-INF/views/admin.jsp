<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/css/menu.css" rel="stylesheet">
<script src="/resources/js/menu.js"></script>
</head>
<body>

<c:set var="users" scope="session" value="${users}"/>
<c:set var="subjects" scope="session" value="${subjects}"/>

	<ul class="topnav" id="myTopnav">
		<li><a href="/">Strona główna</a></li>
		<li><a href="/rates">Oceny</a></li>
		<li><a href="/contact">Kontakt</a></li>
		<li><a href="/info">Info</a></li>
		<li class="icon"><a href="javascript:void(0);"
			onclick="myFunction()">&#9776;</a></li>
	</ul>
	
	<form action="/addRates" method="Post">
	
		<select id="users_select" name="user">
			<c:forEach items="${users}" var="user">
			<option value="${user.username}">${user.username}</option>
			</c:forEach>
		</select>
	
		<select id="subject_select" name="subject">
			<c:forEach items="${subjects}" var="subject">
			<option value="${subject.subjectName}">${subject.subjectName}</option>
			</c:forEach>
		</select>
	
		Ocena: <input type="text" name="rate" />
	
		<input type="submit" value="Submit" />
	</form>
	
		<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
		
</body>
</html>