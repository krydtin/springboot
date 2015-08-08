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

    @NotBlank
    private String comment;
    @NotBlank
    private String author;
}
