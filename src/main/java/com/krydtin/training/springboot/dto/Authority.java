package com.krydtin.training.springboot.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author krydtin
 */
@Entity
@Setter
public class Authority implements GrantedAuthority {

    @Id
    private String authority;

    @Override
    public String getAuthority() {
        return this.authority;
    }

}
