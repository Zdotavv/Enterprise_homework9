<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Deleting cart is success</title>
    <style type="text/css">
        span {
            display: inline-block;
            width: 200px;
            text-align: left;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<div align="center">
    <h2>Cart is deleted!</h2>
    <span>ID:</span><span>${cart.idCart}</span><br/>
</div>
<br>
    <a href="${pageContext.request.contextPath}/cart">&#8592 Back to cart control page </a>
</body>
</html>
