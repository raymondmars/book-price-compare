package com.bookcompare.controllers;

import com.bookcompare.common.BzException;
import com.bookcompare.entities.Book;
import com.bookcompare.entities.OnlineShop;
import com.bookcompare.entities.ShopCode;
import com.bookcompare.services.IOnlineShopService;
import com.bookcompare.services.BookComparator;
import com.bookcompare.services.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Raymond on 18/11/2016.
 */
@Controller
public class HomeController {
    @Autowired
    IBookService bookService;

    @Autowired
    IOnlineShopService shopService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        // model.addAttribute("message", "");
        // data init
        for(ShopCode code : ShopCode.values()) {
            if(!shopService.existedShop(code)) {
                OnlineShop shop = new OnlineShop();
                shop.setName(ShopCode.getShopNameByCode(code));
                shop.setCode(code.toString());
                shopService.save(shop);
            }

        }
        return "home/index";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<Book> search(@RequestParam(value = "keyword") String keyword) {
        if(keyword != null && keyword.trim() != "") {
            return new BookComparator(keyword.trim(), bookService).getComparableBooks();
        } else {
            return new ArrayList<Book>();
        }

    }
}
