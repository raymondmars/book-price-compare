package com.bookcompare.controllers;

import com.bookcompare.entities.Book;
import com.bookcompare.services.BookComparator;
import org.hibernate.annotations.Parameter;
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
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
//        model.addAttribute("message", "Hello, Robot.");
        return "home/index";
    }
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<Book> search(@RequestParam(value = "keyword") String keyword) {
        if(keyword != null && keyword.trim() != "") {
            return new BookComparator(keyword.trim()).getComparableBooks();
        } else {
            return new ArrayList<Book>();
        }

    }
}
