<%--
  Created by IntelliJ IDEA.
  User: Black Pig
  Date: 12-May-24
  Time: 9:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Update</h1>
<form action="/updateemployee" method="post" class="row g-3">
    <div class="col-md-6">
        <label for="name" class="form-label">Name</label>
        <input type="text" name="name" class="form-control" id="name" value="${employee.name}">
    </div>
    <div class="col-md-6">
        <label for="address" class="form-label">Address</label>
        <input type="text" name="address" class="form-control" id="address" value="${employee.address}">
    </div>
    <div class="col-12">
        <label for="phone" class="form-label">Phone</label>
        <input type="text" name="phone" class="form-control" id="phone" value="${employee.phone}">
    </div>
    <div class=" col-md-4">
        <label for="status" class="form-label">Status</label>
        <select id="status" name="status" class="form-select">
            <option ${employee.status?"checked":""}>Work</option>
            <option ${employee.status?"":"checked"}>Not work</option>
        </select>
    </div>
    <div class="col-12">
        <button type="submit" class="btn btn-primary">Update</button>
    </div>
</form>
</body>
</html>
