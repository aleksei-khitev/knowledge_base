package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_hanger")
public class ShipHangar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "small_aircraft_id", insertable = false, updatable = false)
    private SmallAircraft smallAircraft;

    @Column(name = "small_aircraft_count")
    private Integer aircraftCount;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public SmallAircraft getSmallAircraft() {
        return smallAircraft;
    }

    public void setSmallAircraft(SmallAircraft smallAircraft) {
        this.smallAircraft = smallAircraft;
    }

    public Integer getAircraftCount() {
        return aircraftCount;
    }

    public void setAircraftCount(Integer aircraftCount) {
        this.aircraftCount = aircraftCount;
    }

    @Override
    public String toString() {
        return smallAircraft + " x " + aircraftCount;
    }
}
