<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/resources/css/menu.css" rel="stylesheet">
<script src="/resources/js/menu.js"></script>
<title>Insert title here</title>
</head>
<body>
<ul class="topnav" id="myTopnav">
  <li><a href="#home">Strona główna</a></li>
  <li><a href="#news">Oceny</a></li>
  <li><a href="#contact">Kontakt</a></li>
  <li><a href="#about">Info</a></li>
  <li class="icon">
    <a href="javascript:void(0);" onclick="myFunction()">&#9776;</a>
  </li>
</ul>
<c:forEach items="${userrates}" var="rates">
	${userName}
    ${rates.rate}
    ${rates.subject.subjectName}
</c:forEach>
</body>
</html>