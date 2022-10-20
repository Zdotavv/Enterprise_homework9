<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Updating product is success</title>
    <style type="text/css">
        span {
            display: inline-block;
            width: 200px;
            text-align: left;
        }
    </style>
</head>
<body>
<div align="center">
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
</div>
<div align="center">
    <h2>Updating product is success</h2>
    <span>Name:</span><span>${product.name}</span><br/>
    <span>Price:</span><span>${product.price}</span><br/>
    <span>Shop ID:</span><span>${product.idShop}</span><br/>
</div>
<br>
<a href="${pageContext.request.contextPath}/product">&#8592 Back to product control page </a>
</body>
</html>
