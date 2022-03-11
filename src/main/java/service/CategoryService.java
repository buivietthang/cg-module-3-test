package service;

import dao.CategoryDao;
import model.Category;

import java.sql.SQLException;
import java.util.ArrayList;

public class CategoryService {
    public ArrayList<Category> showCategory() throws SQLException {
        return CategoryDao.showCategory();
    }
}
