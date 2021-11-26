<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="${pageContext.request.contextPath}/templates/MyStyle.css">
<title><tiles:getAsString name="title" /></title>
<script src="https://kit.fontawesome.com/2132335974.js" crossorigin="anonymous"></script>
<script src="/webjars/jquery/dist/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<div class="cms-container">
		<!-- Begin Header -->
		<div id="cms-header">
			<tiles:insertAttribute name="header" />
		</div>
		<!-- End Header -->
		<div class="main">
			<!-- Begin Navigation -->
			<div id="cms-navigation">
				<tiles:insertAttribute name="navigation" />
			</div>
			<!-- End Navigation -->

			<!-- Begin Content -->
			<div id="form-cms">
				<tiles:insertAttribute name="article" />
			</div>
			<!-- End Content -->
		</div>
	</div>
</body>
</html>