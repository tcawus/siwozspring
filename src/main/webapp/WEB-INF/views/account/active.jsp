<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<jsp:include page="../fragments/headTag.jsp" />
<script>
	$(function() {
		$("#accordion").accordion({
			collapsible : true
		});
	});
</script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
<jsp:include page="../fragments/menu.jsp" />
<div id = "page">
	<div id="form">
		<form:form method="post" modelAttribute="activeRecord">
			<form:label path="name" />
			<span id=".inputLabel">Wybierz uzytkownika i role:</span>
			<form:select path="name" items="${name}" />
			<form:select path="role" items="${role}" />
			<form:errors path="name" cssClass="errors" />
			<input type="submit" value="Wybierz" />
		</form:form>
	</div>
</div>
	<jsp:include page="../fragments/footer.jsp" />
</body>