<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
<div class="container">
<jsp:include page="fragments/menu.jsp" />

<div id = "page">
<div id = "tytul1">
<h4>Zarejestruj</h4>
</div>
	<div id="form" class="control-group">
		<form:form method="post" modelAttribute="registerBean" class=".form-horizontal">
		<div id = "control-group" class=".control-group">
			<form:label path="name" class=".control-label" />
			<span id=".inputLabel">Imie:</span>
			<form:input path="name" placeholder="Imie" />
			<form:errors path="name" cssClass="errors" />
			<br />
			<form:label path="surname" class=".control-label" />
			<span id=".inputLabel">Nazwisko:</span>
			<form:input path="surname" placeholder="Nazwisko"/>
			<form:errors path="surname" cssClass="errors" />
			<br />
			<form:label path="username" class=".control-label" />
			<span id=".inputLabel">Email:</span>
			<form:input path="username" placeholder="Email" />
			<form:errors path="username" cssClass="errors" />
			<br />
			<form:label path="pesel" class=".control-label" />
			<span id=".inputLabel">Pesel(opcjonalnie):</span>
			<form:input path="pesel" placeholder="Pesel"/>
			<form:errors path="pesel" cssClass="errors" />
			<br />
			<form:label path="password" class=".control-label" />
			<span id=".inputLabel">Haslo:</span>
			<form:password path="password" placeholder="Haslo"/>
			<form:errors path="password" cssClass="errors" />
			<br />
			<form:label path="passwordVerify" class=".control-label" />
			<span id=".inputLabel">Powtorz haslo:</span>
			<form:password path="passwordVerify" placeholder="Haslo" />
			<form:errors path="passwordVerify" cssClass="errors" />
			<br />
			<form:label path="userType" class=".control-label" />
			<span id=".inputLabel">Rodzaj wspolpracy:</span>
			<form:select path="userType" items="${userType}" />
			<form:errors path="userType" cssClass="errors" />
			<br />
		</div>
		<div class="controls">
			<input type="submit" value="Zarejestruj" class="btn btn-primary" />
		</div>
		</form:form>
		${registrationResult}
	</div>
</div>
	<jsp:include page="fragments/footer.jsp" />
</div>
</body>