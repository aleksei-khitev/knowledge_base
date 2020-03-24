package ru.akhitev.kb.spring.transaction.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import ru.akhitev.kb.spring.transaction.util.FleetUnitPrinterTask;
import ru.akhitev.kb.spring.transaction.util.ShipsCounterTask;

import javax.persistence.*;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

@Entity
@Table(name = "fleet_unit")
public class FleetUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "minimum_command_rank_id")
    private CommandRank minimumCommandRank;

    @OneToMany(mappedBy = "fleetUnit",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<FleetUnitCompositionByShips> compositionByShips;

    @OneToMany(mappedBy = "parentFleetUnit",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<FleetUnitCompositionByFleetUnits> compositionByFleetUnits;

    @OneToMany(mappedBy = "childFleetUnit",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<FleetUnitCompositionByFleetUnits> childForFleetUnits;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommandRank getMinimumCommandRank() {
        return minimumCommandRank;
    }

    public void setMinimumCommandRank(CommandRank minimumCommandRank) {
        this.minimumCommandRank = minimumCommandRank;
    }

    public Set<FleetUnitCompositionByShips> getCompositionByShips() {
        return compositionByShips;
    }

    public void setCompositionByShips(Set<FleetUnitCompositionByShips> compositionByShips) {
        this.compositionByShips = compositionByShips;
    }

    public Set<FleetUnitCompositionByFleetUnits> getCompositionByFleetUnits() {
        return compositionByFleetUnits;
    }

    public void setCompositionByFleetUnits(Set<FleetUnitCompositionByFleetUnits> compositionByFleetUnits) {
        this.compositionByFleetUnits = compositionByFleetUnits;
    }

    @Override
    public String toString() {
        return name + " {"
                + ((compositionByFleetUnits !=null && compositionByFleetUnits.size() > 0)?"ед. флота: " + compositionByFleetUnits:"" )
                + ((compositionByShips !=null && compositionByShips.size() > 0)?"корабли: " + compositionByShips:"" )
                + "}";
    }

    public String toMultiLineString() {
        StringBuilder result = new StringBuilder();
        /*result.append("Состав единицы: ").append(name).append("\n========");
        if (compositionByFleetUnits !=null && compositionByFleetUnits.size() > 0) {
            result.append("\nЕДИНИЦЫ ФЛОТА:\n");
            result.append(compositionByFleetUnits.stream().map(FleetUnitCompositionByFleetUnits::toString).collect(Collectors.joining("\n")));
        }
        if (compositionByShips !=null && compositionByShips.size() > 0) {
            result.append("\nКОРАБЛИ:\n");
            result.append(compositionByShips.stream().map(FleetUnitCompositionByShips::toString).collect(Collectors.joining("\n")));
        }*/
        String units = new ForkJoinPool().invoke(new FleetUnitPrinterTask(this, "", 1));
        if (units != null) {
            result.append("\n-------\nСостав флота\n").append(units);
        }
        Map<Ship, Integer> shipCounts = new ForkJoinPool().invoke(new ShipsCounterTask(this, 1));
        if (shipCounts != null && shipCounts.size() > 0) {
            result.append("\n-------\nВсего кораблей в единице флота\n")
                    .append(shipCounts.entrySet().stream().map(e -> e.getValue() + " x " + e.getKey()).collect(Collectors.joining("\n")));
        }

        return result.toString();
    }
}
