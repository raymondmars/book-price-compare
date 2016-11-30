package com.bookcompare.services;

import com.bookcompare.common.BzException;
import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.spider.BookInfoSpiderBase;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond on 22/11/2016.
 */
public class BookComparator {

    private IBookService bookService;

    private String bookName;

    public BookComparator(String name, IBookService service) {
       this.bookName = name;
        bookService  = service;
    }

    public List<Book> getComparableBooks() {
        List<Book> result = new ArrayList<Book>();
        for(ShopCode code : ShopCode.values()) {
            try {
                OnlineShop shop = new OnlineShop();
                shop.setCode(code.toString());
                List<Book> list = bookService.queryByName(shop, this.bookName);
                if(list != null && list.size() > 0) {
                    //result.addAll(list);
                    result.add(list.get(0));
                } else {
                    Book book = BookInfoSpiderBase.getSpider(code, this.bookName).getBook();
                    if(book.isValid()) {
                        // 每个spider会更新 book name, 所以这里需要再次检查
                        if(bookService.getBook(shop, book.getName()) == null) {
                            bookService.save(book);
                        }
                        result.add(book);
                    }
                }

            } catch (BzException bzE) {
               bzE.printStackTrace();
            }

        }
        result.sort((o1,o2) -> o1.getSellPrice().compareTo(o2.getSellPrice()));
        return result;
    }
}
