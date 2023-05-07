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

@WebServlet(name = "UpdateBook", value = "/updateBook")
public class UpdateBookServlet extends HttpServlet {

    private BookDAO bookDAO;
    @Override
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get id from request
        int id = Integer.parseInt(request.getParameter("id"));

        // set existing book attribute and navigate to update book jsp
        request.setAttribute("book", bookDAO.getBookByID(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/update-book.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // get request body parameters and update book accordingly
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String date = request.getParameter("date");
        String genres = request.getParameter("genres");
        String characters = request.getParameter("characters");
        String synopsis = request.getParameter("synopsis");
        bookDAO.updateBook(new Book(id, title, author, date, genres, characters, synopsis));

        // navigate back to all books jsp
        response.sendRedirect(request.getContextPath() + "/books");
    }

}
