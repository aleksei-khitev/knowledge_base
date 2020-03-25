package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_speed")
public class ShipSpeed {
    @Id
    @Column(name = "ship_id")
    private Long id;

    @Column(name = "space_speed")
    private Integer spaceSpeed;

    @Column(name = "atmosphere_speed")
    private Integer atmosphereSpeed;

    @Column(name = "main_hyper_drive_class")
    private Integer mainHyperDriveClass;

    @Column(name = "backup_hyper_drive_class")
    private Integer backupHyperDriveClass;

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

    public Integer getSpaceSpeed() {
        return spaceSpeed;
    }

    public void setSpaceSpeed(Integer spaceSpeed) {
        this.spaceSpeed = spaceSpeed;
    }

    public Integer getAtmosphereSpeed() {
        return atmosphereSpeed;
    }

    public void setAtmosphereSpeed(Integer atmosphereSpeed) {
        this.atmosphereSpeed = atmosphereSpeed;
    }

    public Integer getMainHyperDriveClass() {
        return mainHyperDriveClass;
    }

    public void setMainHyperDriveClass(Integer mainHyperDriveClass) {
        this.mainHyperDriveClass = mainHyperDriveClass;
    }

    public Integer getBackupHyperDriveClass() {
        return backupHyperDriveClass;
    }

    public void setBackupHyperDriveClass(Integer backupHyperDriveClass) {
        this.backupHyperDriveClass = backupHyperDriveClass;
    }

    @Override
    public String toString() {
        return "Скорость {" +
                ((spaceSpeed != null)?"в космосе: " + spaceSpeed:"") +
                ((atmosphereSpeed != null)?", в атмосфере: " + atmosphereSpeed:"") +
                ((mainHyperDriveClass != null)?", класс основного гиппердрайва: " + mainHyperDriveClass:"") +
                ((backupHyperDriveClass != null)?",  класс резервного гиппердрайва: " + backupHyperDriveClass:"") +
                '}';
    }
}
