package ru.akhitev.kb.spring.collection_injecion;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class FleetUnit {
    private Map<String, Integer> ships;
    private Set<String> capitalShips;
    private Properties superiorOfficers;
    private List<String> route;

    public void setShips(Map<String, Integer> ships) {
        this.ships = ships;
    }

    public void setCapitalShips(Set<String> capitalShips) {
        this.capitalShips = capitalShips;
    }

    public void setSuperiorOfficers(Properties superiorOfficers) {
        this.superiorOfficers = superiorOfficers;
    }

    public void setRoute(List<String> route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "FleetUnit{" +
                "ships=" + ships +
                ", capitalShips=" + capitalShips +
                ", superiorOfficers=" + superiorOfficers +
                ", route=" + route +
                '}';
    }
}
