<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View shop by ID</title>
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
    <h2>View shop by ID</h2>
    <%--@elvariable id="shopById" type="com.zdotavv.enterprise_homework6.dto.ShopDto"--%>
    <form:form action="get" method="post" modelAttribute="shopById">
        <form:label path="idShop">ID:</form:label>
        <form:input required="required" path="idShop"/><br/>
        <form:button>Get</form:button>
    </form:form>
</div>
</body>
</html>
