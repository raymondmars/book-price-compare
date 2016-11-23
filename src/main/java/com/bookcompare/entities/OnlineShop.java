package com.bookcompare.entities;

/**
 * Created by Raymond on 20/11/2016.
 */
public class OnlineShop {
    private int id;
    private String name;
    private ShopCode code;
    private String webSite;

    public OnlineShop() {

    }
    public OnlineShop(String name, ShopCode code) {
        this.name = name;
        this.code = code;
    }
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
        this.name = name;
    }

    public ShopCode getCode() {
        return code;
    }

    public void setCode(ShopCode code) {
        this.code = code;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }



}
