package controller;

import model.Product;
import service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns = {""})
public class ProductServlet extends HttpServlet {
    ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher;
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                response.sendRedirect("view/create.jsp");
                break;
            case "delete":
                int index = Integer.parseInt(request.getParameter("index"));
                productService.delete(index);
                response.sendRedirect("/");
                break;
            case "edit":
                int indexEdit = Integer.parseInt(request.getParameter("index"));
                request.setAttribute("listEdit", productService.list.get(indexEdit));
                requestDispatcher = request.getRequestDispatcher("view/edit.jsp");
                requestDispatcher.forward(request, response);
                break;
            case "findName":
                String name = request.getParameter("findName");
                request.setAttribute("listProduct", productService.findByName(name));
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
                break;
            default:
                productService.show();
                request.setAttribute("listProduct", productService.list);
                requestDispatcher = request.getRequestDispatcher("index.jsp");
                requestDispatcher.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = request.getParameter("name");
                Double price = Double.parseDouble(request.getParameter("price"));
                int quantity = Integer.parseInt(request.getParameter("quantity"));
                String color = request.getParameter("color");
                String description = request.getParameter("description");
                int idCategory = Integer.parseInt(request.getParameter("idCategory"));
                Product product = new Product(name, price, quantity, color, description, idCategory);
                productService.save(product);
                response.sendRedirect("/");
                break;
            case "edit":
                int idEdit = Integer.parseInt(request.getParameter("id"));
                String nameEdit = request.getParameter("name");
                Double priceEdit = Double.parseDouble(request.getParameter("price"));
                int quantityEdit = Integer.parseInt(request.getParameter("quantity"));
                String colorEdit = request.getParameter("color");
                String descriptionEdit = request.getParameter("description");
                int idCategoryEdit = Integer.parseInt(request.getParameter("idCategory"));
                Product productEdit = new Product(idEdit, nameEdit, priceEdit, quantityEdit, colorEdit, descriptionEdit, idCategoryEdit);
                int indexEdit = Integer.parseInt(request.getParameter("index"));
                productService.edit(productEdit, indexEdit);
                response.sendRedirect("/");
                break;
        }
    }
}
