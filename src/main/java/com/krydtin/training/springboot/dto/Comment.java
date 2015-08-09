package com.krydtin.training.springboot.dto;

import com.krydtin.training.springboot.validate.StartWith;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author krydtin
 */
@Getter
@Setter
@Entity
public class Comment {

    @Id
    @GeneratedValue //Auto increment
    private Integer id;

//    @StartWith(value = "a")
    @NotBlank(message = "comment can't be empty")
    private String comment;
    @NotBlank(message = "Author can't be empty")
    private String author;
}
