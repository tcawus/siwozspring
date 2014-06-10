<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@page session="true"%>

<div class="navbar navbar-inverse navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container">
			<div class="navbar-body">
				<ul class="nav">
					<li><c:set var="contextPath"
							value="${pageContext.request.contextPath}" /> <a
						href="${contextPath}" class="navbar-brand">Home</a></li>
					<c:if test="${pageContext.request.userPrincipal.name == null}">
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/login" class="navbar-brand">Logowanie</a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/register" class="navbar-brand">Rejestracja</a></li>
					</c:if>
					<security:authorize access="hasRole('ROLE_ADMIN')">
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/calendar/add" class="navbar-brand">Dodaj
								wizyte</a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/calendar/delete" class="navbar-brand">Odwolaj
								wizyte</a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/employee/records" class="navbar-brand">Kartoteka
								pacjenta</a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/account/active" class="navbar-brand">Aktywacja
								konta </a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/employee/unsubscribe" class="navbar-brand">Wypisanie
								pacjenta </a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/exportcsv/" class="navbar-brand">Eksport
								kalendarza do CSV</a></li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_USER')">
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/calendar/" target="_blank"
							class="navbar-brand">Moj kalendarz</a></li>
						<li><c:set var="contextPath"
								value="${pageContext.request.contextPath}" /> <a
							href="${contextPath}/visits/" class="navbar-brand">Przebieg
								historycznych wizyt</a></li>
					</security:authorize>
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a href="javascript:formSubmit()" class="navbar-brand">
								Wyloguj</a></li>
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
					</c:if>
				</ul>
			</div>
		</div>
	</div>
</div>
