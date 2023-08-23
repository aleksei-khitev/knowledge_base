package ru.akhitev.kb.spring.collection_injecion_via_annotation;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

@Component
public class FleetUnit {
    @Resource(name = "scoutLineShips")
    private Map<String, Integer> ships;

    @Resource(name = "scoutLineCapitalShips")
    private Set<String> capitalShips;

    @Resource(name = "scoutLineSuperiorOfficers")
    private Properties superiorOfficers;

    @Resource(name = "scoutLineRout")
    private List<String> route;

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
