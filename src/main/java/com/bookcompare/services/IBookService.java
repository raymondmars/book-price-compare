package com.bookcompare.services;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;

import java.util.List;

/**
 * Created by Raymond on 27/11/2016.
 */
public interface IBookService {
    void save(Book book);
    Book getBook(OnlineShop shop, String bookName);
    List<Book> queryByName(OnlineShop shop, String name);
}
