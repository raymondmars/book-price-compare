package com.bookcompare.services;


import com.bookcompare.common.*;
import com.bookcompare.entities.*;

/**
 * Created by Raymond on 20/11/2016.
 */
public abstract class BookInfoSpiderBase {
    protected String bookDetailUrl;
    protected double bookSellPrice;

    public BookInfoSpiderBase(String detailUrl) {
        this.bookDetailUrl = detailUrl;
        this.pickUpBookInfoFromWebsite();
    }

    // To fill book sell price in this method
    protected abstract void pickUpBookInfoFromWebsite();

    public  double getSellPrice() {
        return bookSellPrice;
    }

    public static BookInfoSpiderBase getSpider(ShopCode code, String detailUrl) throws BzException {
       switch (code) {
           case JD:
               return new JdBookInfoSpider(detailUrl);
           case AMAZON:
               return new AmazonBookInfoSpider(detailUrl);
           case DANGDANG:
               return new DangdangBookInfoSpider(detailUrl);
           case WINXUAN:
               return new WinxuanBookInfoSpider(detailUrl);
           default:
               throw new BzException("Invalid online shop code.");
       }
    }
}
