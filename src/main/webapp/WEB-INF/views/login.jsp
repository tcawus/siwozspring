<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@page session="true"%>
<html>
<head>
<title>Login Page</title>
<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body onload='document.loginForm.username.focus();'>
<div class="container">
<jsp:include page="fragments/menu.jsp" />
<div id = "page">
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<h4>Jestes juz zalogowany!</h4>
</c:if>
<c:if test="${pageContext.request.userPrincipal.name == null}">
	<div id = "tytul1">
		<h4>Gabinet stomatologiczny</h4>
	</div>
	<form name='loginForm'action="<c:url value='/j_spring_security_check' />" method='POST'>
	<fieldset>
	<div class="control-group">
    <label class="control-label" for="username">Uzytkownik:
    <input type="text" name="username" placeholder="Uzytkownik">
    </label>
    </div>
    <div class="control-group">
    <label class="control-label" for="password">Haslo:
    <input type="password" name="password" placeholder="Haslo">
    </label>
    </div>
		  <c:if test="${not empty error}">
				<div class="error">${error}</div>
			</c:if>
			<c:if test="${not empty msg}">
				<div class="msg">${msg}</div>
			</c:if>
	 <div class="control-group">
      <button type="submit" class="btn btn-primary" value="submit">Zaloguj</button>
     <div class="control-group">
      <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
<div id = "dol1">
    <a href="${contextPath}/register">Nie masz konta? Zarejestruj sie tutaj!</a>
</div>
  </fieldset>
</form>
	
</c:if>
</div>

</div>

</body>
</html>