package ru.akhitev.kb.spring_boot.jpa.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "fleet_unit")
public class FleetUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "fleetUnit",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Ship> ships;

    public FleetUnit() {
    }

    public FleetUnit(Long id, String name, List<Ship> ships) {
        this.id = id;
        this.name = name;
        this.ships = ships;
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

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public void addShip(Ship ship) {
        if (ships == null) {
            ships = new ArrayList<>();
        }
        ships.add(ship);
    }

    @Override
    public String toString() {
        return "FleetUnit{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ships=" + ships +
                '}';
    }
}
