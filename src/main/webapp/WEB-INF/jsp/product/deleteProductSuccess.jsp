<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Deleting product is success</title>
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
    <h2>Product is deleted!</h2>
    <%--@elvariable id="personById" type="com.zdotavv.enterprise_homework6.dto.ProductDto"--%>
    <span>ID:</span><span>${product.idProduct}</span><br/>
</div>
<br>
<a href="${pageContext.request.contextPath}/product/all">&#8592Back to all products</a>
<br>
<a href="${pageContext.request.contextPath}/product">&#8592 Back to product control page </a>
</body>
</html>
