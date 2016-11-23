package com.bookcompare.services;

import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Created by Raymond on 20/11/2016.
 */
class DangdangBookInfoSpider extends BookInfoSpiderBase {

    public DangdangBookInfoSpider(String searchName) {
        super(searchName);
    }
    @Override
    protected String buildSearchUrl() {
        return String.format("http://search.dangdang.com/?key=%s&act=input", this.bookName);
    }

    @Override
    public Book getBook() {
        Book book = new Book();
        book.setShop(new OnlineShop("当当网", ShopCode.DANGDANG));
        book.setName(this.bookName);
        try {
            Document doc = this.loadPage();
            if(doc != null) {
                //确保只在当当网搜索书籍，其他内容视为无效
                if(doc.select("div#search_nature_rg > ul.cloth_shoplist").first() == null) {
                    Element firstLi = doc.select("div#search_nature_rg > ul.bigimg > li").first(); // Get first book from search results by book name
                    if(firstLi != null) {
                        String detailUrl = firstLi.select("p.name > a").first().attr("href");
                        String imgUrl = firstLi.select("a.pic > img").first().attr("src");
                        String price  = firstLi.select("p.price > span.search_now_price").first().ownText();
                        String name   = firstLi.select("a.pic").first().attr("title");
                        book.setName(name);  //update book name
                        book.setDetailUrl(detailUrl);
                        book.setSellPrice(new BigDecimal(price.replace("¥", "").replaceAll("\\s", "")));
                        book.setImageUrl(imgUrl);
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return book;
    }
}
