package ru.akhitev.kb.spring.java_config_example.servicies;

import java.time.LocalDateTime;

public class PlanetDetails {
    private static final String PLANET_INFO_TEMPLATE = "Население: %s; Заводов: %s\n" +
            "Военных станций: %s; Военных судов: %s;Сухопутных сил: %s;";
    private MilitaryDetailsService militaryDetailsService;
    private CivilDetailsService civilDetailsService;
    private LocalDateTime appLaunchDateTime;

    public void setMilitaryDetailsService(MilitaryDetailsService militaryDetailsService) {
        this.militaryDetailsService = militaryDetailsService;
    }

    public void setCivilDetailsService(CivilDetailsService civilDetailsService) {
        this.civilDetailsService = civilDetailsService;
    }

    public void setAppLaunchDateTime(LocalDateTime appLaunchDateTime) {
        this.appLaunchDateTime = appLaunchDateTime;
    }

    public String planetInfo() {
        return String.format(PLANET_INFO_TEMPLATE,
                civilDetailsService.getPopulation(), civilDetailsService.getFactoryCount(),
                militaryDetailsService.getStationCount(), militaryDetailsService.getShipCount(),
                militaryDetailsService.getTroopsCount());
    }

    public String reportDateTime() {
        return appLaunchDateTime.toString();
    }
}
