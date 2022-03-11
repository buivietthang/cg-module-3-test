package service;

import dao.ProductDao;
import model.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    ProductDao productDao = new ProductDao();
    public ArrayList<Product> list = new ArrayList<>();

    public void show() {
        try {
            list = productDao.showProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void save(Product product) {
        try {
            productDao.addProduct(product);
            list = productDao.showProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void edit(Product product, int index) {
        try {
            productDao.editProduct(index, product);
            list = productDao.showProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(int index) {
        try {
            productDao.deleteProduct(list.get(index).getId());
            list = productDao.showProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> findByName(String name) {
        try {
            return productDao.findByName(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
