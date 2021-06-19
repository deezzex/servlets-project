<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.06.2021
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="parts/imports.jsp"%>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Raleway:wght@300&display=swap" rel="stylesheet">
    <style>
        <%@include file="/WEB-INF/static/style.css"%>
    </style>
    <title>Products</title>
</head>
<body>
<%@include file="parts/header.jsp"%>

<div class="container main-container" >
    <div class="card shadow">
        <div class="card-body">
            <c:if test="${not empty requestScope.products}">
                <table class="table">
                    <caption>List of products</caption>
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Price</th>
                        <th scope="col">Count</th>
                        <th scope="col">Delivery Date</th>
                        <th scope="col">Category</th>
                        <th scope="col">Comment</th>
                        <th scope="col">Producer</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="product" items="${requestScope.products}">
                        <tr>
                            <th scope="row">${product.id}</th>
                            <td>${product.productName}</td>
                            <td>${product.price}</td>
                            <td>${product.count}</td>
                            <td>${product.deliveryDate}</td>
                            <td>${product.categoryId}</td>
                            <td>${product.commentId}</td>
                            <td>${product.producerId}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </div>
</div>

<%@include file="parts/footer.jsp"%>
</body>
</html>
