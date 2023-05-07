package com.rz.mvcbookapp.servlet;

import com.rz.mvcbookapp.dao.BookDAO;
import com.rz.mvcbookapp.util.BookListPagination;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "DeleteBook", value = "/deleteBook")
public class DeleteBookServlet extends HttpServlet {

    private BookListPagination blp;
    private BookDAO bookDAO;
    @Override
    public void init() {
        // initialising dependencies
        bookDAO = new BookDAO();
        blp = BookListPagination.getInstance(bookDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // get id to delete
        int id = Integer.parseInt(request.getParameter("id"));

        bookDAO.deleteBook(id);

        // navigate to current page stored in pagination class.
        response.sendRedirect(request.getContextPath()+"/books?page="+blp.getCurrentPage());
    }
}
