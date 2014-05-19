<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<jsp:include page="../fragments/headTag.jsp" />
<body>
	<div id="form">
		<!-- <form:form method="post" modelAttribute="accountBean">
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
			<form:label path="email" />
			<span id=".inputLabel">Email:</span>
			<form:input path="email" />
			<form:errors path="email" cssClass="errors" />
			<br />
			<form:label path="pass" />
			<span id=".inputLabel">Hasło:</span>
			<form:password path="pass" />
			<form:errors path="pass" cssClass="errors" />
			<br />
			<form:label path="passVerify" />
			<span id=".inputLabel">Powtórz hasło:</span>
			<form:password path="passVerify" />
			<form:errors path="passVerify" cssClass="errors" />
			<br />
			<form:label path="userType" />
			<span id=".inputLabel">Rodzaj współpracy:</span>
			<form:select path="userType" items="${userType}" />
			<form:errors path="userType" cssClass="errors" />
			<br />
			<input type="submit" value="Zarejestruj" />
		</form:form> 
		${registrationResult}-->
	</div>
	<form:form method="post" action="/delete"
		onsubmit="javascript:alert('Konto pomyślnie usunięte');">
		<input type="submit" value="Usuń konto" />
	</form:form>
	<jsp:include page="../fragments/footer.jsp" />
</body>