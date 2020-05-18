<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 15/05/2020
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Customer</title>
    <style>
        .message {
            color: green;
        }
    </style>
</head>
<body>
<h1>Create New Customer</h1>
<p><c:if test='${requestScope["message"]!=null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if></p>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>CustomerID: </td>
                <td><input type="text" name="customerId" id="id"></td>
            </tr>
            <tr>
                <td>CustomerName: </td>
                <td><input type="text" name="customerName" id="name"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="customerAddress" id="address"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Create customer"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
