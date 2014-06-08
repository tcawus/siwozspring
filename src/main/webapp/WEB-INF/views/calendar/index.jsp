<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Calendar</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>
	<jsp:include page="../fragments/menu.jsp" />
	<form:form method="post" action="redirect" class=".form-horizontal">
		<input type="submit" value="Przenies mnie do mojego kalendarza"
			class="btn btn-primary" />
	</form:form>
</body>
</html>