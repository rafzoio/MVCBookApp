package com.rz.mvcbookapp.dao;

import com.rz.mvcbookapp.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {

    Book book = null;
    Connection conn = null;
    String user = "zoioraph";
    String password = "hertHopl9";
    String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/zoioraph";

    public BookDAO() {
    }


    /**
     * Method to initialise connection to database.
     */
    private void openConnection() {
        // loading jdbc driver for mysql
        try {
            Class.forName("com.mysql.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Method to close connection to database
      */
    private void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to generate a book object from jdbc result set
     * @param rs
     * @return Book
     */
    private Book getNextBook(ResultSet rs) {
        Book thisBook;
        try {

            thisBook = new Book(rs.getInt("id"), rs.getString("title"), rs.getString("author"), rs.getString("date"), rs.getString("genres"), rs.getString("characters"), rs.getString("synopsis"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return thisBook;
    }

    /**
     * Returns number of books contained in the database
     */
    public int countBooks() {

        openConnection();

        int count = 0;

        try {
            PreparedStatement getAllBooks = conn.prepareStatement("select count(*) from books;");

            ResultSet resultSet = getAllBooks.executeQuery();

            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
            getAllBooks.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }

        return count;
    }

    /**
     * Gets book from database by id
     * @param id
     * @return Book
     */
    public Book getBookByID(int id) {

        openConnection();
        book = null;

        try {
            PreparedStatement getBookById = conn.prepareStatement("select * from books where id=?;");
            getBookById.setInt(1, id);
            ResultSet rs1 = getBookById.executeQuery();

            while (rs1.next()) {
                book = getNextBook(rs1);
            }

            getBookById.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }

        return book;
    }

    /**
     * Adds new book to database
     * @param book
     */
    public void addBook(Book book) {
        openConnection();
        try {
            PreparedStatement addBook = conn.prepareStatement("INSERT INTO books (title, author, date, genres, characters, synopsis) VALUES (?,?,?,?,?,?)");
            addBook.setString(1, book.getTitle());
            addBook.setString(2, book.getAuthor());
            addBook.setString(3, book.getDate());
            addBook.setString(4, book.getGenres());
            addBook.setString(5, book.getCharacters());
            addBook.setString(6, book.getSynopsis());

            addBook.executeUpdate();

            addBook.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Deletes a book from the database by id
     * @param id
     */
    public void deleteBook(int id) {
        openConnection();
        try {
            PreparedStatement deleteBook = conn.prepareStatement("DELETE FROM books WHERE id = ?");
            deleteBook.setInt(1, id);

            deleteBook.executeUpdate();

            deleteBook.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Updates a book already present in the database.
     * @param book
     */
    public void updateBook(Book book) {
        openConnection();
        try {
            PreparedStatement updateBook = conn.prepareStatement("UPDATE books SET title = ?, author = ?, date = ?, genres = ?, characters = ?, synopsis = ? WHERE id = ?;");
            updateBook.setString(1, book.getTitle());
            updateBook.setString(2, book.getAuthor());
            updateBook.setString(3, book.getDate());
            updateBook.setString(4, book.getGenres());
            updateBook.setString(5, book.getCharacters());
            updateBook.setString(6, book.getSynopsis());
            updateBook.setInt(7, book.getId());

            updateBook.executeUpdate();

            updateBook.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }
    }

    /**
     * Returns a list of books with titles matching the search keyword.
     * @param keyword
     * @return matchingBooks
     */
    public List<Book> searchBooks(String keyword) {

        List<Book> matchingBooks = new ArrayList<>();
        openConnection();

        try {
            PreparedStatement getAllBooks = conn.prepareStatement("select * from books where title like ?;");
            getAllBooks.setString(1, "%" + keyword + "%");
            ResultSet rs1 = getAllBooks.executeQuery();

            while (rs1.next()) {
                book = getNextBook(rs1);
                matchingBooks.add(book);
            }

            getAllBooks.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }

        return matchingBooks;
    }

    /**
     * Gets a number of books starting from a certain id
     * @param i
     * @param pageLength
     * @return books
     */
    public List<Book> getNumberOfBooks(int i, int pageLength) {

        List<Book> books = new ArrayList<>();
        openConnection();

        try {
            PreparedStatement getNumberOfBooks = conn.prepareStatement("select * from books where id >= ? limit ?");
            getNumberOfBooks.setInt(1, i);
            getNumberOfBooks.setInt(2, pageLength);
            ResultSet rs1 = getNumberOfBooks.executeQuery();

            while (rs1.next()) {
                book = getNextBook(rs1);
                books.add(book);
            }

            getNumberOfBooks.close();
            closeConnection();
        } catch (SQLException se) {
            throw new RuntimeException(se);
        }

        return books;
    }
}
