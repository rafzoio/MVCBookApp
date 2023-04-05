package com.rz.mvcbookapp.util;

import com.rz.mvcbookapp.dao.BookDAO;

public class BookListPagination {
    private static BookListPagination instance = null;
    private final BookDAO bookDAO;
    private final int pageLength;
    private int currentPage = 1;

    private BookListPagination(BookDAO bookDAO, int pageLength) {
        this.bookDAO = bookDAO;
        this.pageLength = pageLength;
    }

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

    public int getNumberOfPages() {
        return Math.floorDiv(bookDAO.getAllBooks().size(), pageLength) + 1;
    }
}
