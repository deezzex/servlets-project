<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.06.2021
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="parts/imports.jsp"%>
<html>
<head>
    <title>Registration</title>
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
        <div class="card-body">
            <h4 class="card-title mb-4 mt-1">Registration user account</h4>
            <form action="${pageContext.request.contextPath}/registration" method="post">
                <div class="input-group mb-3">
                    <span class="input-group-text">Username</span>
                    <input type="text" name="username" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Email</span>
                    <input type="email" name="email" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">Password </span>
                    <input type="password" name="password" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <span class="input-group-text">First and last name</span>
                    <input type="text" name="firstname" aria-label="First name" class="form-control">
                    <input type="text" name="lastname" aria-label="Last name" class="form-control">
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Gender</label>
                    <select name="gender" class="form-select" id="inputGroupSelect01">
                        <option selected>Choose...</option>
                        <c:forEach var="gender" items="${requestScope.genders}">
                            <option value="${gender}">${gender}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <label class="input-group-text" for="inputGroupSelect01">Birthday</label>
                    <select name="day" class="form-select form-select-sm" aria-label=".form-select-sm example">
                        <option selected>Day</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                    </select>
                    <select name="month" class="form-select form-select-sm" aria-label=".form-select-sm example">
                        <option selected>Month</option>
                        <option value="01">01</option>
                        <option value="02">02</option>
                        <option value="03">03</option>
                    </select>
                    <select name="year" class="form-select form-select-sm" aria-label=".form-select-sm example">
                        <option selected>Year</option>
                        <option value="2021">2021</option>
                        <option value="2020">2020</option>
                        <option value="2019">2019</option>
                    </select>
                </div>

                <div class="container">
                    <div class="row justify-content-center" >
                        <button type="submit" class="btn btn-info btn-lg col">Sign Up</button>
                    </div>

                    <div>
                        <c:if test="${not empty requestScope.errors}">
                            <div class="errors">
                                <c:forEach var="error" items="${requestScope.errors}" varStatus="loop">
                        <span>
                                ${error.message}
                                <c:if test="${!loop.last}">,</c:if>
                        </span>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>

                </div>
            </form>
        </div>
    </div>
</div>
<%@include file="parts/footer.jsp"%>
</body>
</html>
