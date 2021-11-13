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
		<form
			action="${pageContext.request.contextPath}/viewTrashBinServlet?sort=sort"
			method="get">
			<label>Sort by </label> <select name="sort" id="sort-by">
				<option value="CreateDate">Created Date</option>
				<option value="Title">Title</option>
				<option value="Brief">Brief</option>
			</select>
			<button type="submit" name="sortType" value="asc">ascending</button>
			<button type="submit" name="sortType" value="desc">decrease</button>
		</form>
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
		<ul>
			<li><a href="#">
					<button>
						<img src="${pageContext.request.contextPath}/icons/previous.svg"
							alt="previous">
					</button>
			</a></li>
			<li><a href="#">
					<button>1</button>
			</a></li>
			<li><a href="#">
					<button>2</button>
			</a></li>
			<li><a href="#">
					<button>3</button>
			</a></li>
			<li><a href="#">
					<button>4</button>
			</a></li>
			<li>. . . .</li>
			<li><a href="#">
					<button>5</button>
			</a></li>
			<li><a href="#">
					<button>6</button>
			</a></li>
			<li><a href="#">
					<button>7</button>
			</a></li>
			<li><a href="#">
					<button>
						<img src="${pageContext.request.contextPath}/icons/next.svg"
							alt="next">
					</button>
			</a></li>
		</ul>
	</div>

</section>
