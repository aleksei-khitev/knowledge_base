package ru.akhitev.kb.spring.hibernate.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "fleet_unit")
@NamedQueries({
        @NamedQuery(name="FleetUnit.findAllWithShips",
            query = "select distinct fu from FleetUnit fu " +
                    "left join fetch fu.ships s " +
                    "left join fetch fu.commandRank")
})
public class FleetUnit {
    private Long id;
    private String name;
    private CommandRank commandRank;
    private List<Ship> ships;
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

    @ManyToMany
    @JoinTable(name = "fleet_unit_ship",
            joinColumns = @JoinColumn(name = "fleet_unit_id"),
            inverseJoinColumns = @JoinColumn(name = "ship_id"))
    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
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
