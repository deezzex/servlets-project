<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09.06.2021
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

    <fmt:setLocale value="${sessionScope.lang != null ? sessionScope.lang : (param.lang != null ? param.lang : 'en_US')}"/>
    <fmt:setBundle basename="translations"/>

    <nav class="navbar navbar-expand-lg shadow">
        <div class="container-fluid">
            <a class="navbar-brand mb-0 h1" href="#"><fmt:message key="header.nav.brand"/></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/products"><fmt:message key="header.nav.button.products"/></a>
                    </li>
                </ul>

                <div class="d-flex">
                    <form action="${pageContext.request.contextPath}/locale" method="post">
                        <div class="btn-group me-2" role="group" aria-label="First group">
                            <button type="submit" name="lang" value="ru_RU" class="btn btn-outline-secondary">RU</button>
                            <button type="submit" name="lang" value="en_US" class="btn btn-outline-secondary">EN</button>
                        </div>
                    </form>
                    <c:if test="${not empty sessionScope.user}">
                        <form action="${pageContext.request.contextPath}/logout" method="post">
                            <button class="btn btn-warning" type="submit"><fmt:message key="header.nav.brand"/></button>
                        </form>
                    </c:if>
                </div>
            </div>
        </div>
    </nav>

