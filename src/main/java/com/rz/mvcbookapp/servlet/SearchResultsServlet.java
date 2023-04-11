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
import java.util.List;

@WebServlet(name = "SearchResultsServlet", value = "/search")
public class SearchResultsServlet extends HttpServlet {

    private BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String searchQuery = request.getParameter("q");

        List<Book> books = bookDAO.searchBooks(searchQuery);

        request.setAttribute("books", books);
        request.setAttribute("searchQuery", searchQuery);

        // Forward the request to the JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search-list.jsp");
        dispatcher.forward(request, response);
    }
}
