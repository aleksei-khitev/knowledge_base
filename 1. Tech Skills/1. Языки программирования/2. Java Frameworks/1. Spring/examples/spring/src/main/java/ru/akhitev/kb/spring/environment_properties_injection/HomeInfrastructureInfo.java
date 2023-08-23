package ru.akhitev.kb.spring.environment_properties_injection;

public class HomeInfrastructureInfo {
    private final String transmissionAddress;
    private final String plexAddress;

    public HomeInfrastructureInfo(String transmissionAddress, String plexAddress) {
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
