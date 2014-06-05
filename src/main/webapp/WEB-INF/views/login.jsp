<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<style>
.error {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #a94442;
	background-color: #f2dede;
	border-color: #ebccd1;
}

.msg {
	padding: 15px;
	margin-bottom: 20px;
	border: 1px solid transparent;
	border-radius: 4px;
	color: #31708f;
	background-color: #d9edf7;
	border-color: #bce8f1;
}

#login-box {
	width: 300px;
	padding: 20px;
	margin: 100px auto;
	background: #fff;
	-webkit-border-radius: 2px;
	-moz-border-radius: 2px;
	border: 1px solid #000;
}


</style>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body onload='document.loginForm.username.focus();'>
<jsp:include page="fragments/menu.jsp" />
<div id = "page">
	<h1>Gabinet stomatologiczny</h1>
	
	<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
			<c:url value="/j_spring_security_logout" var="logoutUrl" />
			<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			</form>
	
			<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
			</script>
	</c:if>

	<c:if test="${pageContext.request.userPrincipal.name == null}">
		<div id="login-box">
	
			<h3>Podaj nazwe uzytkownika i haslo</h3>
	
			<c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
	
			<form name='loginForm'
				action="<c:url value='/j_spring_security_check' />" method='POST'>
	
				<table>
					<tr>
						<td>Nazwa uzytkownika:</td>
						<td><input type='text' name='username'></td>
					</tr>
					<tr>
						<td>Haslo:</td>
						<td><input type='password' name='password' /></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit"
							value="submit" /></td>
					</tr>
					<h:link value="Nie masz konta? Zarejestruj się tutaj!" outcome="register" />
				</table>
	
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
	
			</form>
		</div>
</c:if>
</div>



</body>
</html>