package dao;

import model.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductDao {
    Connection connection = ConnectMySQL.getConnection();

    public ArrayList<Product> showProduct() throws SQLException {
        String select = "select * from product";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Product> list = new ArrayList<>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int idCategory = resultSet.getInt("idCategory");
            list.add(new Product(id, name, price, quantity, color, description, idCategory));
        }
        return list;
    }

    public void addProduct(Product product) throws SQLException {
        String insert = "insert into product value(?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insert);
        preparedStatement.setInt(1, product.getId());
        preparedStatement.setString(2, product.getName());
        preparedStatement.setDouble(3, product.getPrice());
        preparedStatement.setInt(4, product.getQuantity());
        preparedStatement.setString(5, product.getColor());
        preparedStatement.setString(6, product.getDescription());
        preparedStatement.setInt(7, product.getIdCategory());
        preparedStatement.execute();
    }

    public void editProduct(int index, Product product) throws SQLException {
        String update = "update product set name=?, price=?, quantity=?, color=?, description=?, idCategory=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(update);
        preparedStatement.setString(1, product.getName());
        preparedStatement.setDouble(2, product.getPrice());
        preparedStatement.setInt(3, product.getQuantity());
        preparedStatement.setString(4, product.getColor());
        preparedStatement.setString(5, product.getDescription());
        preparedStatement.setInt(6, product.getIdCategory());
        preparedStatement.setInt(7, product.getId());
        preparedStatement.execute();
    }

    public void deleteProduct(int id) throws SQLException {
        String delete = "delete from product where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
    }

    public ArrayList<Product> findByName(String findName) throws SQLException {
        ArrayList<Product> findList = new ArrayList<>();
        String findByName = "select * from product where name like '%" + findName + "%'";
        PreparedStatement preparedStatement = connection.prepareStatement(findByName);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Double price = resultSet.getDouble("price");
            int quantity = resultSet.getInt("quantity");
            String color = resultSet.getString("color");
            String description = resultSet.getString("description");
            int idCategory = resultSet.getInt("idCategory");
            findList.add(new Product(id, name, price, quantity, color, description, idCategory));
        }
        return findList;
    }
}
