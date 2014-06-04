<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><jsp:include page="fragments/headTag.jsp" /></head>
<body>
<jsp:include page="fragments/menu.jsp" />

	<div id="form">
		<form:form method="post" modelAttribute="registerBean">
			<form:label path="name" />
			<span id=".inputLabel">Imie:</span>
			<form:input path="name" />
			<form:errors path="name" cssClass="errors" />
			<br />
			<form:label path="surname" />
			<span id=".inputLabel">Nazwisko:</span>
			<form:input path="surname" />
			<form:errors path="surname" cssClass="errors" />
			<br />
			<form:label path="username" />
			<span id=".inputLabel">Email:</span>
			<form:input path="username" />
			<form:errors path="username" cssClass="errors" />
			<br />
			<form:label path="pesel" />
			<span id=".inputLabel">Pesel(opcjonalnie):</span>
			<form:input path="pesel" />
			<form:errors path="pesel" cssClass="errors" />
			<br />
			<form:label path="password" />
			<span id=".inputLabel">Haslo:</span>
			<form:password path="password" />
			<form:errors path="password" cssClass="errors" />
			<br />
			<form:label path="passwordVerify" />
			<span id=".inputLabel">Powtorz haslo:</span>
			<form:password path="passwordVerify" />
			<form:errors path="passwordVerify" cssClass="errors" />
			<br />
			<form:label path="userType" />
			<span id=".inputLabel">Rodzaj wspolpracy:</span>
			<form:select path="userType" items="${userType}" />
			<form:errors path="userType" cssClass="errors" />
			<br />
			<input type="submit" value="Zarejestruj" />
		</form:form>
		${registrationResult}
	</div>
	<jsp:include page="fragments/footer.jsp" />
</body>