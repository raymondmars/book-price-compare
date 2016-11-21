package com.bookcompare.services;


import com.bookcompare.common.*;
import com.bookcompare.entities.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by Raymond on 20/11/2016.
 */
public abstract class BookInfoSpiderBase {
    protected String bookName;
    protected String searchUrl;

    protected static final String requestAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36";

    public BookInfoSpiderBase(String name) {
        this.bookName = name;
        this.searchUrl = buildSearchUrl();
    }

    protected abstract String buildSearchUrl();

    protected Document loadPage() throws IOException{
        return Jsoup.connect(buildSearchUrl()).userAgent(requestAgent).get();
    }
    public abstract Book getBook();


    public static BookInfoSpiderBase getSpider(ShopCode code, String searchName) throws BzException {
       switch (code) {
           case JD:
               return new JdBookInfoSpider(searchName);
           case AMAZON:
               return new AmazonBookInfoSpider(searchName);
           case DANGDANG:
               return new DangdangBookInfoSpider(searchName);
           case WINXUAN:
               return new WinxuanBookInfoSpider(searchName);
           default:
               throw new BzException("Invalid online shop code.");
       }
    }
}
