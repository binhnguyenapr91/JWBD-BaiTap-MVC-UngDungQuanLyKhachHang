<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 15/05/2020
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer Page</title>
</head>
<body>
<h1>Customer Page</h1>
<table>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>ADDRESS</td>
    </tr>
    <c:forEach items="${listCustomer}" var="customer">
        <tr>
            <td>${customer.getCustomerId()}</td>
            <td>${customer.getCustomerName()}</td>
            <td>${customer.getCustomerAddress()}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
