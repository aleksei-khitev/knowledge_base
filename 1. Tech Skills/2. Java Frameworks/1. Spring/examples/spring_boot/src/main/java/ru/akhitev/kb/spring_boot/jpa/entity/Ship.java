package ru.akhitev.kb.spring_boot.jpa.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String type;

    @Column(name = "ship_class")
    private String shipClass;

    @ManyToOne
    @JoinColumn(name = "fleet_unit_id")
    private FleetUnit fleetUnit;

    public Ship() {
    }

    public Ship(Long id, String name, String type, String shipClass, FleetUnit fleetUnit) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.shipClass = shipClass;
        this.fleetUnit = fleetUnit;
    }

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

    public FleetUnit getFleetUnitId() {
        return fleetUnit;
    }

    public void setFleetUnitId(FleetUnit fleetUnitId) {
        this.fleetUnit = fleetUnit;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", shipClass='" + shipClass + '\'' +
                '}';
    }
}
