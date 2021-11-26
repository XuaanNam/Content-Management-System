<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"
	import = "model.beanContent"
	import = "java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<section class="section-title">
	<div>
		<h1 class="font-helvetica">View Content</h1>
	</div>
</section>
<section class="section-list">
	<div class="view-title">
		<h3 class="font-helvetica" style="padding-right: 50px;">View Content List</h3>
		<div class="flex" style="padding: 90px;"><h4 class="font-helvetica">All content are sorted by: <c:out value="${sort}"></c:out> - <c:out value="${sortType}"></c:out>ending</h4> </div>
		<% 	String search = String.valueOf(request.getAttribute("search"));
			if (search == null){%>
				<form action="${pageContext.request.contextPath}/viewContentServlet" method="post">
			<%} else { %>
				<form action="${pageContext.request.contextPath}/searchServlet" method="post">
			<%} %>
			<input style ="max-width: 0px; max-height: 0px;" type = "text" name= "s" value="${search}"/>
			<label>Sort by </label> <select name="sort" id="sort-by">
				<option selected disabled value = "option">---- Option ----</option>
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
                                    <a href="${pageContext.request.contextPath}/editContentServlet?id=${rows.id}">
                                        <button>Edit</button>
                                    </a>
                                    <a href="${pageContext.request.contextPath}/trashOrRestore?id=${rows.id}">
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
			<c:forEach begin = "1" end="${endP}" var = "i">
				<li>
					<% 
						if (search == null){%>
							<a href="${pageContext.request.contextPath}/viewContentServlet?page=${i}&sort=${sort}&sortType=${sortType}">
									<button>${i}</button>
							</a>
						<%} else { %>
							<a href="${pageContext.request.contextPath}/searchServlet?page=${i}&sort=${sort}&sortType=${sortType}&s=${search}">
								<button>${i}</button>
							</a>
						<%} %>
				</li>
			</c:forEach>		
		</ul>
	</div>

</section>
