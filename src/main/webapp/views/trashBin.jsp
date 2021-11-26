<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.beanContent" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<section class="section-title">
	<div>
		<h1 class="font-helvetica">Trash Bin</h1>
	</div>
</section>
<section class="section-list">
	<div class="view-title">
		<h3 class="font-helvetica">Trash Bin List</h3>
	</div>
	<div class="view-table">
		<table>
			<thead>
				<tr>
					<th style="width: 2%;">#</th>
					<th style="width: 23%;">Title</th>
					<th style="width: 40%;">Brief</th>
					<th style="width: 20%;">Created Date</th>
					<th style="width: 15%; text-align: center;">Action</th>
				</tr>
			</thead>
			<tbody>
				<%
				int index = 0;
				%>
				<c:forEach var="rows" items="${viewResult}">
					<tr>
						<td><%=++index%></td>
						<td><c:out value="${rows.title}"></c:out></td>
						<td><c:out value="${rows.brief}"></c:out></td>
						<td><c:out value="${rows.createdate}"></c:out></td>
						<td>
							<div class="flex">
								<a
									href="${pageContext.request.contextPath}/trashOrRestore?id=${rows.id}">
									<button>Restore</button>
								</a> <a
									href="${pageContext.request.contextPath}/deleteContentServlet?id=${rows.id}">
									<button>Delete</button>
								</a>
							</div>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="view-page-number">
		
	</div>

</section>
