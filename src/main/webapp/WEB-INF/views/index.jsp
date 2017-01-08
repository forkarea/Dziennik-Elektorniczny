<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/css/menu.css" rel="stylesheet">
<link href="/resources/css/login.css" rel="stylesheet">
<script src="/resources/js/menu.js"></script>
<link rel="stylesheet" type="text/css"
	href="/resources/css/component.css" />
</head>
<body background="/resources/img/demo-2-bg.jpg">

<c:set var="role" scope="session" value="${rolePerLogin}"/>
<c:set var="user" scope="session" value="${user}"/>

	<ul class="topnav" id="myTopnav">
		<li><a href="/">Strona główna</a></li>
		<c:if test="${role eq 'user'}"><li><a href="/rates">Oceny</a></li></c:if>
		<c:if test="${role eq 'admin'}"><li><a href="/admin">Dodaj ocene</a></li></c:if>
		<li><a href="/contact">Kontakt</a></li>
		<li class="icon"><a href="javascript:void(0);"
			onclick="myFunction()">&#9776;</a></li>
	</ul>
	
	
	<h1 class="main-title"> Witamy w dzienniku elektronicznym, więcej informacji w zakładce info.</h1>
</body>
</html>