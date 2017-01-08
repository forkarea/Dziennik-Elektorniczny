<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="no-js">
<head>
<link href="/resources/css/login.css" rel="stylesheet">
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Dziennik elektroniczny</title>
<link rel="shortcut icon" href="/resources/ico/favicon.ico">
<link rel="stylesheet" type="text/css"
	href="/resources/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="/resources/css/demo.css" />
<link rel="stylesheet" type="text/css"
	href="/resources/css/component.css" />
<link href='http://fonts.googleapis.com/css?family=Raleway:200,400,800'
	rel='stylesheet' type='text/css'>
</head>
<body onload='document.loginForm.username.focus();'>

	<div class="container demo-1">
		<div class="content">
			<div id="large-header" class="large-header">
				<canvas id="demo-canvas"></canvas>
				<h1 class="main-title">
					Dziennik <span class="thin">Elektroniczny</span>
					<div>
						<c:if test="${not empty error}">
							<div class="error">${error}</div>
						</c:if>
						<c:if test="${not empty msg}">
							<div class="msg">${msg}</div>
						</c:if>
						<form name='loginForm'
							action="<c:url value='/check_credentials' />" method='POST'>

							<center>
								<table>
									<tr>
										<td><b><font color="white">User:</font></b></td>
										<td><input type='text' name='login' value=''></td>
									</tr>
									<tr>
										<td><b><font color="white">Password:</font></b></td>
										<td><input type='password' name='password' /></td>
									</tr>
									<tr>
										<td colspan='2'><center><input name="submit" type="submit"
											value="submit" /></center></td>
									</tr>
								</table>
							</center>

							<input type="hidden" name="${_csrf.parameterName}"
								value="${_csrf.token}" />
						</form>
					</div>

				</h1>
			</div>

			<script src="/resources/js/TweenLite.min.js"></script>
			<script src="/resources/js/EasePack.min.js"></script>
			<script src="/resources/js/rAF.js"></script>
			<script src="/resources/js/demo-1.js"></script>

		</div>
	</div>
</body>
</html>