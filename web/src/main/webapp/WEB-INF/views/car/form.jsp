<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h4 class="header">Edit car</h4>
<c:set var="baseUrl" value="${pageContext.request.contextPath}/car" />
<div class="row">
	<form:form class="col s12" method="POST" action="${baseUrl}/add" modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="brand" type="text" disabled="${readonly}" />
				<form:errors path="brand" cssClass="red-text" />
				<label for="brand">Производитель</label>
			</div>
			<div class="input-field col s12">
				<form:input path="model" type="text" disabled="${readonly}" />
				<form:errors path="model" cssClass="red-text" />
				<label for="model">Модель</label>
			</div>
			<div class="input-field col s12">
				<form:input path="govNumber" type="text" disabled="${readonly}" />
				<form:errors path="govNumber" cssClass="red-text" />
				<label for="govNumber">Гос. номер</label>
			</div>
			<div class="input-field col s12">
				<form:input path="run" type="number" disabled="${readonly}" />
				<form:errors path="run" cssClass="red-text" />
				<label for="run">Пробег</label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">сохранить</button>
				</c:if>
			</div>
			<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${baseUrl}">к списку<i
					class="material-icons right"></i>
				</a>
			</div>
		</div>
	</form:form>
</div>
