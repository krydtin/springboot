package com.krydtin.training.springboot.repository;

import com.krydtin.training.springboot.dto.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krydtin
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    //JpaRepository<Comment, Integer> --> Integer is PK 

    //Search Keyword: Query methods
    public List<Comment> findByCommentLike(String comment);

    public List<Comment> findByCommentAndAuthor(String comment, String author);
}
