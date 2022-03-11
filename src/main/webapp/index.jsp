<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container" style="margin-top:30px">
    <div class="row">
        <div class="col-sm-6">
            <h2><i>PRODUCT</i></h2>
            <form action="/?action=findName">
                <div>
                    <input type="text" class="form-control" placeholder="Search" name="findName">
                    <input type="text" hidden name="action" value="findName">
                    <div>
                        <button type="submit">Search</button>
                    </div>
                </div>
            </form>
            <br>
            <table class="table table-striped">
                <th>ID</th>
                <th>Name Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>ID Category</th>
                <th colspan="2">Action</th>
                <c:forEach items="${listProduct}" var="p" varStatus="loop">
                    <tr>
                        <td>${p.id}</td>
                        <td>${p.name}</td>
                        <td>${p.price}</td>
                        <td>${p.quantity}</td>
                        <td>${p.color}</td>
                        <td>${p.description}</td>
                        <td>${p.idCategory}</td>
                        <td><a href="/?action=delete&index=${loop.index}">Delete</a></td>
                        <td><a href="/?action=edit&index=${loop.index}">Edit</a></td>
                    </tr>
                </c:forEach>
            </table>
            <td><a href="/?action=create">Create</a></td>
        </div>
    </div>
</div>
</body>
</html>
