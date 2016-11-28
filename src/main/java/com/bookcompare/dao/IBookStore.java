package com.bookcompare.dao;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;

import java.util.List;

/**
 * Created by Raymond on 23/11/2016.
 */
public interface IBookStore {
   List<Book> queryByName(OnlineShop shop, String name);
   void save(Book book);
   Book getBook(OnlineShop shop, String name);

}
