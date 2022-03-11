<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/?action=create" method="post">
    <table border="1">
        <tr>
            <th>Name Product</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>ID Category</th>
        </tr>
        <tr>
            <td><input type="text" name="name" placeholder="Enter Name"></td>
            <td><input type="text" name="price" placeholder="Enter Price"></td>
            <td><input type="text" name="quantity" placeholder="Enter Quantity"></td>
            <td><input type="text" name="color" placeholder="Enter Color"></td>
            <td><input type="text" name="description" placeholder="Enter Description"></td>
            <td><input type="text" name="idCategory" placeholder="Enter ID Category"></td>
        </tr>
        <button type="submit">Create</button>
    </table>
</form>
</body>
</html>
