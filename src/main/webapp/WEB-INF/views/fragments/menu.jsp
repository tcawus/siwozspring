	<div class="navigation">
  		<ul class="nav">
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/siwoz/login">Logowanie</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/siwoz/register">Rejestracja</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/siwoz/employee/records">Kartoteka pacjenta</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/siwoz/calendar">Kalendarz</a>
  			</li>
  			<li>
  				<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
  				<a href="${contextPath}/siwoz/account/active">Aktywacja konta </a>
  			</li>
  		</ul>
  	</div>