package com.bookcompare.dao;

import com.bookcompare.entities.OnlineShop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Raymond on 28/11/2016.
 */
@Repository
class OnlineShopImpl implements IOnlineShopDao {

    @Autowired
    protected HibernateTemplate hibernateTmplMysql;

    @Override
    public boolean existedShop(String code) {
        return !hibernateTmplMysql.find("from OnlineShop o where o.code = ?", code).isEmpty();
    }

    @Override
    public void save(OnlineShop shop) {
        hibernateTmplMysql.save(shop);
    }
}
