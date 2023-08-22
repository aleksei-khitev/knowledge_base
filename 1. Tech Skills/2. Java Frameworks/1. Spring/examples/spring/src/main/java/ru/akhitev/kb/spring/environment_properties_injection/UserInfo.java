package ru.akhitev.kb.spring.environment_properties_injection;

public class UserInfo {
    private final String homeDir;

    public UserInfo(String homeDir) {
        this.homeDir = homeDir;
    }

    public String getHomeDir() {
        return homeDir;
    }
}
