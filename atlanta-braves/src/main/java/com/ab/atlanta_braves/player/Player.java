package com.ab.atlanta_braves.player;

import jakarta.persistence.*;

import java.math.BigDecimal;

//Non-pitcher players

@Entity
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private String position;

    private int gamesPlayed = 0;
    private int plateAppearances = 0;
    private int runs = 0;
    private int hits = 0;
    private int doubles = 0;
    private int triples = 0;
    private int homeruns = 0;
    private int rbi = 0;
    private int sb = 0;
    private int strikeouts = 0;

    @Column(precision = 5, scale = 3)
    private BigDecimal battingAverage = BigDecimal.valueOf(0.000);;
    @Column(precision = 5, scale = 3)
    private BigDecimal obp = BigDecimal.valueOf(0.000);;
    @Column(precision = 5, scale = 3)
    private BigDecimal slg = BigDecimal.valueOf(0.000);;
    @Column(precision = 5, scale = 3)
    private BigDecimal ops = BigDecimal.valueOf(0.000);;

    public Player() {
    }

    public Player(String name,
                  int age,
                  String position,
                  int gamesPlayed,
                  int plateAppearances,
                  int runs,
                  int hits,
                  int doubles,
                  int triples,
                  int homeruns,
                  int rbi,
                  int sb,
                  int strikeouts,
                  BigDecimal battingAverage,
                  BigDecimal obp,
                  BigDecimal slg,
                  BigDecimal ops) {
        this.name = name;
        this.age = age;
        this.position = position;
        
        this.gamesPlayed = gamesPlayed;
        this.plateAppearances = plateAppearances;
        this.runs = runs;
        this.hits = hits;
        this.doubles = doubles;
        this.triples = triples;
        this.homeruns = homeruns;
        this.rbi = rbi;
        this.sb = sb;
        this.strikeouts = strikeouts;
        this.battingAverage = battingAverage;
        this.obp = obp;
        this.slg = slg;
        this.ops = ops;
    }

    public Player(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", plateAppearences=" + plateAppearances +
                ", runs=" + runs +
                ", hits=" + hits +
                ", doubles=" + doubles +
                ", triples=" + triples +
                ", homeruns=" + homeruns +
                ", rbi=" + rbi +
                ", sb=" + sb +
                ", strikeouts=" + strikeouts +
                ", battingAverage=" + battingAverage +
                ", obp=" + obp +
                ", slg=" + slg +
                ", ops=" + ops +
                '}';
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getPlateAppearances() {
        return plateAppearances;
    }

    public void setPlateAppearances(int plateAppearances) {
        this.plateAppearances = plateAppearances;
    }

    public int getRuns() {
        return runs;
    }

    public void setRuns(int runs) {
        this.runs = runs;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public int getTriples() {
        return triples;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public int getHomeruns() {
        return homeruns;
    }

    public void setHomeruns(int homeruns) {
        this.homeruns = homeruns;
    }

    public int getRbi() {
        return rbi;
    }

    public void setRbi(int rbi) {
        this.rbi = rbi;
    }

    public int getSb() {
        return sb;
    }

    public void setSb(int sb) {
        this.sb = sb;
    }

    public int getStrikeouts() {
        return strikeouts;
    }

    public void setStrikeouts(int strikeouts) {
        this.strikeouts = strikeouts;
    }

    public BigDecimal getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(BigDecimal battingAverage) {
        this.battingAverage = battingAverage;
    }

    public BigDecimal getObp() {
        return obp;
    }

    public void setObp(BigDecimal obp) {
        this.obp = obp;
    }

    public BigDecimal getSlg() {
        return slg;
    }

    public void setSlg(BigDecimal slg) {
        this.slg = slg;
    }

    public BigDecimal getOps() {
        return ops;
    }

    public void setOps(BigDecimal ops) {
        this.ops = ops;
    }
}
