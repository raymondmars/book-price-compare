package com.bookcompare.entities;

import java.math.BigDecimal;

/**
 * Created by Raymond on 20/11/2016.
 */
public class Book {
    private int id;
    private String name;
    private OnlineShop shop;
    private BigDecimal sellPrice;
    private String imageUrl;
    private String detailUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name != null ? name.trim() : name;
    }

    public OnlineShop getShop() {
        return shop;
    }

    public void setShop(OnlineShop shop) {
        this.shop = shop;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public boolean isValid() {
        return this.name != null && this.name.trim() != "" && this.sellPrice != null;
    }
    @Override
    public String toString() {
        if(isValid()) {
            return String.format("%s @ %s, sell price: ￥%s", this.name, this.shop, this.sellPrice);
        } else {
            return String.format("%s @ %s, Not Found", this.name, this.shop, this.sellPrice);
        }
    }

}
