<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Shop List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">All shops</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Link</th>
        </tr>
        <c:forEach  items="${all}" var ="shop">
            <tr>
                <td>${shop.idShop}</td>
                <td>${shop.name}</td>
                <td>${shop.link}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/shop">&#8592 Back to shop control page </a>
</body>
</html>