<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="model.beanContent" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!-- Begin Content -->
<form action="update" method="POST" class="form" id="form-edit-profile">
	<div class="form-content-section">
		<p class="form-tittle">Edit Profile</p>
	</div>

	<div class="body-content-section">
		<h3 class="form-heading-name">Profile Form Elements</h3>

		<div class="form-container">
			<c:if test="${Member != null}">
				<input type="hidden" name="id" value="<c:out value='${Member.id}' />" />
			</c:if>
			<div>
				<div class="form-group">
					<label for="fname-box" class="heading-name">First Name</label> <input
						id="fname-box" name="fname" type="text" size="50 " value="<c:out value='${Member.Firstname}' />" 
						placeholder="Enter the first name " class=" input-box-section ">
					<span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="lname-box" class="heading-name">Last Name</label> <input
						id="lname-box" type="text" name="lname" size=" 50 " value="<c:out value='${Member.Lastname}' />"
						placeholder=" Enter the last name " class=" input-box-section ">
					<span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="email-box" class="heading-name">Email</label> <input
						id="email-box" name="email" type="hidden" value="<c:out value='${Member.Email}' />" class="email-section"
						placeholder="your_email@example.com">

				</div>

				<div class="form-group">
					<label for="phone-box" class="heading-name">Phone</label> <input
						id="phone-box" type="text" name="phone" size=" 50 " value="<c:out value='${Member.Phone}' />"
						placeholder="Enter your phone number " class="input-box-section">
					<span class="form-message"></span>
				</div>

				<div class="form-group">
					<label for="description-box" class="heading-name">Description</label>
					<textarea id="description-box" name="description" cols=" 140 " value="<c:out value='${Member.Description}' />"
						rows=" 4 " class="input-box-section"></textarea>
					<span class="form-message"></span>
				</div>

			</div>


			<div class="form-btn">

				<div class="submit-section">
					<button type="submit" class="btn-section">Submit Button</button>
				</div>

				<div class="reset-section">
					<button type="reset" class="btn-section" onclick="fun()">
						Reset Button</button>
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
		form : '#form-edit-profile',
		errorSelector : '.form-message',
		rules : [ Validator.checkLength('#fname-box', 3, 30),
				Validator.checkLength('#lname-box', 3, 30),
				Validator.isPhoneNo('#phone-box', 9, 13),
				Validator.checkLength('#description-box', 0, 200), ]
	});
</script>
<script>
	// Reset button 
	function fun() {
		document.getElementById("form-edit-profile").reset();
	}
</script>
</body>
