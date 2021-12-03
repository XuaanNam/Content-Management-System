<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/templates/MyStyle.css">
</head>
<body>
    <form id="register-form" action="${pageContext.request.contextPath}/register" method="post" onsubmit="return validate()">
        <div class="container">
            <div class="form-title">
                <label>Register</label>
            </div>
            <div class="group">
                <input class="textbox" id="uname" type="text" placeholder="User name" name="username"> <br>
                <span class="temp temp-tick u_tick">&#10004;</span>
                <span class="temp temp-error u_error">&#10006;</span>    
            </div>
            <div class="group">
                <input class="textbox" id="email" type="email" placeholder="E-mail" name="email"> <br>
                <span class="temp temp-tick e_tick">&#10004;</span>
                <span class="temp temp-error e_error">&#10006;</span>   
            </div>
            <div class="group">
                <input class="textbox pass" id="pass" type="password" placeholder="Password" name="password"> <br>
                <span class="temp temp-tick p_tick">&#10004;</span>
                <span class="temp temp-error p_error">&#10006;</span> 
            </div>
            <div class="group">
                <input class="textbox pass" id="repass" type="password" placeholder="Re Password" name="repassword"> <br>
                <span class="temp temp-tick rp_tick">&#10004;</span>
                <span class="temp temp-error rp_error">&#10006;</span> 
            </div>
            <div>
                <input id="btn-register" type="submit" value="Register" ><br>
            </div>
            <div class="mess">
               <span> ${Message2} </span>
            </div>    
            <div class="link">
            	<a style="text-decoration: none" href="${pageContext.request.contextPath}/views/login.jsp">Click here to Login</a>
            </div>
        </div>
    </form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/registervalidate.js"></script>
</body>
</html>