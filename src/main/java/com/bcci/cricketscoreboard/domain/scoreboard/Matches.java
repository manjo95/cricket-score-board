package com.bcci.cricketscoreboard.domain.scoreboard;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class Matches implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 32, nullable = false)
    private String name;

    @Column(name = "overs")
    private Integer overs;

    @Column(length = 32, nullable = false)
    private String venue;

    @ManyToOne
    @JoinColumn(name = "winner")
    private Teams winner;

    @ManyToOne
    @JoinColumn(name = "looser")
    private Teams looser;

    public Matches(Integer id) {
        this.id = id;
    }

    public Matches(String name) {
        this.name = name;
    }

    public Matches() {
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

    public Integer getOvers() {
        return overs;
    }

    public void setOvers(Integer overs) {
        this.overs = overs;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public Teams getWinner() {
        return winner;
    }

    public void setWinner(Teams winner) {
        this.winner = winner;
    }

    public Teams getLooser() {
        return looser;
    }

    public void setLooser(Teams looser) {
        this.looser = looser;
    }
}
