package com.bookcompare.services.spider;


import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.spider.BookInfoSpiderBase;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;

/**
 * Created by Raymond on 20/11/2016.
 */
class JdBookInfoSpider extends BookInfoSpiderBase {

    public JdBookInfoSpider(String searchName) {
        super(searchName);
    }

    @Override
    protected String buildSearchUrl() throws UnsupportedEncodingException {
        String searchName = URLEncoder.encode(this.bookName, "UTF-8");

        return String.format("https://search.jd.com/Search?keyword=%s&enc=utf-8&book=y&wq=%s&pvid=mzhzysvi.zgty1w", searchName, searchName);
    }

    @Override
    public Book getBook()  {
        Book book = new Book();
        book.setShop(new OnlineShop("京东商城", ShopCode.JD));
        book.setName(this.bookName);
        try {
            Document doc = this.loadPage();
            if(doc != null) {
                Element firstLi = doc.select("ul.gl-warp > li").first(); // Get first book from search results by book name
                if(firstLi != null) {
                    String detailUrl = firstLi.select("div.p-name > a").first().attr("href");
                    String imgUrl = firstLi.select("div.p-img > a > img").first().attr("src");
                    String price  = firstLi.select("div.p-price > strong > i").first().text();
                    String name   = firstLi.select("div.p-name > a > em").first().text();
                    book.setName(name);  //update book name
                    book.setDetailUrl(detailUrl);
                    book.setSellPrice(new BigDecimal(price));
                    book.setImageUrl(imgUrl);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return book;
    }


}
