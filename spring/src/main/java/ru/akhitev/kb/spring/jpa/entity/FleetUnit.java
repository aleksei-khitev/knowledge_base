package ru.akhitev.kb.spring.jpa.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fleet_unit")
@NamedQueries({
        @NamedQuery(name = FleetUnit.FIND_ALL,
                query = "select fu from FleetUnit fu"),
        @NamedQuery(name = FleetUnit.FIND_BY_ID,
                query = "select fu from FleetUnit fu where fu.id = :id"),
})
public class FleetUnit {
    public static final String FIND_ALL = "FleetUnit.findAll";
    public static final String FIND_BY_ID = "FleetUnit.findById";
    private Long id;
    private String name;
    private CommandRank commandRank;
    private List<FleetUnitShipDetails> shipDetailedList;
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

    @ManyToOne
    @JoinColumn(name = "minimum_command_rank_id")
    public CommandRank getCommandRank() {
        return commandRank;
    }

    public void setCommandRank(CommandRank commandRank) {
        this.commandRank = commandRank;
    }

    @OneToMany(mappedBy = "id.fleetUnit", cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    public List<FleetUnitShipDetails> getShipDetailedList() {
        return shipDetailedList;
    }

    public void setShipDetailedList(List<FleetUnitShipDetails> shipDetailedList) {
        this.shipDetailedList = shipDetailedList;
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
        return name + "{мин. ранг: " + commandRank.getName() +
                ", состав: " + shipDetailedList + "}";
    }
}
