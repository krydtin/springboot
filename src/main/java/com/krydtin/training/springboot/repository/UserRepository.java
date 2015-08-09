package com.krydtin.training.springboot.repository;

import com.krydtin.training.springboot.dto.Users;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krydtin
 */
public interface UserRepository extends JpaRepository<Users, String> {

}
