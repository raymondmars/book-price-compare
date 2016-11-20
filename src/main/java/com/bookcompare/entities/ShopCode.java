package com.bookcompare.entities;

/**
 * Created by Raymond on 20/11/2016.
 */
public  enum ShopCode {
    JD, AMAZON, DANGDANG, WINXUAN;

    public static ShopCode getCodeByName(String name) {
       if(name.toUpperCase() == "JD") {
           return JD;
       }
       if(name.toUpperCase() == "AMAZON") {
            return AMAZON;
       }
       if(name.toUpperCase() == "DANGDANG") {
            return DANGDANG;
       }
       if(name.toUpperCase() == "WINXUAN") {
            return WINXUAN;
       }
       throw new RuntimeException("Invalid shop code name.");
    }
}
