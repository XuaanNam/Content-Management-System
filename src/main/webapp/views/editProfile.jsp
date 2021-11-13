<div class="content-heading-section">
	<p class="heading-tittle">Edit Profile</p>
</div>
<div class="body-content-section">
	<div class="table-heading-content">
		<p class="table-heading-name">Profile Form Elements</p>
	</div>
	<div class="table-element-section">
	<form
			action="${pageContext.request.contextPath}/editProfileServlet?id=${contentResult.id}"
			class="edit-profile" method="post">
		<div>
			<label for="fname-box" class="fname-label">
				<p class="heading-name">First Name</p> <input name="fname" type="text" required
				id="fname-box" size="50" placeholder="Enter the first name" value="${contentResult.fname}"
				class="input-box-section">
			</label> <label for="lname-box" class="lname-label">
				<p class="heading-name">Last Name</p> <input name="lname" type="text" required
				id="lname-box" size="50" placeholder="Enter the last name" value="${contentResult.lname}"
				class="input-box-section">
			</label> <label for="email-box" class="email-label">
				<p class="heading-name">Email</p> <input name="email" type="email" required
				id="email-box" size="50" placeholder="your_email@example.com" value="${contentResult.email}"
				class="email-btn input-box-section">
			</label> <label for="phone-box" class="phone-label">
				<p class="heading-name">Phone</p> <input name="phone" type="text" required
				id="phone-box" size="50" placeholder="Enter your phone number" value="${contentResult.phone}"
				class="input-box-section">
			</label> <label for="description-box" class="description-label">
				<p class="heading-name">Description</p> <textarea name="description" required
					id="description-box" cols="115" rows="4" class="input-box">${contentResult.description}</textarea>
			</label>
		</div>
		</form>
		<div class="add-content-btn">
			<div class="submit-section">
				<button onclick="validate()" type="submit" class="btn-section">Submit Button</button>
			</div>
			<div class="reset-section">
				<button class="btn-section">Reset Button</button>
			</div>

		</div>
	</div>

</div>

<script src="${pageContext.request.contextPath}/javascript/lengthCheck.js" type="text/javascript"> </script>
