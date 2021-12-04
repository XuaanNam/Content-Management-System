<div class="search-section">
	<div class="search-container">
		<form action="${pageContext.request.contextPath}/searchServlet"
			method="get">
			<input type="text" name="txtsearch" placeholder="Search..." required value="${txts}"
				id="" class="search-input">
			<button class="search-btn">
				<i class="search-icon fas fa-search"></i>
			</button>
		</form>
	</div>
</div>

<div class="nav-content-section">
	<a href="${pageContext.request.contextPath}/viewContentServlet">
		<button class="view-content-container box-container">
			<p class="navigation-heading">
				<i class="view-content-icon fa fa-table"></i>View contents
			</p>
		</button>
	</a>
</div>

<div class="nav-content-section">
	<a href="${pageContext.request.contextPath}/addContent.tiles">
		<button class="form-content-container box-container">
			<p class="navigation-heading">
				<i class="form-content-icon far fa-edit"></i>Form content
			</p>
		</button>
	</a>
</div>

<div class="nav-content-section" >
	<a href="${pageContext.request.contextPath}/viewTrashBinServlet">
		<button class="trash-bin-container box-container"> 
			<p class="navigation-heading">
				<i class="trash-bin-icon fas fa-trash"></i>Trash bin
			</p>
		</button>
	</a>
</div>
