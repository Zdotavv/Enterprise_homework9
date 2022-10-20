<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Product List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">All products</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Shop ID</th>
        </tr>
        <c:forEach  items="${all}" var ="product">
            <tr>
                <td>${product.idProduct}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.shop.getIdShop()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/product">&#8592 Back to product control page </a>
</body>
</html>