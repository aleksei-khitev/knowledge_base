package ru.akhitev.kb.spring.hibernate.entity;

import javax.persistence.*;

//@Entity
@Table(name = "fleet_unit")
public class FleetUnit {
    private Long id;
    private String name;
    private CommandRank commandRank;
    private int version;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommandRank getCommandRank() {
        return commandRank;
    }

    public void setCommandRank(CommandRank commandRank) {
        this.commandRank = commandRank;
    }

    @Version
    @Column(name = "version")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return name + "(" + id + ", " + commandRank + ")";
    }
}
