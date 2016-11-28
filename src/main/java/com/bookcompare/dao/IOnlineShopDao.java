package com.bookcompare.dao;

import com.bookcompare.entities.OnlineShop;

/**
 * Created by Raymond on 28/11/2016.
 */
public interface IOnlineShopDao {
    boolean existedShop(String code);
    void save(OnlineShop shop);
}
