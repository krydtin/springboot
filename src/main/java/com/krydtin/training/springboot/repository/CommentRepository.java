package com.krydtin.training.springboot.repository;

import com.krydtin.training.springboot.dto.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krydtin
 */
public interface CommentRepository extends JpaRepository<Comment, Integer> {
//    JpaRepository<Comment, Integer> --> Integer is PK 
}
