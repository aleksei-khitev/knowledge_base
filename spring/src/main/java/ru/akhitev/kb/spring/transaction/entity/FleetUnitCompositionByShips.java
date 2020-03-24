package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "fleet_unit_composition_by_ships")
public class FleetUnitCompositionByShips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "fleet_unit_id", insertable = false, updatable = false)
    public FleetUnit fleetUnit;

    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    public Ship ship;

    @Column(name = "ship_count")
    public Integer shipCount;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FleetUnit getFleetUnit() {
        return fleetUnit;
    }

    public void setFleetUnit(FleetUnit fleetUnit) {
        this.fleetUnit = fleetUnit;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Integer getShipCount() {
        return shipCount;
    }

    public void setShipCount(Integer shipCount) {
        this.shipCount = shipCount;
    }

    @Override
    public String toString() {
        return shipCount + " единиц класса " + ship;
    }
}
