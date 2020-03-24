package ru.akhitev.kb.spring.transaction.util;

import ru.akhitev.kb.spring.transaction.entity.FleetUnit;
import ru.akhitev.kb.spring.transaction.entity.FleetUnitCompositionByFleetUnits;
import ru.akhitev.kb.spring.transaction.entity.FleetUnitCompositionByShips;
import ru.akhitev.kb.spring.transaction.entity.Ship;

import java.util.*;
import java.util.concurrent.RecursiveTask;

public class ShipsCounterTask extends RecursiveTask<Map<Ship, Integer>> {
    private FleetUnit fleetUnit;
    private Map<Ship, Integer> shipsCount;
    private Integer fleetUnitCount;

    public ShipsCounterTask(FleetUnit fleetUnit, Integer fleetUnitCount) {
        this.fleetUnit = fleetUnit;
        this.fleetUnitCount = fleetUnitCount;
    }

    @Override
    protected Map<Ship, Integer> compute() {
        shipsCount = new HashMap<>();
        Set<FleetUnitCompositionByShips> ships = fleetUnit.getCompositionByShips();
        if (ships != null && ships.size() > 0) {
            for (FleetUnitCompositionByShips composition : ships) {
                shipsCount.put(composition.getShip(), composition.getShipCount());
            }
        }
        Set<FleetUnitCompositionByFleetUnits> units = fleetUnit.getCompositionByFleetUnits();
        if (units != null && units.size() > 0) {
            List<ShipsCounterTask> tasks = new ArrayList<>();
            units.forEach(unitComposition -> tasks.add(new ShipsCounterTask(unitComposition.childFleetUnit, unitComposition.fleetUnitCount)));
            tasks.forEach(ShipsCounterTask::fork);
            for (ShipsCounterTask task : tasks) {
                Map<Ship, Integer> shipsFromSubUnit = task.join();
                for (Map.Entry<Ship, Integer> entry : shipsFromSubUnit.entrySet()) {
                    Integer count = entry.getValue() * fleetUnitCount;
                    if (shipsCount.containsKey(entry.getKey())) {
                        shipsCount.put(entry.getKey(), shipsCount.get(entry.getKey()) + count);
                    } else {
                        shipsCount.put(entry.getKey(), count);
                    }
                }
            }
        }
        return shipsCount;
    }
}
