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

	<c:set var="users" scope="session" value="${users}" />
	<c:set var="subjects" scope="session" value="${subjects}" />
	<c:set var="role" scope="session" value="${rolePerLogin}"/>

	<ul class="topnav" id="myTopnav">
		<li><a href="/">Strona główna</a></li>
		<c:if test="${role eq 'user'}"><li><a href="/rates">Oceny</a></li></c:if>
		<c:if test="${role eq 'admin'}"><li><a href="/admin">Dodaj ocene</a></li></c:if>
		<li><a href="/contact">Kontakt</a></li>
		<li><a href="/info">Info</a></li>
		<li class="icon"><a href="javascript:void(0);"
			onclick="myFunction()">&#9776;</a></li>
	</ul>


	<form action="/addRates" method="Post">
		<table>
			<tr>
				<th>Uczniowie</th>
				<th>Przedmioty</th>
				<th>Ocena</th>
			</tr>
			<tr>
				<td><select id="users_select" name="user">
						<c:forEach items="${users}" var="user">
							<option value="${user.username}">${user.username}</option>
						</c:forEach>
				</select></td>
				<td><select id="subject_select" name="subject">
						<c:forEach items="${subjects}" var="subject">
							<option value="${subject.subjectName}">${subject.subjectName}</option>
						</c:forEach>
				</select></td>
				<td><input type="text" name="rate" /></td>
			</tr>
		</table>
		<input type="submit" value="Submit" />
	</form>

	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />

</body>
</html>