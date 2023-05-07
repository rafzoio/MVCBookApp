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

    private BookDAO bookDAO;

    private BookListPagination blp;

    @Override
    public void init() {
        // initialises dependencies
        bookDAO = new BookDAO();
        blp = BookListPagination.getInstance(bookDAO);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        // gets current page parameter from request
        String pageParam = request.getParameter("page");

        // generates page number from parameter defaulting to 1 if null
        int pageNumber = pageParam == null ? 1 : Integer.parseInt(pageParam);

        // sets current page in pagination object
        blp.setCurrentPage(pageNumber);

        // gets books for current page
        List<Book> books = bookDAO.getNumberOfBooks(950 + blp.getStartPage(pageNumber), blp.getPageLength());

        int numberOfPages = blp.getNumberOfPages();

        // set page attributes and navigate to book list page.
        request.setAttribute("books", books);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("numberOfPages", numberOfPages);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-list.jsp");
        dispatcher.forward(request, response);
    }
}
