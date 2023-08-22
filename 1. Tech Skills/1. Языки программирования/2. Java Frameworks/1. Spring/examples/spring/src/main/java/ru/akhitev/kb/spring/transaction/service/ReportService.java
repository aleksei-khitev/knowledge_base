package ru.akhitev.kb.spring.transaction.service;

import org.springframework.stereotype.Service;
import ru.akhitev.kb.spring.transaction.entity.*;
import ru.akhitev.kb.spring.transaction.util.FleetUnitPrinterTask;
import ru.akhitev.kb.spring.transaction.util.ShipsCounterTask;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Service
class ReportService {
    String prepare(FleetUnit fleetUnit) {
        StringBuilder reportBuilder = new StringBuilder();
        String composition = compositionOfFleetUnit(fleetUnit);
        if (composition != null) {
            reportBuilder.append("\n-------\nСостав флота\n").append(composition);
        }
        Map<Ship, Integer> shipCounts = shipsWithCounts(fleetUnit);
        if (shipCounts != null && shipCounts.size() > 0) {
            reportBuilder.append("\n-------\nВсего кораблей в единице флота\n")
                    .append(shipCounts.entrySet().stream().map(e -> e.getValue() + " x " + e.getKey()).collect(Collectors.joining("\n")));
            Map<SmallAircraft, Integer> smallAircraftsWithCounts = smallAircraftsWithCounts(shipCounts);
            if (smallAircraftsWithCounts.size() > 0) {
                reportBuilder.append("\n-------\nВсего малых летательных аппаратов в единице флота\n")
                        .append(smallAircraftsWithCounts.entrySet().stream().map(e -> e.getValue() + " x " + e.getKey()).collect(Collectors.joining("\n")));
            }
            Map<LandForce, Integer> landForcesWithCounts = landForcesWithCounts(shipCounts);
            if (landForcesWithCounts.size() > 0) {
                reportBuilder.append("\n-------\nВсего сухопутных сил в единице флота\n")
                        .append(landForcesWithCounts.entrySet().stream().map(e -> e.getValue() + " x " + e.getKey()).collect(Collectors.joining("\n")));
            }
            reportBuilder.append("\n-------\nОбщая стоимость единицы флота (без учета техники и летательных аппаратах)\n").append(cost(shipCounts));

            Long minimalCrew = minimalCrew(shipCounts);
            Long normalCrew = normalCrew(shipCounts);
            Long landingSoldiersAndCrew = landingSoldiersAndCrew(landForcesWithCounts);
            Long smallAircraftCrew = smallAircraftCrew(shipCounts);
            reportBuilder.append("\n-------\nПримерная численность экипажа. У некоторых кораблей нет данных по ней\n")
                    .append("Минимальная: ").append(minimalCrew + smallAircraftCrew).append(" (минмимальный экипаж кораблей и пилоты)\n")
                    .append("Полноценная: ").append(normalCrew + smallAircraftCrew + landingSoldiersAndCrew).append(" (нормальный экипаж кораблей, пилоты, сухопутные силы)\n")
                    .append("минимальная (без учета пилотов, солдат) ").append(minimalCrew)
            .append("\nполноценная (без учета пилотов, солдат) ").append(normalCrew)
            .append("\nсолдаты, штурмовики, персонал наземных сил ").append(landingSoldiersAndCrew)
            .append("\nпилоты летательных аппаратов ").append(smallAircraftCrew);
            reportBuilder.append("\n-------\nИнформация о классах кораблей\n").append(shipCounts.keySet().stream().map(Ship::toMultiLineString).collect(Collectors.joining("\n\n")));
        }
        return reportBuilder.toString();
    }

    private String compositionOfFleetUnit(FleetUnit fleetUnit) {
        return new ForkJoinPool().invoke(new FleetUnitPrinterTask(fleetUnit, "", 1));
    }

    private Map<Ship, Integer> shipsWithCounts(FleetUnit fleetUnit) {
         return new ForkJoinPool().invoke(new ShipsCounterTask(fleetUnit, 1));
    }

    private Map<SmallAircraft, Integer> smallAircraftsWithCounts(Map<Ship, Integer> shipsWithCounts) {
        Map<SmallAircraft, Integer> smallAircraftsWithCounts = new HashMap<>();
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            for (ShipHangar hangar : entry.getKey().getHangar()) {
                SmallAircraft smallAircraft = hangar.getSmallAircraft();
                if (smallAircraftsWithCounts.containsKey(smallAircraft)) {
                    smallAircraftsWithCounts.put(smallAircraft, smallAircraftsWithCounts.get(smallAircraft) + (hangar.getAircraftCount() * entry.getValue()));
                } else {
                    smallAircraftsWithCounts.put(smallAircraft, hangar.getAircraftCount() * entry.getValue());
                }
            }
        }
        return smallAircraftsWithCounts;
    }

    private Map<LandForce, Integer> landForcesWithCounts(Map<Ship, Integer> shipsWithCounts) {
        Map<LandForce, Integer> landForcesWithCounts = new HashMap<>();
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            for (ShipLandingDeck landingDeck : entry.getKey().getLandingDeck()) {
                LandForce landForce = landingDeck.getLandForce();
                if (landForcesWithCounts.containsKey(landForce)) {
                    landForcesWithCounts.put(landForce, landForcesWithCounts.get(landForce) + (landingDeck.getLandForceCount() * entry.getValue()));
                } else {
                    landForcesWithCounts.put(landForce, landingDeck.getLandForceCount() * entry.getValue());
                }
            }
        }
        return landForcesWithCounts;
    }

    private Long cost(Map<Ship, Integer> shipsWithCounts) {
        Long cost = 0L;
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            if (entry.getKey().getCost() != null) {
                cost = cost + (entry.getKey().getCost() * entry.getValue());
            }
        }
        return cost;
    }

    private Long normalCrew(Map<Ship, Integer> shipsWithCounts) {
        Long crew = 0L;
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            if (entry.getKey().getCrew().getNormal() != null) {
                crew = crew + (entry.getKey().getCrew().getNormal() * entry.getValue());
            }
        }
        return crew;
    }

    private Long minimalCrew(Map<Ship, Integer> shipsWithCounts) {
        Long crew = 0L;
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            if (entry.getKey().getCrew().getMinimal() != null) {
                crew = crew + (entry.getKey().getCrew().getMinimal() * entry.getValue());
            }
        }
        return crew;
    }

    private Long landingSoldiersAndCrew(Map<LandForce, Integer> landForcesWithCounts) {
        Long crew = 0L;
        for (Map.Entry<LandForce, Integer> entry : landForcesWithCounts.entrySet()) {
            if (entry.getKey().getCrew() != null) {
                crew = crew + (entry.getKey().getCrew() * entry.getValue());
            }
        }
        return crew;
    }

    private Long smallAircraftCrew(Map<Ship, Integer> shipsWithCounts) {
        Long crew = 0L;
        for (Map.Entry<Ship, Integer> entry : shipsWithCounts.entrySet()) {
            for (ShipHangar hangar : entry.getKey().getHangar()) {
                crew = crew + (hangar.getSmallAircraft().getCrew() * hangar.getAircraftCount() * entry.getValue());
            }
        }
        return crew;
    }

}
