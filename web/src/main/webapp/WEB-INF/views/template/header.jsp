<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<c:set var="baseUrl" value="${pageContext.request.contextPath}" />

<header>

	<nav class="nav-extended green">
		<div class="nav-wrapper container">
			<ul id="nav-mobile" class="right">
                <sec:authorize access="isAnonymous()">
					<li><a href="${pageContext.request.contextPath}/login"><mytaglib:i18n
								key="header.login" /></a></li>
					<li><a href="${pageContext.request.contextPath}/user/add"><mytaglib:i18n
								key="header.register" /></a></li>
                </sec:authorize>
				<sec:authorize access="isAuthenticated()">
					<li>You are now logged in as <sec:authentication property="principal" />, <sec:authentication
							property="authorities" />
					</li>
					<li><a href="${baseUrl}/execute_logout">Logout</a></li>
				</sec:authorize>
			</ul>
		</div>
		<div class="nav-wrapper container">
			<ul id="nav-mobile" class="left hide-on-med-and-down">
				<li><a href="${pageContext.request.contextPath}/home"><mytaglib:i18n key="nav.home" /></a></li>
				<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="${pageContext.request.contextPath}/car">Cars</a></li>
					<li><a href="${pageContext.request.contextPath}/user">Users</a></li>
				</sec:authorize>
				<sec:authorize access="hasRole('ROLE_USER')">
                	<li><a href="${pageContext.request.contextPath}/car">Cars</a></li>
                </sec:authorize>
			</ul>
		</div>
	</nav>
</header>