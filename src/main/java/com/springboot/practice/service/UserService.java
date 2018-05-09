package com.springboot.practice.service;

import com.springboot.practice.enums.AppConfigurations;
import com.springboot.practice.enums.AppStatus;
import com.springboot.practice.model.User;
import com.springboot.practice.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * Created by sujia on 4/24/2018.
 */
@Service
@Transactional
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserAppConfigurationService configurationService;

    public User findByUserId(Long userId){
        return userRepository.findById(userId).get();
    }
    public List<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    public List<User> findall(){
        return userRepository.findAll();
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }

    private String authenticateUser(User user){
        String message;
        int count = userRepository.countByUserNameAndUserPassword(user.getUserName(), user.getUserPassword());
        if(count!=0){
            LOGGER.info("user service = "+user +" count = "+count);
            message = user.getUserName()+" : authenticated user!";
        }
        else{
            LOGGER.info("not found ; count = "+count);
            message = user.getUserName()+" : unauthenticated user!";
        }
        return message;
    }
    public String checkMaintenanceServiceAndAuthenticateUser(User user){

        Map<AppStatus, String> statusStringMap = configurationService.checkMaintenanceConfiguration(AppConfigurations.WEBSITE_MAINTENANCE);

        if(statusStringMap.containsKey(AppStatus.WEBSITE_STATUS_MAINTENANCE)){
            return statusStringMap.get(AppStatus.WEBSITE_STATUS_MAINTENANCE);
        }
        else{
            return authenticateUser(user);
        }
    }

}
