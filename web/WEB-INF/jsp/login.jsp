<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.06.2021
  Time: 10:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="parts/imports.jsp"%>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <style>
        <%@include file="/WEB-INF/static/style.css"%>
    </style>
</head>
<body>
<%@include file="parts/header.jsp"%>

<div class="container main-container" >
    <div class="card shadow">
        <img src="https://s.dou.ua/img/announces/javaee1_0exJWZ9.png" class="card-img-top" alt="Card image">
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/login" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text" id="inputGroup-sizing-default">Username</span>
                    <input name="userName" value="${param.userName}" type="text" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text" id="basic-addon2">Password </span>
                    <input name="password" type="password" class="form-control">
                </div>
                <div class="container">
                    <div class="row justify-content-center" >
                        <button type="submit" class="btn btn-info btn-lg col">Sign In</button>
                    </div>
                </div>
            </form>
        </div>
        <c:if test="${not empty requestScope.error}">
            <div class="errors">
                        <span>
                                ${requestScope.error}
                        </span>
            </div>
        </c:if>
        <div class="container">
            <div class="card-footer text-muted row justify-content-center">
                <a href="${pageContext.request.contextPath}/registration" class="col sign-up-button">Sign Up</a>
            </div>
        </div>
    </div>
</div>
<%@include file="parts/footer.jsp"%>
</body>
</html>
