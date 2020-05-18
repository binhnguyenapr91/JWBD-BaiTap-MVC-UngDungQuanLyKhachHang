<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 18/05/2020
  Time: 09:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Customer</title>
</head>
<body>
<h1>Delete Customer</h1>
<p>
    <a href="/customer">Back to customer list</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>CustomerID: </td>
                <td><input type="text" name="customerId" id="id" value="${requestScope["customer"].getCustomerId()}"></td>
            </tr>
            <tr>
                <td>CustomerName: </td>
                <td><input type="text" name="customerName" id="name" value="${requestScope["customer"].getCustomerName()}"></td>
            </tr>
            <tr>
                <td>Address: </td>
                <td><input type="text" name="customerAddress" id="address" value="${requestScope["customer"].getCustomerAddress()}"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td><a href="/customer">Back to customer list</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
