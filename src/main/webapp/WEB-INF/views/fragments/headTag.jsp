<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>SIWOZ Project</title>

    <spring:url value="/webjars/bootstrap/2.3.0/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>

    <spring:url value="/webjars/jquery/1.9.0/jquery.js" var="jQuery"/>
    <script src="${jQuery}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/js/jquery-ui-1.9.2.custom.js" var="jQueryUi"/>
    <script src="${jQueryUi}"></script>

    <spring:url value="/webjars/jquery-ui/1.9.2/css/smoothness/jquery-ui-1.9.2.custom.css" var="jQueryUiCss"/>
    <link href="${jQueryUiCss}" rel="stylesheet"></link>
</head>


