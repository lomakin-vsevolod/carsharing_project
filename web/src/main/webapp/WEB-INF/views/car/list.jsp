<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="jspFragments" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="mytaglib" uri="my-custom-tags-uri"%>

<c:set var="baseUrl" value="${pageContext.request.contextPath}/car" />

<h4 class="header">Car</h4>

<table class="bordered highlight">
	<tbody>
		<tr>
			<th><mytaglib:sort-link pageUrl="${baseUrl}" column="id">id</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${baseUrl}" column="brand">brand</mytaglib:sort-link></th>
			<th><mytaglib:sort-link pageUrl="${baseUrl}" column="model">model</mytaglib:sort-link></th>
			<th>govnumber</th>
			<th><mytaglib:sort-link pageUrl="${baseUrl}" column="run">run</mytaglib:sort-link></th>
			<th></th>
		</tr>
		<c:forEach var="car" items="${listDTO.list}" varStatus="loopCounter">
			<tr>
				<td><c:out value="${car.id}" /></td>
				<td><c:out value="${car.brand}" /></td>
				<td><c:out value="${car.model}" /></td>
				<td><c:out value="${car.govNumber}" /></td>
				<td><c:out value="${car.run}" /></td>
				<td class="right"><a class="btn-floating" href="${baseUrl}/${car.id}"><i
						class="material-icons">info</i></a> <a class="btn-floating" href="${baseUrl}/${car.id}/edit"><i
						class="material-icons">edit</i></a> <a class="btn-floating red"
					href="${baseUrl}/${car.id}/delete"><i class="material-icons">delete</i></a></td>
			</tr>

		</c:forEach>
	</tbody>
</table>
<jspFragments:paging />
<a class="waves-effect waves-light btn right" href="${baseUrl}/add"><i class="material-icons">add</i></a>
