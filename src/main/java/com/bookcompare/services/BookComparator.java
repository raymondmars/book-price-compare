package com.bookcompare.services;

import com.bookcompare.common.BzException;
import com.bookcompare.entities.Book;
import com.bookcompare.entities.ShopCode;

import java.util.ArrayList;
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
        List<Book> result = new ArrayList<Book>();
        for(ShopCode code : ShopCode.values()) {
            try {
                Book book = BookInfoSpiderBase.getSpider(code, this.bookName).getBook();
                if(book.isValid()) {
                    result.add(book);
                }
            } catch (BzException bzE) {
               bzE.printStackTrace();
            }

        }
        return result;
    }
}
