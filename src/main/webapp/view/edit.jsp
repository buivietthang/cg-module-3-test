<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post">
        <table border="1">
            <tr>
                <th>ID</th>
                <th>Name Product</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Color</th>
                <th>Description</th>
                <th>ID Category</th>
            </tr>
            <tr>
                <td><input type="text" name="id" value="${listEdit.id}" readonly></td>
                <td><input type="text" name="name" value="${listEdit.name}"></td>
                <td><input type="text" name="price" value="${listEdit.price}"></td>
                <td><input type="text" name="quantity" value="${listEdit.quantity}"></td>
                <td><input type="text" name="color" value="${listEdit.color}"></td>
                <td><input type="text" name="description" value="${listEdit.description}"></td>
                <td><input type="text" name="idCategory" value="${listEdit.idCategory}"></td>
            </tr>
            <button type="submit">Update Product</button>
        </table>
    </form>
</body>
</html>
