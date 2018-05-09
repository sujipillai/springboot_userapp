package com.springboot.practice.service;

import com.springboot.practice.enums.AppConfigurations;
import com.springboot.practice.enums.AppStatus;
import com.springboot.practice.model.UserAppConfiguration;
import com.springboot.practice.repository.UserAppConfigurationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sujia on 4/25/2018.
 */
@Service
public class UserAppConfigurationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAppConfigurationService.class);
    @Autowired
    private UserAppConfigurationRepository configurationRepository;
    //UserAppConfigurationService{configId=1,
    //configName='website maintenance status',
    // configDescription='This configuration tells
    // whether the website is under maintenance or not.
    // If it is under maintenance then config-value=1.',
    // configValue=0,
    // configMessage='The website is under maintenance,
    // sorry for the inconvenience.', configVisibleInWebsite=true}

    public Map<AppStatus, String> checkMaintenanceConfiguration(AppConfigurations appConfiguration){
        Map<AppStatus, String> statusMessage =  new HashMap<>();
        if(appConfiguration.equals(AppConfigurations.WEBSITE_MAINTENANCE)){
            UserAppConfiguration configuration = findConfiguration(appConfiguration.getAppConfigurationName());
            statusMessage = checkMaintenanceConfiguration(configuration);
        }
        return statusMessage;
    }

    private Map<AppStatus, String> checkMaintenanceConfiguration(UserAppConfiguration appConfiguration){
        Map<AppStatus, String> statusMessage =  new HashMap<>();
        String message;
        //config value = 1 means website is under maintenance
        if(appConfiguration.getConfigValue() == 1){
            message = appConfiguration.getConfigMessage();
            statusMessage.put(AppStatus.WEBSITE_STATUS_MAINTENANCE,message);
            return statusMessage;
        }
        message = "website_status_OK";
        statusMessage.put(AppStatus.WEBSITE_STATUS_OK,message);
        return statusMessage;
    }

    public UserAppConfiguration findConfiguration(String configName){
        return configurationRepository.findByConfigName(configName);
    }

    public UserAppConfiguration save(UserAppConfiguration configuration){
        return configurationRepository.save(configuration);
    }

    public UserAppConfiguration saveWebsiteMaintenanceConfiguration(boolean configValue){
        UserAppConfiguration configuration = saveMaintenanceConfiguration(configValue);
        LOGGER.info("config Value set as = "+configuration.getConfigValue());
        return configuration;
    }

    private UserAppConfiguration saveMaintenanceConfiguration(boolean configValue){
        //config value = 1 means set website under maintenance
        if(configValue) {
            UserAppConfiguration configuration = configurationRepository
                    .findByConfigName(AppConfigurations.WEBSITE_MAINTENANCE.getAppConfigurationName());
            configuration.setConfigValue(1);
            return configurationRepository.save(configuration);
        }
        else{
            UserAppConfiguration configuration = configurationRepository
                    .findByConfigName(AppConfigurations.WEBSITE_MAINTENANCE.getAppConfigurationName());
            configuration.setConfigValue(0);
            return configurationRepository.save(configuration);
        }
    }
}
