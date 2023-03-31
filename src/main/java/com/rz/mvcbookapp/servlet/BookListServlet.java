package com.rz.mvcbookapp.servlet;

import com.rz.mvcbookapp.dao.BookDAO;
import com.rz.mvcbookapp.model.Book;
import com.rz.mvcbookapp.util.BookListPagination;
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

        String pageParam = request.getParameter("page");

        int pageNumber = pageParam == null ? 1 : Integer.parseInt(pageParam);

        BookListPagination blp = new BookListPagination(bookDAO, 50);

        List<Book> books = bookDAO.getNumberOfBooks(blp.getStartPage(pageNumber), blp.getPageLength());

        request.setAttribute("books", books);
        request.setAttribute("numPages", blp.getNumberOfPages());

        // Forward the request to the JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-list.jsp");
        dispatcher.forward(request, response);
    }
}
