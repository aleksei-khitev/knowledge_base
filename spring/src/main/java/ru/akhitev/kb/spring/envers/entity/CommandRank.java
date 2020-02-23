package ru.akhitev.kb.spring.envers.entity;

import javax.persistence.*;

@Entity
@Table(name = "command_rank")
public class CommandRank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Version
    @Column(name = "version")
    private int version;

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

    @Override
    public String toString() {
        return name;
    }
}
