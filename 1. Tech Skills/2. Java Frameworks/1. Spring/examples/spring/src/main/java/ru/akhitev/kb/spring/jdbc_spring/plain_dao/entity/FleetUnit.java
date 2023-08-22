package ru.akhitev.kb.spring.jdbc_spring.plain_dao.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FleetUnit implements Serializable {
    private Long id;
    private String name;
    private List<Ship> ships;

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

    public void addShip(Ship ship) {
        if (ships == null) {
            ships = new ArrayList<>();
        }
        ships.add(ship);
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
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
