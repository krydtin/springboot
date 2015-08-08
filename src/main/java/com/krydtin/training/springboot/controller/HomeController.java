package com.krydtin.training.springboot.controller;

import com.krydtin.training.springboot.dto.Comment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author krydtin
 */
@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String home(Model model) {
        final Comment comment = new Comment();
        comment.setAuthor("John");
        comment.setComment("Test Comment");

        model.addAttribute("comment", comment);
        return "index";
    }

}
