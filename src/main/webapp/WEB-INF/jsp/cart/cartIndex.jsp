<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Persons control page</title>
</head>
<body>
<a href="http://localhost:8080">&#8592 Back to start page menu</a>
<div align="center">
    <h1>${message}</h1>

    <nav class="menu">
        <h2 align="center">Menu:</h2>
        <a href="${pageContext.request.contextPath}/cart/create">Create new cart</a><br>
        <a href="${pageContext.request.contextPath}/cart/all">View all carts</a><br>
        <a href="${pageContext.request.contextPath}/cart/get">View cart by ID</a><br>
        <a href="${pageContext.request.contextPath}/cart/delete">Delete cart</a><br>
        <a href="${pageContext.request.contextPath}/cart/add">Add product to cart</a><br>
        <a href="${pageContext.request.contextPath}/cart/remove">Remove product from cart</a><br>
        <a href="${pageContext.request.contextPath}/cart/clean">Clean cart</a><br>

    </nav>

</div>
</body>
</html>