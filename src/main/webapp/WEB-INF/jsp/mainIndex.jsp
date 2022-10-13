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