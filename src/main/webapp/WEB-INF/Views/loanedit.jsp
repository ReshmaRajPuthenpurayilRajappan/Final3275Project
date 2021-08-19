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


</head>
<body>
<h1>Add an Entry</h1>

<form>
  <div class="form-group">
    <label for="clientno">Client Number:</label>
    <input type="text" class="form-control" id="clientno">
  </div>
  <div class="form-group">
    <label for="clientname">Client Name:</label>
    <input type="text" class="form-control" id="clientname">
  </div>
  <div class="form-group">
    <label for="loanamount">Loan Amount:</label>
    <input type="text" class="form-control" id="loanamount">
  </div>
  <div class="form-group">
    <label for="years">Number of Years:</label>
    <input type="text" class="form-control" id="years">
  </div>
  <div class="form-group">
    <label for="loantype">Savings Type:</label>
    <select class="form-control" id="loantype">
      <option value="Business">Business</option>
      <option value="Personal">Personal</option>
    </select>
  </div>

</form>
<a class="btn btn-success" href="update-todo">Edit</a>

</body>

