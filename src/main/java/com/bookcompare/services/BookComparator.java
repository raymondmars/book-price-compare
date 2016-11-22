package com.bookcompare.services;

import com.bookcompare.entities.Book;

import java.util.List;

/**
 * Created by Raymond on 22/11/2016.
 */
public class BookComparator {

    private String bookName;

    public BookComparator(String name) {
       this.bookName = name;
    }

    public List<Book> getComparableBooks() {
        return null;
    }
}
