<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />

<spring:url value="/resources/js/jquery-1.10.2.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/resources/js/jquery-ui-1.10.4.custom.js"
	var="jQueryUI" />
<script src="${jQueryUI}"></script>
<spring:url value="/resources/bootstrap/js/bootstrap.min.js"
	var="bootstrap" />
<script src="${bootstrap}"></script>

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/css/bootstrap.min.css" />
