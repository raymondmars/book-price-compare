package com.bookcompare.services;


import com.bookcompare.entities.Book;
import com.bookcompare.entities.ShopCode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Raymond on 20/11/2016.
 */
class JdBookInfoSpider extends BookInfoSpiderBase {

    public JdBookInfoSpider(String searchName) {
        super(searchName);
    }

    @Override
    protected String buildSearchUrl() {
        return String.format("https://search.jd.com/Search?keyword=%s&enc=utf-8&wq=%s&pvid=szeo3svi.zgty1w", this.bookName, this.bookName);
    }

    @Override
    public Book getBook()  {
        Book book = new Book();
        book.setShop(ShopCode.JD);
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
