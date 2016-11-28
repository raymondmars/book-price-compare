package com.bookcompare.services;

import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;

/**
 * Created by Raymond on 28/11/2016.
 */
public interface IOnlineShopService {
    boolean existedShop(ShopCode code);
    void save(OnlineShop shop);

}
