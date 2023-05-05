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
        bookDAO = new BookDAO();
        blp = BookListPagination.getInstance(bookDAO);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String pageParam = request.getParameter("page");

        int pageNumber = pageParam == null ? 1 : Integer.parseInt(pageParam);

        blp.setCurrentPage(pageNumber);

        List<Book> books = bookDAO.getNumberOfBooks(950 + blp.getStartPage(pageNumber), blp.getPageLength());

        int numberOfPages = blp.getNumberOfPages();

        request.setAttribute("books", books);
        request.setAttribute("pageNumber", pageNumber);
        request.setAttribute("numberOfPages", numberOfPages);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/book-list.jsp");
        dispatcher.forward(request, response);
    }
}
