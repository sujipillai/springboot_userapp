package com.springboot.practice.controller;

import com.springboot.practice.enums.AppConfigurations;
import com.springboot.practice.enums.AppStatus;
import com.springboot.practice.model.User;
import com.springboot.practice.model.UserAppConfiguration;
import com.springboot.practice.service.UserAppConfigurationService;
import com.springboot.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by sujia on 4/24/2018.
 */
@RestController
public class UserController {

    @Autowired
    private UserAppConfigurationService configurationService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String hello(){
        String message = "hello";
        return message;
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        String message ="";

        /*
        System.out.println(user);
        //PUT THIS ALL DATA IN ANY SERVICE CALL OF USER LOGIN LATER...
        Map<AppStatus, String> statusStringMap = configurationService.checkMaintenanceConfiguration(AppConfigurations.WEBSITE_MAINTENANCE);

        if(statusStringMap.containsKey(AppStatus.WEBSITE_STATUS_MAINTENANCE)){
            return statusStringMap.get(AppStatus.WEBSITE_STATUS_MAINTENANCE);
        }
        else {
            if(user.getUserName().equals(user.getUserPassword())){
                message = "authorized user";
            }
            else{
                message = "unauthorized user";
            }
            return message;
        }*/
        message = userService.checkMaintenanceServiceAndAuthenticateUser(user);
        return message;
    }
    @RequestMapping(value = "/loginbyurl/",method = RequestMethod.GET)
    public String loginByUrl(@RequestParam("name") String username, @RequestParam ("password") String password){
        User user =new User();
        user.setUserName(username);
        user.setUserPassword(password);
        String message ="";
        message = userService.checkMaintenanceServiceAndAuthenticateUser(user);
        return message;
    }

    @RequestMapping(value = "/setmaintenance")
    public String setmaintenance(){
        UserAppConfiguration configuration = configurationService.saveWebsiteMaintenanceConfiguration(true);
        return "config val = "+configuration.getConfigValue();
    }

    @RequestMapping(value = "/resetmaintenance")
    public String removeMaintenanceStatus(){
        UserAppConfiguration configuration = configurationService.saveWebsiteMaintenanceConfiguration(false);
        return "config val = "+configuration.getConfigValue();
    }

}
