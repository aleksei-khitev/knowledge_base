package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "fleet_unit_composition_by_fleet_units")
public class FleetUnitCompositionByFleetUnits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "parent_fleet_unit_id", insertable = false, updatable = false)
    private FleetUnit parentFleetUnit;

    @ManyToOne
    @JoinColumn(name = "child_fleet_unit_id", insertable = false, updatable = false)
    private FleetUnit childFleetUnit;

    @Column(name = "fleet_unit_count")
    private Integer fleetUnitCount;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FleetUnit getParentFleetUnit() {
        return parentFleetUnit;
    }

    public void setParentFleetUnit(FleetUnit parentFleetUnit) {
        this.parentFleetUnit = parentFleetUnit;
    }

    public FleetUnit getChildFleetUnit() {
        return childFleetUnit;
    }

    public void setChildFleetUnit(FleetUnit childFleetUnit) {
        this.childFleetUnit = childFleetUnit;
    }

    public Integer getFleetUnitCount() {
        return fleetUnitCount;
    }

    public void setFleetUnitCount(Integer fleetUnitCount) {
        this.fleetUnitCount = fleetUnitCount;
    }

    @Override
    public String toString() {
        return  fleetUnitCount + " x " + childFleetUnit;
    }
}
