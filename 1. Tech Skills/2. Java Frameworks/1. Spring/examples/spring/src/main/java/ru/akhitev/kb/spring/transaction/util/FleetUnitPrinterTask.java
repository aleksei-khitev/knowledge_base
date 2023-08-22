package ru.akhitev.kb.spring.transaction.util;

import ru.akhitev.kb.spring.transaction.entity.FleetUnit;
import ru.akhitev.kb.spring.transaction.entity.FleetUnitCompositionByFleetUnits;
import ru.akhitev.kb.spring.transaction.entity.FleetUnitCompositionByShips;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class FleetUnitPrinterTask extends RecursiveTask<String> {
    private static final String INDENT = "  ";
    private FleetUnit fleetUnit;
    private String spaces;
    private Integer count;

    public FleetUnitPrinterTask(FleetUnit fleetUnit, String spaces, Integer count) {
        this.fleetUnit = fleetUnit;
        this.spaces = spaces;
        this.count = count;
    }

    @Override
    protected String compute() {
        StringBuilder result = new StringBuilder();
        result.append(spaces).append(count).append(" x ").append(fleetUnit.getName()).append("\n");
        Set<FleetUnitCompositionByFleetUnits> units = fleetUnit.getCompositionByFleetUnits();
        if (units != null && units.size() > 0) {
            List<FleetUnitPrinterTask> tasks = new ArrayList<>();
            units.forEach(unitComposition ->
                    tasks.add(new FleetUnitPrinterTask(unitComposition.getChildFleetUnit(), spaces + INDENT, unitComposition.getFleetUnitCount())));
            tasks.forEach(FleetUnitPrinterTask::fork);
            result.append(tasks.stream().map(ForkJoinTask::join).collect(Collectors.joining("\n")));
        }
        Set<FleetUnitCompositionByShips> ships = fleetUnit.getCompositionByShips();
        if (ships != null && ships.size() > 0) {
            result.append(ships.stream().map(s -> spaces + INDENT + s.getShipCount() + " x "+ s.getShip()).collect(Collectors.joining("\n")));
        }
        return result.toString();
    }
}
