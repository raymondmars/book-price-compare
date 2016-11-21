package com.bookcompare.services;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.ShopCode;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Raymond on 20/11/2016.
 */
class AmazonBookInfoSpider extends BookInfoSpiderBase {

    public AmazonBookInfoSpider(String searchName) {
        super(searchName);
    }
    @Override
    protected String buildSearchUrl() {
        return String.format("https://www.amazon.cn/s/ref=nb_sb_noss_2?__mk_zh_CN=亚马逊网站&url=search-alias=stripbooks&field-keywords=%s", this.bookName);
    }

    @Override
    public Book getBook()  {
        Book book = new Book();
        book.setShop(ShopCode.AMAZON);
        book.setName(this.bookName);
        try {
            Document doc = this.loadPage();
            if(doc != null) {

                Element firstLi = doc.select("ul#s-results-list-atf > li").first(); // Get first book from search results by book name
                if(firstLi != null) {
                    String detailUrl = firstLi.select("a.s-access-detail-page").first().attr("href");
                    String imgUrl = firstLi.select("img.s-access-image").first().attr("src");
                    String price  = firstLi.select("span.s-price").first().text();
                    String name   = firstLi.select("h2.s-access-title").first().text();
                    book.setName(name);  //update book name;
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
