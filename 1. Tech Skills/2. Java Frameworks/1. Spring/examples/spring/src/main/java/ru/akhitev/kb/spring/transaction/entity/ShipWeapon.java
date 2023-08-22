package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_weapon")
public class ShipWeapon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ship_id", insertable = false, updatable = false)
    public Ship ship;

    @ManyToOne
    @JoinColumn(name = "weapon_id", insertable = false, updatable = false)
    private Weapon weapon;

    @Column(name = "weapon_count")
    private Integer weaponCount;

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

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Integer getWeaponCount() {
        return weaponCount;
    }

    public void setWeaponCount(Integer weaponCount) {
        this.weaponCount = weaponCount;
    }

    @Override
    public String toString() {
        return weapon + " x " + weaponCount;
    }
}
