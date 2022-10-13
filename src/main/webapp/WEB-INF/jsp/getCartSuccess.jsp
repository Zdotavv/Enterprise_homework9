<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>View cart By ID</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">View cart By ID</h1>
<div align="center">
    <%--@elvariable id="cartById" type="com.zdotavv.enterprise_homework6.dto.CartDto"--%>
        <h2>Cart</h2>
        <span>ID:</span><span>${cartById.idCart}</span><br/>
        <span>Sum:</span><span>${cartById.sum}</span><br/>
        <span>Person:</span>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <tr>
                <th>${cartById.person.idPerson}</th>
                <th>${cartById.person.firstName}</th>
                <th>${cartById.person.lastName}</th>
                <th>${cartById.person.email}</th>
            </tr>
        </table>
        <span>Products:</span><table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Shop ID</th>
        </tr>
        <c:forEach items="${cartById.products}" var="item">
        <tr>
            <td><c:out value="${item.idProduct}"/></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td><c:out value="${item.shop.getIdShop()}"/></td>
        </tr>
        </c:forEach>
</div>
<br>
<a href="${pageContext.request.contextPath}/cart">&#8592 Back to cart control page </a>
</body>
</html>