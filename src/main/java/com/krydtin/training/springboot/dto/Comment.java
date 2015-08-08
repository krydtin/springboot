package com.krydtin.training.springboot.dto;

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

    @NotBlank(message = "comment can't be empty")
    private String comment;
    @NotBlank(message = "Author can't be empty")
    private String author;
}
