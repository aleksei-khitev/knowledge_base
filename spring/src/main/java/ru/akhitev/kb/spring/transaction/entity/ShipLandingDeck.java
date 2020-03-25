package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_landing_deck")
public class ShipLandingDeck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    private Ship ship;

    @ManyToOne
    @JoinColumn(name = "land_force_id", insertable = false, updatable = false)
    private LandForce landForce;

    @Column(name = "landing_deck_count")
    private Integer landForceCount;

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

    public LandForce getLandForce() {
        return landForce;
    }

    public void setLandForce(LandForce landForce) {
        this.landForce = landForce;
    }

    public Integer getLandForceCount() {
        return landForceCount;
    }

    public void setLandForceCount(Integer landForceCount) {
        this.landForceCount = landForceCount;
    }

    @Override
    public String toString() {
        return landForce + " x " + landForceCount;
    }
}
