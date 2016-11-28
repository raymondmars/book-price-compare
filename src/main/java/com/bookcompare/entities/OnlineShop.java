package com.bookcompare.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Raymond on 20/11/2016.
 */
@Entity
@Table(name = "online_shops")
public class OnlineShop implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 10, unique = true)
    private String code;

    private String webSite;

    public OnlineShop() {

    }
    public OnlineShop(String name, ShopCode code) {
        this.name = name;
        this.code = code.toString();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }



}
