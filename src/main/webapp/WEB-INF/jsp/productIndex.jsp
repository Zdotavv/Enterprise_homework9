<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Product control page</title>
</head>
<body>
<a href="http://localhost:8080">&#8592 Back to start page menu</a>
<div align="center">
    <h1>${message}</h1>

    <nav class="menu">
        <h2 align="center">Menu:</h2>
        <a href="${pageContext.request.contextPath}/product/create">Create new product</a><br>
        <a href="${pageContext.request.contextPath}/product/all">View all products</a><br>
        <a href="${pageContext.request.contextPath}/product/get">View product by ID</a><br>
        <a href="${pageContext.request.contextPath}/product/update">Update product</a><br>
        <a href="${pageContext.request.contextPath}/product/delete">Delete product</a><br>

    </nav>

</div>
</body>
</html>