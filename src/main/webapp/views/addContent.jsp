<div class="content-heading-section">
	<p class="heading-tittle">Add Content</p>
</div>
<form
	action="${pageContext.request.contextPath}/addContentServlet?id=${contentResult.id}"
	class="add-content" onsubmit="return validate()" method="post">
	<div class="body-content-section">
		<div class="table-heading-content">
			<p class="table-heading-name">Content Form Elements</p>
		</div>
		<div class="table-element-section">
			<div>
				<label for="title-box" class="title-element">
					<h3 class="heading-name">Title</h3>
					<input name="title" type="text" required 
					id="title-box" placeholder="Enter the title"
					value="${contentResult.title}" class="input-box-section">
				</label> 
				<label for="brief-box" class="brief-element">
					<h3 class="heading-name">Brief</h3> 
					<textarea name="brief" required
						id="brief-box" cols="115" rows="4" class="input-box">${contentResult.brief}</textarea>
				</label>
				 <label for="content-box" class="content-element">
					<h3 class="heading-name">Content</h3>
					 <textarea name="content" required
						id="content-box" cols="115" rows="10" class="input-box">${contentResult.content}</textarea>
				</label>
			</div>
			<div class="add-content-btn">
				<div class="submit-section">
					<button type="submit" class="btn-section">Submit Button</button>
				</div>
				<div class="reset-section">
					<button type="submit" class="btn-section">Reset Button</button>
				</div>

			</div>
		</div>
	</div>
</form>