package com.krydtin.training.springboot.controller;

import com.krydtin.training.springboot.dto.Comment;
import com.krydtin.training.springboot.repository.CommentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Comment> home() {
        return commentRepository.findAll();
    }

    @Secured("ROLE_ADMIN")
    @RequestMapping(method = RequestMethod.POST)
    public Comment save(@Validated @RequestBody final Comment comment) {
        return commentRepository.save(comment);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Comment> delete(@PathVariable("id") final Integer id) {
        commentRepository.delete(id);
        return commentRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Comment update(@Validated @RequestBody final Comment comment) {
        return commentRepository.save(comment);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Comment findOne(@PathVariable("id") final Integer id) {
        return commentRepository.findOne(id);
    }

    @RequestMapping(value = "/search/{comment}", method = RequestMethod.GET)
    public List<Comment> searchComment(@PathVariable("comment") final String keyword) {
        return commentRepository.findByCommentLike("%" + keyword + "%");
    }

    @RequestMapping(value = "/find/{comment}/{author}", method = RequestMethod.GET)
    public List<Comment> findCommentAndAuthor(@PathVariable("comment") final String comment,
            @PathVariable("author") final String author) {
        return commentRepository.findByCommentAndAuthor(comment, author);
    }
}
