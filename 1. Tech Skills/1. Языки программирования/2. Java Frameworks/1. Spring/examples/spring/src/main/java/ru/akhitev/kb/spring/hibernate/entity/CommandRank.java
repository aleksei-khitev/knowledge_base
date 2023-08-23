package ru.akhitev.kb.spring.hibernate.entity;

import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "command_rank")
public class CommandRank {
    private Long id;
    private String name;
    private List<FleetUnit> fleetUnitsToCommand = new ArrayList<>();
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

    @OneToMany(mappedBy = "commandRank",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    public List<FleetUnit> getFleetUnitsToCommand() {
        return fleetUnitsToCommand;
    }

    public void setFleetUnitsToCommand(List<FleetUnit> fleetUnitsToCommand) {
        this.fleetUnitsToCommand = fleetUnitsToCommand;
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
        return name + '(' + id + ", может командовать: " + fleetUnitsToCommand + ')';
    }
}
