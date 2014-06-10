<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html>
<head>
<jsp:include page="fragments/headTag.jsp" />
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/style.css" />
</head>
<body>

	<jsp:include page="fragments/menu.jsp" />
	<div id="page">

		<div class="container">
			<!-- Example row of columns -->

			<c:if test="${pageContext.request.userPrincipal.name == null}">

				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<div class="row">
					<div class="col-md-4">
						<h2>Logowanie</h2>
						<p>Administrator oraz uzytkownik moze zalogowac sie do
							systemu.</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/login"
								role="button">Logowanie &raquo;</a>
						</p>
					</div>
					<div class="col-md-4">
						<h2>Rejestracja</h2>
						<p>Jesli pacjent nie ma jeszcze konta to moze zarejestrowac
							sie on tutaj.</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/rejestracja"
								role="button">Rejestracja &raquo;</a>
						</p>
					</div>
					<div class="col-md-4">
						<h2>Kalendarz</h2>
						<p>Podglad kalendarza.</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/calendar"
								role="button">Kalendarz &raquo;</a>
						</p>
					</div>
				</div>
			</c:if>
			<security:authorize access="hasRole('ROLE_ADMIN')">
				<c:set var="contextPath" value="${pageContext.request.contextPath}" />
				<div class="row">
					<div class="col-md-4">
						<h2>Dodaj wizyte</h2>
						<p>Aby zapisac pacjenta na wizyte kliknij w przycisk "Zapisz".</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/calendar/add"
								role="button">Zapisz &raquo;</a>
						</p>
					</div>
					<div class="col-md-4">
						<h2>Kartoteki pacjentow</h2>
						<p>Aby miec wglad w kartoteke pacjenta kliknij przycisk
							ponizej.</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/employee/records"
								role="button">Kartoteka pacjenta &raquo;</a>
						</p>
					</div>
					<div class="col-md-4">
						<h2>Stworz konto</h2>
						<p>Aby utworzyc nowe konto kliknij w przycisk ponizej.</p>
						<p>
							<a class="btn btn-default" href="${contextPath}/register"
								role="button">Stworz konto &raquo;</a>
						</p>
					</div>
				</div>
			</security:authorize>

			<hr>

			<jsp:include page="fragments/footer.jsp" />
		</div>
</body>
</html>