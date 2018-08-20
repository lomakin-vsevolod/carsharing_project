<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<c:set var="baseUrl" value="${pageContext.request.contextPath}/user" />

<h4 class="header">User</h4>

<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>email</th>
			<th>surname</th>
			<th>name</th>
			<th>middlename</th>
			<th>role</th>
			<th>phoneNumber</th>
			<th>created</th>
			<th>updated</th>
			<th></th>
		</tr>
		<c:forEach var="user" items="${listDTO.list}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><c:out value="${user.surname}" /></td>
				<td><c:out value="${user.name}" /></td>
				<td><c:out value="${user.middleName}" /></td>
				<td><c:out value="${user.role}" /></td>
				<td><c:out value="${user.phone}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${user.dateCreate}" /></td>
				<td><fmt:formatDate pattern="yyyy-MM-dd"
						value="${user.dateUpdate}" /></td>
				<td class="right"><a class="btn-floating"
					href="${baseUrl}/${user.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${baseUrl}/${user.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${baseUrl}/${user.id}/delete"><i class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${baseUrl}/add"><i
	class="material-icons">add</i></a>
