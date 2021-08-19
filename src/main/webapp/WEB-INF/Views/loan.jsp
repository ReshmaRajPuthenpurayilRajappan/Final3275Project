<%--
  Created by IntelliJ IDEA.
  User: reshm
  Date: 2021-08-19
  Time: 12:48 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>My Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <style>
        h1 {
            text-align: center;
            background-color: cyan;
        }
    </style>
</head>
<body>
<h1>Loan Records</h1>
<p>The following are the loan records...</p>
<form>
    <div class="form-group">
        <label for="clientno">Client Number</label>
        <input type="text" class="form-control" id="clientno">
    </div>
    <div class="form-group">
        <label for="clientname">Client Name</label>
        <input type="password" class="form-control" id="clientname">

    </div>
    <div class="form-group">
        <label for="loanamount">Loan Amount</label>
        <input type="password" class="form-control" id="loanamount">

    </div>
    <div class="form-group">
        <label for="years">Number of Years</label>
        <input type="password" class="form-control" id="years">

    </div>
    <div class="form-group">
        <label for="loantype">Loan Type</label>
        <input type="password" class="form-control" id="loantype">

    </div>

</form>
<a class="btn btn-success" href="add-todo">Add</a>
<div class="container2">
    <h2>Categories</h2>

    <table class="table table-striped">
        <thead>
        <tr>
            <th>Client Number</th>
            <th>Client Name</th>
            <th>Loan Amount</th>
            <th>Number of Years</th>
            <th>Loan Type</th>
        </tr>
        </thead>
        <tbody>

<%--        <c:forEach items="${todos}" var="todo">--%>



<%--            <tr>--%>
<%--                <td>${todo.catcode}</td>--%>
<%--                <td>${todo.catdesc}</td>--%>

<%--                <td>    <a type="button" class="btn btn-primary"--%>
<%--                           href="update-todo?id=${todo.catcode}" >Edit</a> </td>--%>



<%--                <td>    <a type="button" class="btn btn-primary"--%>
<%--                           href="update-todo?id=${todo.catcode}" >Delete</a> </td>--%>



<%--            </tr>--%>


<%--        </c:forEach>--%>
        </tbody>
    </table>
</div>

</div>

</body>

