package com.bookcompare.services;

import com.bookcompare.dao.IOnlineShopDao;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Raymond on 28/11/2016.
 */
@Service
class OnlineShopService implements IOnlineShopService {
    @Autowired
    IOnlineShopDao shopDao;

    @Override
    public boolean existedShop(ShopCode code) {
        return shopDao.existedShop(code.toString());
    }

    @Override
    public void save(OnlineShop shop) {
        shopDao.save(shop);
    }
}
