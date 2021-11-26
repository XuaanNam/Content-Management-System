<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<section class="section-title">
	<div>
		<h1 class="font-helvetica">Edit Content</h1>
	</div>
</section>
<section class="section-list">
	<div class="view-title">
		<h3 class="font-helvetica">Edit Content List</h3>
	</div>
	<div class="view-table">
		<form
			action="${pageContext.request.contextPath}/updateContentServlet?id=${contentResult.id}"
			class="form-edit" method="post">
			<label>Title</label> <br /> <input style="width: 100%; height: 5vh;"
				type="text" placeholder="Enter the title"
				value="${contentResult.title}" id="input-title" name="title" /> <br />
			<br /> <label>Brief</label> <br />
			
			
			<textarea name="brief" id="input-brief" rows="6" cols="150">  
 					${contentResult.brief}
				</textarea>
			<br /> <br /> <label>Content</label> <br />
			<textarea name="content" id="input-content" style="text-align:left;"  rows="9" cols="150">  
 					${contentResult.content}
				</textarea>
			<br /> <br />
			<button style="width: 30%; height: 5vh" type="submit">Submit
				Button</button>
			<button style="width: 30%; height: 5vh" type="button"  onclick="resetForm()">Reset Button</button>
		</form>
	</div>
</section>
<script>
	function resetForm(){
		location.reload ();
	};
	
</script>