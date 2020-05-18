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
    <title>Customer Listing Page</title>
</head>
<body>
<h1>Customer Listing Page</h1>
<p><a href="/customer?action=create">Creat New Customer</a> </p>
<table>
    <tr>
        <td>ID</td>
        <td>NAME</td>
        <td>ADDRESS</td>
    </tr>
    <c:forEach items="${listCustomer}" var="customer">
        <tr>
            <td>${customer.customerId}</td>
            <td>${customer.customerName}</td>
            <td>${customer.customerAddress}</td>
            <td><a href="/customer?action=read&id=${customer.getCustomerId()}">Read</a></td>
            <td><a href="/customer?action=update&id=${customer.getCustomerId()}">Update</a></td>
            <td><a href="/customer?action=delete&id=${customer.getCustomerId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

