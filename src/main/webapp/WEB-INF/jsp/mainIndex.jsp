<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Online Shop</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>${message}</h1>

    <h3><c:choose>
        <c:when test="${pageContext.request.userPrincipal.name == null}">Welcome! Log in or Register, please:</c:when>
        <c:otherwise>Welcome, ${pageContext.request.userPrincipal.name}!</c:otherwise>
    </c:choose></h3>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout">Log out</a></h4>
    </sec:authorize>
    <sec:authorize access="!isAuthenticated()">
        <a href="${pageContext.request.contextPath}/login">Log in</a><br>
        <a href="${pageContext.request.contextPath}/registration">Registration</a>
    </sec:authorize>

    <h2>Main menu:</h2>
    <nav class="menu">
        <ul>
            <li><a href="${pageContext.request.contextPath}/person">Persons control page</a></li>
            <li><a href="${pageContext.request.contextPath}/shop">Shops control page</a></li>
            <li><a href="${pageContext.request.contextPath}/product">Products control page</a></li>
            <li><a href="${pageContext.request.contextPath}/cart">Carts control page</a></li>
        </ul>
    </nav>
</div>
</body>
</html>