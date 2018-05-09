package com.springboot.practice.repository;

import com.springboot.practice.model.UserAppConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sujia on 4/25/2018.
 */
@Repository
public interface UserAppConfigurationRepository extends JpaRepository<UserAppConfiguration, Integer> {
    public UserAppConfiguration findByConfigName(String configName);
}
