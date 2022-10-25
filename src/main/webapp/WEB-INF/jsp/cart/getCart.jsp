<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View cart by ID</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
    <a href="${pageContext.request.contextPath}/">&#8592 Back to main menu</a>
<div align="center">
    <h2>View cart by ID</h2>
    <%--@elvariable id="cartById" type="com.zdotavv.enterprise_homework7.dto.CartDto"--%>
    <form:form action="get" method="post" modelAttribute="cartById">
        <form:label path="idCart">ID:</form:label>
        <form:input required="required" path="idCart"/><br/>
        <form:button>Get</form:button>
    </form:form>
</div>
    <br>
    <a href="${pageContext.request.contextPath}/cart">&#8592 Back to cart control page </a>
</body>
</html>
