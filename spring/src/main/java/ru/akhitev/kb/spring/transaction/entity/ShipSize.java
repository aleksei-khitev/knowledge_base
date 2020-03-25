package ru.akhitev.kb.spring.transaction.entity;

import javax.persistence.*;

@Entity
@Table(name = "ship_size")
public class ShipSize {
    @Id
    @Column(name = "ship_id")
    private Long id;

    @Column(name = "ship_length")
    private Integer length;

    @Column(name = "ship_width")
    private Integer width;

    @Column(name = "ship_height")
    private Integer height;

    @Version
    @Column(name = "version")
    private int version;

    @OneToOne
    @MapsId
    private Ship ship;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Размеры {" +
                ((length != null)?"длина: " + length:"") +
                ((width != null)?", ширина: " + width:"") +
                ((height != null)?", высота: " + height:"") +
                '}';
    }
}
