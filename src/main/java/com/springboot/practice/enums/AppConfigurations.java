package com.springboot.practice.enums;

/**
 * Created by sujia on 4/25/2018.
 */
public enum AppConfigurations {
    WEBSITE_MAINTENANCE("website_maintenance_status");

    public String getAppConfigurationName() {
        return appConfigurationName;
    }

    private String appConfigurationName;

    AppConfigurations(String str) {
        this.appConfigurationName = str;
    }

}
