<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

	<div class="navigation">
  		<ul class="nav">
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}">Home</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/login">Logowanie</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/register">Rejestracja</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/employee/records">Kartoteka pacjenta</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/calendar">Kalendarz</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/account/active">Aktywacja konta </a>
  			</li>
  			<c:if test="${pageContext.request.userPrincipal.name != null}">
  				<li>
	  				<a href="javascript:formSubmit()">Wyloguj</a>
	  			</li>
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