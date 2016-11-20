package com.bookcompare.entities;

import java.util.Date;
import java.util.List;

/**
 * Created by Raymond on 20/11/2016.
 */
public class Book {
    private int id;
    private String name;
    private double originalPrice;
    private List<PriceInShop> sellPrices;
    private BookCategory category;
    private String shortDesc;
    private String author;
    private String press;
    private Date publicationDate;

}
