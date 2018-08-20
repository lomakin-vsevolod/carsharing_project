<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>
<h4 class="header">
	<mytaglib:i18n key="info.header" />
</h4>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/car" />

<div class="row">
	<div class="col s6">
		<p>
			<mytaglib:i18n key="info.brand" />
			-
			<c:out value="${formModel.brand}"></c:out>
		</p>
		<p>
			<mytaglib:i18n key="info.model" />
			-
			<c:out value="${formModel.model}"></c:out>
		</p>
		<p>
        	<mytaglib:i18n key="info.govNumber" />
        	-
        	<c:out value="${formModel.govNumber}"></c:out>
        </p>
        <p>
        	<mytaglib:i18n key="info.run" />
        	-
        	<c:out value="${formModel.run}"></c:out>
        </p>
		<a class="waves-effect waves-light btn" href="${pageContext.request.contextPath}/order/">Забронировать</a>
	</div>
</div>
