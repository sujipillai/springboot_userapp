package com.springboot.practice.model;

import javax.persistence.*;

/**
 * Created by sujia on 4/25/2018.
 */
@Entity(name="userapp_config")
public class UserAppConfiguration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="config_id")
    private int configId;

    @Column(name="config_name")
    private String configName;

    @Column(name="config_description")
    private String configDescription;

    @Column(name="config_value")
    private int configValue;

    @Column(name="config_message")
    private String configMessage;

    @Column(name="config_visible_in_website")
    private Boolean configVisibleInWebsite;

    public int getConfigId() {
        return configId;
    }

    public void setConfigId(int configId) {
        this.configId = configId;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getConfigDescription() {
        return configDescription;
    }

    public void setConfigDescription(String configDescription) {
        this.configDescription = configDescription;
    }

    public int getConfigValue() {
        return configValue;
    }

    public void setConfigValue(int configValue) {
        this.configValue = configValue;
    }

    public String getConfigMessage() {
        return configMessage;
    }

    public void setConfigMessage(String configMessage) {
        this.configMessage = configMessage;
    }

    public Boolean getConfigVisibleInWebsite() {
        return configVisibleInWebsite;
    }

    public void setConfigVisibleInWebsite(Boolean configVisibleInWebsite) {
        this.configVisibleInWebsite = configVisibleInWebsite;
    }

    @Override
    public String toString() {
        return "UserAppConfigurationService{" +
                "configId=" + configId +
                ", configName='" + configName + '\'' +
                ", configDescription='" + configDescription + '\'' +
                ", configValue=" + configValue +
                ", configMessage='" + configMessage + '\'' +
                ", configVisibleInWebsite=" + configVisibleInWebsite +
                '}';
    }
}
