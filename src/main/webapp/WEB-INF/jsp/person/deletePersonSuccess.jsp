<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Deleting Success</title>
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

    <h2>Person is deleted!</h2>
    <span>ID:</span><span>${person.idPerson}</span><br/>
</div>
<br>
<a href="${pageContext.request.contextPath}/person/all">&#8592 Back to all persons</a>
<br>
<a href="${pageContext.request.contextPath}/person">&#8592 Back to person control page </a>
</body>
</html>
