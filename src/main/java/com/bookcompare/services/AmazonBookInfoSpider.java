package com.bookcompare.services;

/**
 * Created by Raymond on 20/11/2016.
 */
class AmazonBookInfoSpider extends BookInfoSpiderBase {

    public AmazonBookInfoSpider(String detailUrl) {
        super(detailUrl);
    }
    @Override
    protected void pickUpBookInfoFromWebsite() {
        //// TODO: 20/11/2016  pick up book info from  Amazon China website by a url

    }
}
