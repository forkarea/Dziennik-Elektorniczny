<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/css/menu.css" rel="stylesheet">
<script src="/resources/js/menu.js"></script>
<title>Insert title here</title>
</head>
<body>

	<c:set var="role" scope="session" value="${rolePerLogin}" />
	<c:set var="user" scope="session" value="${user}" />

	<ul class="topnav" id="myTopnav">
		<li><a href="/">Strona główna</a></li>
		<c:if test="${role eq 'user'}">
			<li><a href="/rates">Oceny</a></li>
		</c:if>
		<c:if test="${role eq 'admin'}">
			<li><a href="/admin">Dodaj ocene</a></li>
		</c:if>
		<li><a href="/contact">Kontakt</a></li>
		<li><a href="/info">Info</a></li>
		<li class="icon"><a href="javascript:void(0);"
			onclick="myFunction()">&#9776;</a></li>
	</ul>
	<table style="width: 30%">
		<tr>
			<th>Przedmiot</th>
			<th>Ocena</th>
		</tr>
		<c:forEach items="${userrates}" var="rates">
			<tr>
				<td><center>${rates.subject.subjectName}</center></td>
				<td><center>${rates.rate}</center></td>
			</tr>
		</c:forEach>
	</table>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

</body>
</html>