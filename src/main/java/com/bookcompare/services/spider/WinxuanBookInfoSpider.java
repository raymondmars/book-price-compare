package com.bookcompare.services.spider;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.spider.BookInfoSpiderBase;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Raymond on 20/11/2016.
 */
class WinxuanBookInfoSpider extends BookInfoSpiderBase {

    public WinxuanBookInfoSpider(String searchName) {
        super(searchName);
    }
    @Override
    protected String buildSearchUrl() {
        return String.format("http://search.winxuan.com/search?keyword=%s&type=", this.bookName);
    }

    @Override
    public Book getBook() {
        Book book = new Book();
        book.setShop(new OnlineShop("文轩网上书店", ShopCode.WINXUAN));
        book.setName(this.bookName);
        try {
            Document doc = this.loadPage();
            if(doc != null) {
                Element firstLi = doc.select("ul#list > li").first(); // Get first book from search results by book name
                if(firstLi != null) {
                    String detailUrl = firstLi.select("div.name > a").first().attr("href");
                    String imgUrl = firstLi.select("div.img > a > img").first().attr("src");
                    String price  = firstLi.select("div.price > div.price-n").first().ownText();
                    String name   = firstLi.select("div.name > a").first().ownText();
                    book.setName(name);  //update book name
                    book.setDetailUrl(detailUrl);
                    book.setSellPrice(new BigDecimal(price.replace("￥", "").replaceAll("\\s", "")));
                    book.setImageUrl(imgUrl);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return book;
    }
}
