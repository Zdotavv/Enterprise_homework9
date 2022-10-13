<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Create new product</title>
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
    <h2>Create new product</h2>
    <form:form action="create" method="post" modelAttribute="product">

        <form:label path="name">Name:</form:label>
        <form:input required="required" path="name"/><br/>

        <form:label path="price">Price:</form:label>
        <form:input required="required" path="price"/><br/>

        <form:label path="idShop">Shop ID:</form:label>
        <form:input required="required" path="idShop"/><br/>

        <form:button>Register</form:button>
    </form:form>
</div>
</body>
</html>