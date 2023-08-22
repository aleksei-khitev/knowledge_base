package ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity;

import java.io.Serializable;

public class Ship implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String shipClass;
    private Long fleetUnitId;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShipClass() {
        return shipClass;
    }

    public void setShipClass(String shipClass) {
        this.shipClass = shipClass;
    }

    public Long getFleetUnitId() {
        return fleetUnitId;
    }

    public void setFleetUnitId(Long fleetUnitId) {
        this.fleetUnitId = fleetUnitId;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", shipClass='" + shipClass + '\'' +
                ", fleetUnitId=" + fleetUnitId +
                '}';
    }
}
