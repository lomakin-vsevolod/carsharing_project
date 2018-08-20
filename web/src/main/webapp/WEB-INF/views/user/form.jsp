<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<c:set var="baseUrl" value="${pageContext.request.contextPath}/user" />
<h4 class="header">Edit user</h4>
<div class="row">
	<form:form class="col s12" method="POST" action="${baseUrl}"
		modelAttribute="formModel">
		<form:input path="id" type="hidden" />
		<div class="row">
			<div class="input-field col s12">
				<form:input path="email" type="text" disabled="${readonly}" />
				<form:errors path="email" cssClass="red-text" />
				<label for="email">email</label>
			</div>
			<div class="input-field col s12">
				<form:input path="password" type="text" disabled="${readonly}" />
				<form:errors path="password" cssClass="red-text" />
				<label for="password">пароль</label>
			</div>
			<div class="input-field col s12">
                <form:input path="surname" type="text" disabled="${readonly}" />
         		<form:errors path="surname" cssClass="red-text" />
         		<label for="name">фамилия</label>
            </div>
			<div class="input-field col s12">
				<form:input path="name" type="text" disabled="${readonly}" />
				<form:errors path="name" cssClass="red-text" />
				<label for="name">имя</label>
			</div>
			<div class="input-field col s12">
            	<form:input path="middleName" type="text" disabled="${readonly}" />
            	<form:errors path="middleName" cssClass="red-text" />
            	<label for="middleName">отчество</label>
      		</div>

      		<div class="input-field col s12">
                <form:input path="passSerAndNum" type="text" disabled="${readonly}" />
                <form:errors path="passSerAndNum" cssClass="red-text" />
                <label for="passSerAndNum">паспорт серия и номер</label>
            </div>
            <div class="input-field col s12">
                <form:input path="passIssuedByWhom" type="text" disabled="${readonly}" />
                <form:errors path="passIssuedByWhom" cssClass="red-text" />
                <label for="passIssuedByWhom">паспорт кем выдан</label>
            </div>
            <div class="input-field col s12">
                <form:input path="passIssuedWhen" type="text" placeholder="MM/DD/YYYY" value="01/01/2000" disabled="${readonly}" />
                <form:errors path="passIssuedWhen" cssClass="red-text" />
                <label for="passIssuedWhen">паспорт когда выдан</label>
            </div>
            <div class="input-field col s12">
                 <form:input path="dateOfBirth" type="text" placeholder="MM/DD/YYYY" value="01/01/2000" disabled="${readonly}" />
                 <form:errors path="dateOfBirth" cssClass="red-text" />
                <label for="dateOfBirth">дата рождения</label>
            </div>
            <div class="input-field col s12">
                <form:input path="placeOfBirth" type="text" disabled="${readonly}" />
                <form:errors path="placeOfBirth" cssClass="red-text" />
                <label for="placeOfBirth">место рождения</label>
            </div>
            <div class="input-field col s12">
                <form:input path="drivLicSerAndNum" type="text" disabled="${readonly}" />
                <form:errors path="drivLicSerAndNum" cssClass="red-text" />
                <label for="drivLicSerAndNum">водительское удостоверение серия и номер</label>
            </div>
            <div class="input-field col s12">
                <form:input path="drivLicIssuedByWhom" type="text" disabled="${readonly}" />
                <form:errors path="drivLicIssuedByWhom" cssClass="red-text" />
                <label for="drivLicIssuedByWhom">водительское удостоверение кем выдано</label>
            </div>
            <div class="input-field col s12">
                <form:input path="drivLicIssuedWhen" type="text" placeholder="MM/DD/YYYY" value="01/01/2000" disabled="${readonly}" />
                <form:errors path="drivLicIssuedWhen" cssClass="red-text" />
                <label for="drivLicIssuedWhen">водительское удостоверение когда выдано</label>
            </div>
            <div class="input-field col s12">
                <form:input path="drivLicValidUntil" type="text" placeholder="MM/DD/YYYY" value="01/01/2000" disabled="${readonly}" />
                <form:errors path="drivLicValidUntil" cssClass="red-text" />
                <label for="drivLicValidUntil">водительское удостоверение действительно до</label>
            </div>
            <div class="input-field col s12">
                <form:input path="drivLicCategory" type="text" disabled="${readonly}" />
                <form:errors path="drivLicCategory" cssClass="red-text" />
                <label for="drivLicCategory">водительское удостоверение категория</label>
            </div>
            <div class="input-field col s12">
                <form:input path="photo" type="text" disabled="${readonly}" />
                <form:errors path="photo" cssClass="red-text" />
                <label for="photo">ссылка на фото</label>
            </div>
			<div class="input-field col s12">
				<form:input path="role" type="text" disabled="${readonly}" />
				<form:errors path="role" cssClass="red-text" />
				<label for="role">роль</label>
			</div>
			<div class="input-field col s12">
				<form:input path="phone" type="number" disabled="${readonly}" />
				<form:errors path="phone" cssClass="red-text" />
				<label for="phone">номер телефона</label>
			</div>
		</div>
		<div class="row">
			<div class="col s6"></div>
			<div class="col s3">
				<c:if test="${!readonly}">
					<button class="btn waves-effect waves-light right" type="submit">сохранить</button>
				</c:if>
			</div>
			<!--<div class="col s3">
				<a class="btn waves-effect waves-light right" href="${baseUrl}">
					список<i class="material-icons right"></i>
				</a>
			</div>-->
		</div>
	</form:form>
</div>
