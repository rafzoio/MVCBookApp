package com.rz.mvcbookapp.servlet;

import com.rz.mvcbookapp.dao.BookDAO;
import com.rz.mvcbookapp.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;
import java.util.List;

@WebServlet(name = "BookList", value = "/books")
public class BookListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        BookDAO bookDAO = new BookDAO();

        List<Book> books = bookDAO.getNumberOfBooks(1001, 10);

        request.setAttribute("books", books);

        // Forward the request to the JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-list.jsp");
        dispatcher.forward(request, response);
    }
}
