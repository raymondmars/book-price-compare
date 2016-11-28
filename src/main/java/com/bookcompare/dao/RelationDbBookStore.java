package com.bookcompare.dao;

import com.bookcompare.entities.OnlineShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bookcompare.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Raymond on 27/11/2016.
 */
@Repository
class RelationDbBookStore implements IBookStore {

    @Autowired
    protected HibernateTemplate hibernateTmplMysql;

    @Override
    public List<Book> queryByName(OnlineShop shop, String name) {
        if(!hibernateTmplMysql.find("from Book b where b.shop = ? and b.name like ?", shop, "%" + name + "%").isEmpty()) {
            return (List<Book>)hibernateTmplMysql.find("from Book b where b.shop = ? and b.name like ?", shop, "%" + name + "%");
        } else {
            return new ArrayList<>();
        }

    }

    @Override
    public void save(Book book) {
        hibernateTmplMysql.save(book);
    }

    @Override
    public Book getBook(OnlineShop shop, String name) {
        Optional<Book> book = (Optional<Book>) hibernateTmplMysql.find("from Book b where b.shop = ? and b.name = ?", shop, name).stream().findFirst();
        if (book.isPresent()) {
            return book.get();
        } else {
            return null;
        }
//        if(!hibernateTmplMysql.find("from Book b where b.shop = ? and b.name = ?", shop, name).isEmpty()) {
//            Optional<Book> book = (Optional<Book>) hibernateTmplMysql.find("from Book b where b.shop = ? and b.name = ?", shop, name).stream().findFirst();
//            if (book.isPresent()) {
//                return book.get();
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
    }

}
