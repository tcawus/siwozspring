<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
<body>

	<c:forEach var="person" items="${persons}">
		<li><c:out value="${person.name}" /> <c:out
				value="${person.surname}" /> <c:out value="${person.pass}" /> <c:out
				value="${person.pesel}" /></li>
	</c:forEach>

	<jsp:include page="fragments/footer.jsp" />
</body>