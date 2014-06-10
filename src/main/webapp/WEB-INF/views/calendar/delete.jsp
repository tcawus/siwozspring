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
	<div class="container">
		<jsp:include page="../fragments/menu.jsp" />
		<br /> <br /> <br />
		<form:form method="post" modelAttribute="deleteVisitBean"
			class=".form-horizontal">
			<br />
			<br />
			<br />
			<div id="control-group" class=".control-group">
				<form:label path="idVisit" class=".control-label" />
				<span id=".inputLabel">Wizyta:</span>
				<form:select path="idVisit" items="${visits}" />
				<br /><br />
			</div>
			<input type="submit" value="Odwolaj" class="btn btn-primary" />
		</form:form>
		${result}
	</div>
</body>
</html>