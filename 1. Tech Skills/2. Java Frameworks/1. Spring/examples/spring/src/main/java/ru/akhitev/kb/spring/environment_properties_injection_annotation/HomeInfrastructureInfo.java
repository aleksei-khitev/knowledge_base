package ru.akhitev.kb.spring.environment_properties_injection_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomeInfrastructureInfo {
    private final String transmissionAddress;
    private final String plexAddress;

    public HomeInfrastructureInfo(@Value("${transmission.address}") String transmissionAddress,
                                  @Value("${plex.address}") String plexAddress) {
        this.transmissionAddress = transmissionAddress;
        this.plexAddress = plexAddress;
    }

    @Override
    public String toString() {
        return "Данные домашней инфраструктуры {" +
                "transmissionAddress='" + transmissionAddress + '\'' +
                ", plexAddress='" + plexAddress + '\'' +
                '}';
    }
}
