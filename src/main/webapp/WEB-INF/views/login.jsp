<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link href="/resources/css/login.css" rel="stylesheet">
<title>Strona logowania</title>
</head>
<body onload='document.loginForm.username.focus();'>
	<div id="login-box">
		<h2>Zaloguj sie do systemu</h2>

		<c:if test="${not empty error}">
			<div class="error">${error}</div>
		</c:if>
		<c:if test="${not empty msg}">
			<div class="msg">${msg}</div>
		</c:if>
		
		<form name='loginForm'
		    action="<c:url value='/check_credentials' />" method='POST'>

		    <table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='login' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
			        <td colspan='2'>
                                <input name="submit" type="submit" value="submit" />
                                </td>
			</tr>
		   </table>

		   <input type="hidden"
                     name="${_csrf.parameterName}" value="${_csrf.token}" />
		</form>
	</div>

</body>
</html>