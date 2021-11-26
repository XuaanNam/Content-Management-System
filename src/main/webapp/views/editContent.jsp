<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.beanContent" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>


<!-- Begin Content -->
<form action="${pageContext.request.contextPath}/updateContentServlet?id=${contentResult.id}"
	method="POST" class="form" id="form-add">
	<div class="form-content-section">
		<p class="form-tittle">Edit Content</p>
	</div>
	<div class="body-content-section">
		<h3 class="form-heading-name">Form Edit Content</h3>

		<div class="form-container">
			<div>
				<div class="form-group">
					<label for="title-box" class="heading-name">Tittle</label> <input
						id="title-box" name="title" type="text" value="${contentResult.title}"
						placeholder="Enter the title" class="input-box-section"> <span
						class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="brief-box" class="heading-name">Brief</label>
					<textarea name="brief" id="brief-box" cols="115" rows="4"
						class="input-box-section">${contentResult.brief}</textarea>
					<span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="content-box" class="heading-name">Content</label>
					<textarea name="content" id="content-box" cols="115" rows="10"
						class="input-box-section">${contentResult.content}</textarea>
					<span class="form-message"></span>
				</div>

			</div>

			<div class="form-btn">

				<div class="submit-section">
					<input type="submit" class="btn-section" value="Submit Button">
				</div>

				<div class="reset-section">
				<input type="reset" class="btn-section" onClick="resetForm()" value="Reset Button">
				</div>

			</div>
		</div>
	</div>
</form>
<!-- End Content -->


<script
	src="${pageContext.request.contextPath}/javascript/addeditvalidate.js"
	type="text/javascript"></script>
<script>
	Validator({
		form : '#form-add',
		errorSelector : ".form-message",
		rules : [ Validator.checkLength('#title-box', 10, 200),
				Validator.checkLength('#brief-box', 30, 150),
				Validator.checkLength('#content-box', 50, 1000), ]
	});
</script>

<script>
	//Reset button
	function resetForm() {
		document.getElementById("form-add").reset();
	}
</script>
