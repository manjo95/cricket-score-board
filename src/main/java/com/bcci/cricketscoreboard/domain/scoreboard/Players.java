package com.bcci.cricketscoreboard.domain.scoreboard;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Players implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 32, nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "Team_id")
    private Teams teams;

    public Players(Integer id) {
        this.id = id;
    }

    public Players(String name) {
        this.name = name;
    }

    public Players() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teams getTeams() {
        return teams;
    }

    public void setTeams(Teams teams) {
        this.teams = teams;
    }
}

