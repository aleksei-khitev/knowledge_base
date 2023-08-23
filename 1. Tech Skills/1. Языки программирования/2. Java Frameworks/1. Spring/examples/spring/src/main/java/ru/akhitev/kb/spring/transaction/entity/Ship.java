package ru.akhitev.kb.spring.transaction.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ship")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String type;

    @Column(name = "ship_class")
    private String shipClass;

    @Column
    private String producer;

    @Column
    private Long cost;

    @Column(name = "autonomy")
    private Integer autonomyInDays;

    @Column
    private String link;

    @Column
    private String comment;

    @OneToOne(mappedBy = "ship", cascade = CascadeType.ALL)
    private ShipSize size;

    @OneToOne(mappedBy = "ship", cascade = CascadeType.ALL)
    private ShipCrew crew;

    @OneToOne(mappedBy = "ship", cascade = CascadeType.ALL)
    private ShipSpeed speed;

    @OneToOne(mappedBy = "ship", cascade = CascadeType.ALL)
    private ShipDefence defence;

    @OneToMany(mappedBy = "ship",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ShipWeapon> weapons;

    @OneToMany(mappedBy = "ship",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ShipHangar> hangar;

    @OneToMany(mappedBy = "ship",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ShipLandingDeck> landingDeck;

    @Version
    @Column(name = "version")
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Integer getAutonomyInDays() {
        return autonomyInDays;
    }

    public void setAutonomyInDays(Integer autonomyInDays) {
        this.autonomyInDays = autonomyInDays;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ShipSize getSize() {
        return size;
    }

    public void setSize(ShipSize size) {
        this.size = size;
    }

    public ShipCrew getCrew() {
        return crew;
    }

    public void setCrew(ShipCrew crew) {
        this.crew = crew;
    }

    public ShipSpeed getSpeed() {
        return speed;
    }

    public void setSpeed(ShipSpeed speed) {
        this.speed = speed;
    }

    public ShipDefence getDefence() {
        return defence;
    }

    public void setDefence(ShipDefence defence) {
        this.defence = defence;
    }

    public Set<ShipWeapon> getWeapons() {
        return weapons;
    }

    public void setWeapons(Set<ShipWeapon> weapons) {
        this.weapons = weapons;
    }

    public Set<ShipHangar> getHangar() {
        return hangar;
    }

    public void setHangar(Set<ShipHangar> hangar) {
        this.hangar = hangar;
    }

    public Set<ShipLandingDeck> getLandingDeck() {
        return landingDeck;
    }

    public void setLandingDeck(Set<ShipLandingDeck> landingDeck) {
        this.landingDeck = landingDeck;
    }

    @Override
    public String toString() {
        return type + " класса " + shipClass;
    }

    public String toMultiLineString() {
        return type + " класса " + shipClass + "\n" +
                "стоимость " + cost + "\n" +
                "автономность (в днях) " + autonomyInDays + "\n" +
                "производитель " + producer + "\n" +
                size + "\n" +
                crew + "\n" +
                speed + "\n" +
                defence + "\n" +
                weapons + "\n" +
                ((hangar.size() > 0)?hangar + "\n":"") +
                ((landingDeck.size() > 0)?landingDeck + "\n":"") +
                link;
    }
}
