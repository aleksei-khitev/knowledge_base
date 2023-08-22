package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_defence")
public class ShipDefence {
    @Id
    @Column(name = "ship_id")
    private Long id;

    @Column
    private Integer shields;

    @Column
    private Integer hp;

    @Column
    private Integer dr;

    @Column(name = "damage_threshold")
    private Integer damageThreshold;

    @OneToOne
    @MapsId
    private Ship ship;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getShields() {
        return shields;
    }

    public void setShields(Integer shields) {
        this.shields = shields;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Integer getDamageThreshold() {
        return damageThreshold;
    }

    public void setDamageThreshold(Integer damageThreshold) {
        this.damageThreshold = damageThreshold;
    }

    @Override
    public String toString() {
        return "Защита {" +
                ((shields != null)?"щиты: " + shields:"") +
                ((dr != null)?", DR: " + dr:"") +
                ((hp != null)?", HP: " + hp:"") +
                ((damageThreshold != null)?",  Damage Threshold: " + damageThreshold:"") +
                '}';
    }
}
