package com.bookcompare.dao;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.ShopCode;

import java.util.List;

/**
 * Created by Raymond on 23/11/2016.
 */
public interface IBookStore {
   List<Book> QueryByName(String name);
   void Save(Book book);
   boolean ExistedBook(ShopCode code, String name);
}
