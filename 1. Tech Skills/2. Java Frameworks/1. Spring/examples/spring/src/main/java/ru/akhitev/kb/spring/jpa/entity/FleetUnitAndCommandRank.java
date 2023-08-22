package ru.akhitev.kb.spring.jpa.entity;

public class FleetUnitAndCommandRank {
    private String fleetUnitName;
    private String commandRankName;

    public FleetUnitAndCommandRank(String fleetUnitName, String commandRankName) {
        this.fleetUnitName = fleetUnitName;
        this.commandRankName = commandRankName;
    }

    @Override
    public String toString() {
        return fleetUnitName + " : " + commandRankName;
    }
}
