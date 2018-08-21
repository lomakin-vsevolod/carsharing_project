<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<c:set var="baseUrl" value="${pageContext.request.contextPath}/carcatalog" />

<h4 class="header">Catalog</h4>

<table class="bordered highlight">
	<tbody>
		<tr>
			<th>id</th>
			<th>catalogType</th>
			<th>catalogNameType</th>
			<th>name</th>
			<th></th>
		</tr>
		<c:forEach var="carCatalog" items="${listDTO.list}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${carCatalog.id}" /></td>
				<td><c:out value="${carCatalog.catalogType}" /></td>
				<td><c:out value="${carCatalog.catalogNameType}" /></td>
				<td><c:out value="${carCatalog.name}" /></td>
				<td class="right"><a class="btn-floating"
					href="${baseUrl}/${carCatalog.id}"><i class="material-icons">info</i></a>
					<a class="btn-floating" href="${baseUrl}/${carCatalog.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${baseUrl}/${carCatalog.id}/delete"><i
						class="material-icons">delete</i></a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${baseUrl}/add"><i
	class="material-icons">add</i></a>
