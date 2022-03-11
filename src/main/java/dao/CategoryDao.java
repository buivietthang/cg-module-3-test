package dao;

import model.Category;

import java.sql.*;
import java.util.ArrayList;

public class CategoryDao {
    static Connection connection = ConnectMySQL.getConnection();

    public static ArrayList<Category> showCategory() throws SQLException {
        String select = "select * from category";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(select);
        ArrayList<Category> list = new ArrayList<>();
        while (resultSet.next()) {
            int idCategory = resultSet.getInt("idCategory");
            String nameCategory = resultSet.getString("nameCategory");
            list.add(new Category(idCategory, nameCategory));
        } return list;
    }
}
