<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Cart List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<h1 align="center">All carts</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>Cart ID</th>
            <th>Sum</th>
            <th>Person ID</th>
        </tr>
        <c:forEach  items="${all}" var ="cart">
            <tr>
                <td>${cart.idCart}</td>
                <td>${cart.sum}</td>
                <td>${cart.person.getIdPerson()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<br>
<a href="${pageContext.request.contextPath}/cart">&#8592 Back to cart control page </a>
</body>
</html>