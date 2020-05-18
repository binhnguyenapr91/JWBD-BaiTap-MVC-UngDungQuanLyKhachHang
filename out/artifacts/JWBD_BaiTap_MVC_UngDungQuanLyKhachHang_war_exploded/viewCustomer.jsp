<%--
  Created by IntelliJ IDEA.
  User: binhnguyen
  Date: 18/05/2020
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Customer</title>
</head>
<body>
<a href="/customer">Back to customer list</a>
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
        </table>
    </fieldset>
</body>
</html>
