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
    public static String getShopNameByCode(ShopCode code) {
       switch (code) {
           case JD:
               return "京东商城";
           case AMAZON:
               return "亚马逊";
           case DANGDANG:
               return "当当网";
           case WINXUAN:
               return "文轩网";
           default:
               throw new RuntimeException("Unsupported code.");

       }
    }
}
