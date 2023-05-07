package com.rz.mvcbookapp.servlet;

import com.rz.mvcbookapp.dao.BookDAO;
import com.rz.mvcbookapp.model.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "BookDetail", value = "/bookDetail")
public class BookDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get id from parameter
        int id = Integer.parseInt(request.getParameter("id"));

        BookDAO bookDAO = new BookDAO();

        // get book from database by id
        Book book = bookDAO.getBookByID(id);


        // forward the request to the book detail page
        request.setAttribute("book", book);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-detail.jsp");
        dispatcher.forward(request, response);
    }

}
