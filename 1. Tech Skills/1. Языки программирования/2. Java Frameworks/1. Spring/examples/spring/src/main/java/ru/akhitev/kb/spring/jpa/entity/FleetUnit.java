package ru.akhitev.kb.spring.jpa.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "fleet_unit")
@NamedQueries({
        @NamedQuery(name = FleetUnit.FIND_ALL,
                query = "select fu from FleetUnit fu"),
        @NamedQuery(name = FleetUnit.FIND_BY_ID,
                query = "select fu from FleetUnit fu where fu.id = :id"),
})
@SqlResultSetMapping(name = FleetUnit.FLEET_UNIT_NAME_AND_COMMAND_RANK_NAME,
        entities = @EntityResult(entityClass = FleetUnitAndCommandRank.class))
@EntityListeners(AuditingEntityListener.class)
public class FleetUnit implements Serializable {
    public static final String FIND_ALL = "FleetUnit.findAll";
    public static final String FIND_BY_ID = "FleetUnit.findById";
    public static final String FLEET_UNIT_NAME_AND_COMMAND_RANK_NAME = "fleetUnitAndCommandRank";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "minimum_command_rank_id")
    private CommandRank commandRank;

    @OneToMany(mappedBy = "id.fleetUnit", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<FleetUnitShipDetails> shipDetailedList;

    @Version
    @Column(name = "version")
    private int version;

    @CreatedBy
    @Column(name = "created_by")
    private String createdBy;

    @CreatedDate
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @CreatedDate
    @Column(name = "last_modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

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

    public CommandRank getCommandRank() {
        return commandRank;
    }
    public void setCommandRank(CommandRank commandRank) {
        this.commandRank = commandRank;
    }

    public List<FleetUnitShipDetails> getShipDetailedList() {
        return shipDetailedList;
    }
    public void setShipDetailedList(List<FleetUnitShipDetails> shipDetailedList) {
        this.shipDetailedList = shipDetailedList;
    }

    public String getCreatedBy() {
        return createdBy;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }
    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public String toString() {
        return name + "{" + ((commandRank!=null)? "{мин. ранг: " + commandRank.getName() + ",":"") +
                "состав: " + shipDetailedList + "}";
    }
}
