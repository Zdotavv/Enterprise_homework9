<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View product By ID</title>
</head>
<body>
<div align="center">
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<h1 align="center">View product By ID</h1>
<div align="center">
    <%--@elvariable id="productById" type="com.zdotavv.enterprise_homework7.dto.PersonDto"--%>
    <table>
        <tr>
            <td>ID: </td>
            <td>${productById.idProduct}</td>
        <tr>
            <td>Name: </td>
            <td>${productById.name}</td>
        <tr>
            <td>Price: </td>
            <td>${productById.price}</td>
        <tr>
            <td>Shop ID: </td>
            <td>${productById.idShop}</td>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/product">&#8592 Back to product control page </a>
</body>
</html>