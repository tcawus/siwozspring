<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
 
	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/j_spring_security_logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>
 
		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>
 
<<<<<<< HEAD
	</sec:authorize>
	<jsp:include page="fragments/footer.jsp" />
=======
<<<<<<< HEAD
	</sec:authorize>
	<jsp:include page="fragments/footer.jsp" />
=======
 
	</sec:authorize>
>>>>>>> 869d56bdf6cb7370c2ba831a346abc5e56accf66
>>>>>>> c356beec22a4b6c0471bc99acfe4ece14d02708f
</body>
</html>