package com.krydtin.training.springboot.controller;

import com.krydtin.training.springboot.dto.Comment;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author krydtin
 */
@RestController
@RequestMapping("/api")
public class HomeRestController {

    @RequestMapping(method = RequestMethod.GET)
    public Comment home() {
        final Comment comment = new Comment();
        comment.setAuthor("Tom");
        comment.setComment("Tom's Comment");
        return comment;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@Validated @RequestBody final Comment comment) {
        return comment;
    }
}