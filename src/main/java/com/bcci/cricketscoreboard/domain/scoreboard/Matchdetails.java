package com.bcci.cricketscoreboard.domain.scoreboard;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Matchdetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "matchid")
    private Matches matchid;

    @ManyToOne
    @JoinColumn(name = "playerid")
    private Players playerid;

    @Column(name="singles")
    private Integer singles;

    @Column(name="fours")
    private Integer fours;

    @Column(name="sixes")
    private Integer sixes;

    public Matchdetails(Integer id) {
        this.id = id;
    }

    public Matchdetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Matches getMatchid() {
        return matchid;
    }

    public void setMatchid(Matches matchid) {
        this.matchid = matchid;
    }

    public Players getPlayerid() {
        return playerid;
    }

    public void setPlayerid(Players playerid) {
        this.playerid = playerid;
    }

    public Integer getSingles() {
        return singles;
    }

    public void setSingles(Integer singles) {
        this.singles = singles;
    }

    public Integer getFours() {
        return fours;
    }

    public void setFours(Integer fours) {
        this.fours = fours;
    }

    public Integer getSixes() {
        return sixes;
    }

    public void setSixes(Integer sixes) {
        this.sixes = sixes;
    }
}
