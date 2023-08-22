package ru.akhitev.kb.spring.environment_properties_injection_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserInfo {
    private final String homeDir;

    public UserInfo(@Value("${user.home}") String homeDir) {
        this.homeDir = homeDir;
    }

    public String getHomeDir() {
        return homeDir;
    }
}
