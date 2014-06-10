<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><jsp:include page="../fragments/headTag.jsp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<div id="page">
		<div class="container">
			<jsp:include page="../fragments/menu.jsp" />
			<br /> <br /> <br />
			<form:form method="post" modelAttribute="newVisitBean"
				class=".form-horizontal">
				<div id="control-group" class=".control-group">
					<form:label path="patients" class=".control-label" />
					<span id=".inputLabel">Pacjent:</span>
					<form:select path="patients" items="${patients}" />
					<form:label path="title" class=".control-label" />
					<br /> <span id=".inputLabel">Cel wizyty:</span>
					<form:input path="title" placeholder="Cel Wizyty" />
					<form:errors path="title" cssClass="errors" />
					<br />
					<form:label path="description" class=".control-label" />
					<span id=".inputLabel">Opis:</span>
					<form:textarea path="description" placeholder="Opis" />
					<form:errors path="description" cssClass="errors" />
					<br />
					<form:label path="from" class=".control-label" />
					<span id=".inputLabel">Data(w formacie yyyy-MM-dd HH:mm):</span> <br />
					<form:input path="from" placeholder="Data" />
					<form:errors path="from" cssClass="errors" />
					<br />
				</div>
				<input type="submit" value="Dodaj" class="btn btn-primary" />
			</form:form>
			${result}
		</div>
	</div>
</body>
</html>