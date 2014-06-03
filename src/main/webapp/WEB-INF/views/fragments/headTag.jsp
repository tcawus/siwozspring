<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page pageEncoding="UTF-8"%>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>SIWOZ Project</title>


<!--  
<script src="../../jquery-1.10.2.js"></script>
<script src="../../ui/jquery.ui.core.js"></script>
<script src="../../ui/jquery.ui.widget.js"></script>
<script src="../../ui/jquery.ui.accordion.js"></script>
-->

<spring:url value="/resources/js/jquery-1.10.2.js" var="jQuery" />
<script src="${jQuery}"></script>
<spring:url value="/resources/js/jquery-ui-1.10.4.custom.js"
	var="jQueryUI" />
<script src="${jQueryUI}"></script>




<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/start/jquery-ui-1.10.4.custom.css" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />



