package ru.akhitev.kb.spring.jpa.entity;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FleetUnitShipEmbeddedId implements Serializable {
    private FleetUnit fleetUnit;
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "fleet_unit_id", insertable = false, updatable = false)
    public FleetUnit getFleetUnit() {
        return fleetUnit;
    }

    public void setFleetUnit(FleetUnit fleetUnit) {
        this.fleetUnit = fleetUnit;
    }

    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
