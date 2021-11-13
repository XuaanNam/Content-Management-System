<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html>
<html lang="en">
<head>
   	<meta charset="utf-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>   

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/templates/MyStyle.css">
</head>
<body>
	<%
		String email = "", pass = "", rem = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null){
			for(Cookie item : cookies){
				if(item.getName().equals("cookieEmail"))
					email = item.getValue();
				else if(item.getName().equals("cookiePass"))
					pass = item.getValue();
				else if(item.getName().equals("cookieRem"))
					rem = item.getValue();
			}
		}
	%>
	
    <form id="login-form" action="${pageContext.request.contextPath}/views/login" method="post" onsubmit="return validate()">
        <div class="container">
            <div class="form-title">
                <label>Please Sign In</label>
            </div>
            <div class="group">
                <input class="textbox" id="email" type="email" placeholder="E-mail" name="email" value="<%=email%>" > <br>
                <span class="temp temp-tick e_tick">&#10004;</span>
                <span class="temp temp-error e_error">&#10006;</span>   
            </div>
            <div class="group">
                <input class="textbox" id="pass" type="password" placeholder="Password" name="password" value="<%=pass%>"> <br>
                <span class="temp temp-tick p_tick">&#10004;</span>
                <span class="temp temp-error p_error">&#10006;</span>  
            </div>
            <div class="group">
                <input class="checkbox" id="checkbox" type="checkbox" name="checkbox" value= "1"
                <%=	"1".equals(rem) ? "checked='checked'" : ""%>>
                <label>Remember Me</label>
            </div> 
            <div>
                <input id="btn-login" type="submit" value="Login" ><br>
            </div>
            <div class="mess">
               <span> ${Message1} </span>
            </div>
            <div class="link">
            	<a style="text-decoration: none" href="${pageContext.request.contextPath}/views/register.jsp">Click here to Register</a>
            </div>
        </div>
    </form>
    <script type="text/javascript" src="${pageContext.request.contextPath}/javascript/loginvalidate.js"></script>
</body>
</html>