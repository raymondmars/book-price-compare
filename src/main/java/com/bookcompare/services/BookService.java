package com.bookcompare.services;

import com.bookcompare.dao.IBookStore;
import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Raymond on 27/11/2016.
 */
@Service
class BookService implements IBookService {

    @Autowired
    IBookStore bookDao;

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public Book getBook(OnlineShop shop, String bookName) {
        return bookDao.getBook(shop, bookName);
    }

    @Override
    public List<Book> queryByName(OnlineShop shop, String name) {
        return bookDao.queryByName(shop, name);
    }


}
