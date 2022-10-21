<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View shop By ID</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">View shop By ID</h1>
<div align="center">
    <%--@elvariable id="shopById" type="com.zdotavv.enterprise_homework6.dto.ShopDto"--%>
    <table>
        <tr>
            <td>ID: </td>
            <td>${shopById.idShop}</td>
        <tr>
            <td>Name: </td>
            <td>${shopById.name}</td>
        <tr>
            <td>Address: </td>
            <td>${shopById.link}</td>
    </table>
        <span>Products:</span><table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${shopById.products}" var="item">
        <tr>
            <td><c:out value="${item.idProduct}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
        </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/shop">&#8592 Back to shop control page </a>
</body>
</html>