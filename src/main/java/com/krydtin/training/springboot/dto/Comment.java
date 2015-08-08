package com.krydtin.training.springboot.dto;

import com.krydtin.training.springboot.validate.StartWith;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author krydtin
 */
@Getter
@Setter
public class Comment {

    @StartWith(value = "a")
    @NotBlank(message = "comment can't be empty")
    private String comment;
    @NotBlank(message = "Author can't be empty")
    private String author;
}
