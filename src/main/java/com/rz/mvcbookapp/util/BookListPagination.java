package com.rz.mvcbookapp.util;

import com.rz.mvcbookapp.dao.BookDAO;

/**
 * BookListPagination stores current page and length values and contains methods to implement pagination throughout the MVC application.
 */
public class BookListPagination {
    private static BookListPagination instance = null;
    private final BookDAO bookDAO;
    private final int pageLength;
    private int currentPage = 1;

    private BookListPagination(BookDAO bookDAO, int pageLength) {
        this.bookDAO = bookDAO;
        this.pageLength = pageLength;
    }

    // singleton design pattern used to maintain global variables such as page number
    public static BookListPagination getInstance(BookDAO bookDAO) {
        if (instance == null) {
            instance = new BookListPagination(bookDAO, 20);
        }
        return instance;
    }

    public int getStartPage(int pageNumber) {
        return pageNumber * pageLength;
    }

    public int getPageLength() {
        return pageLength;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int page) {
        this.currentPage = page;
    }

    // calculates number of pages at current page length to display all books.
    public int getNumberOfPages() {
        return Math.floorDiv(bookDAO.countBooks(), pageLength) + 2;
    }
}
