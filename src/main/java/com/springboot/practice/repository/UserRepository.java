package com.springboot.practice.repository;

import com.springboot.practice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by sujia on 4/24/2018.
 */
@Repository
@EnableJpaRepositories
public interface UserRepository  extends JpaRepository<User, Long>{

    public List<User> findByUserName(String userName);

    public int countByUserNameAndUserPassword(String userName, String userPassword);
}
