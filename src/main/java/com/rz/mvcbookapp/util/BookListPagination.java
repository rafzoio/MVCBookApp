package com.rz.mvcbookapp.util;

import com.rz.mvcbookapp.dao.BookDAO;

public class BookListPagination {
    private final BookDAO bookDAO;
    private final int pageLength;

    public BookListPagination(BookDAO bookDAO, int pageLength) {
        this.bookDAO = bookDAO;
        this.pageLength = pageLength;
    }

    public int getStartPage(int pageNumber) {
        return pageNumber * pageLength;
    }

    public int getPageLength() {
        return pageLength;
    }

    public int getNumberOfPages() {
        return Math.floorDiv(bookDAO.getAllBooks().size(), pageLength);
    }
}
