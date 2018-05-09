package com.springboot.practice.service;

import com.springboot.practice.enums.AppConfigurations;
import com.springboot.practice.model.User;
import com.springboot.practice.model.UserAppConfiguration;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by sujia on 4/24/2018.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserAppConfigurationService configurationService;

    private User user;

    private User user1;

    @Before
    public void setUp(){
        user=new User();
        user1=new User();

        user.setUserName("test4");
        user.setUserPassword("test44");
        user.setUserEmailId("test@email");

        user1.setUserName("test2");
        user1.setUserPassword("test2");
        user1.setUserEmailId("test2@email");
    }

    @Test
    @Ignore
    public void testSaveAndGet(){
        /*User u =userService.saveUser(user);
        System.out.println(u);

        u = userService.saveUser(user1);
        System.out.println(u);
        List<User> users = userService.findall();
        System.out.println(users);
        List<User> users1 = userService.findByUserName("test");
        System.out.println(users1);

        UserAppConfiguration configuration = configurationService.findConfiguration("website_maintenance_status");
        System.out.println(configuration);
        configurationService.checkMaintenanceConfiguration(AppConfigurations.WEBSITE_MAINTENANCE);
*/
        List<User> users1 = userService.findByUserName("sdswfdw");
        System.out.println(users1);

        configurationService.saveWebsiteMaintenanceConfiguration(true);
        configurationService.saveWebsiteMaintenanceConfiguration(false);
    }
}
