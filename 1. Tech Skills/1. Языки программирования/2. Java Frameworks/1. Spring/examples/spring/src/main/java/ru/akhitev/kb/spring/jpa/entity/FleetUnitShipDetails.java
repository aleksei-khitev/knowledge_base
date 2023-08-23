package ru.akhitev.kb.spring.jpa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "fleet_unit_ship")
public class FleetUnitShipDetails {
    private FleetUnitShipEmbeddedId id;
    private Integer count;

    @EmbeddedId
    public FleetUnitShipEmbeddedId getId() {
        return id;
    }

    public void setId(FleetUnitShipEmbeddedId id) {
        this.id = id;
    }

    @Column(name = "ship_count")
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return id.getShip() + " (" + count + "ед.)";
    }
}
