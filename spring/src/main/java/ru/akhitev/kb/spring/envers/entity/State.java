package ru.akhitev.kb.spring.envers.entity;

import javax.persistence.*;

@Entity
@Table(name = "space_state")
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public String toString() {
        return name;
    }
}
