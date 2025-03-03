package com.ab.atlanta_braves.player;

import jakarta.persistence.*;

@Entity
@Table
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String position;

    private int gamesPlayed;
    private int plateAppearences;
    private int runs;
    private int hits;
    private int doubles;
    private int triples;
    private int homeruns;
    private int rbi;
    private int sb;
    private int strikeouts;
    private double battingAverage;
    private double obp;
    private double slg;
    private double ops;

    public Player() {
    }

    public Player(String name,
                  int age,
                  String position,
                  int gamesPlayed,
                  int plateAppearences,
                  int runs,
                  int hits,
                  int doubles,
                  int triples,
                  int homeruns,
                  int rbi,
                  int sb,
                  int strikeouts,
                  double battingAverage,
                  double obp,
                  double slg,
                  double ops) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.gamesPlayed = gamesPlayed;
        this.plateAppearences = plateAppearences;
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", position='" + position + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", plateAppearences=" + plateAppearences +
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

    public int getPlateAppearences() {
        return plateAppearences;
    }

    public void setPlateAppearences(int plateAppearences) {
        this.plateAppearences = plateAppearences;
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

    public double getBattingAverage() {
        return battingAverage;
    }

    public void setBattingAverage(double battingAverage) {
        this.battingAverage = battingAverage;
    }

    public double getObp() {
        return obp;
    }

    public void setObp(double obp) {
        this.obp = obp;
    }

    public double getSlg() {
        return slg;
    }

    public void setSlg(double slg) {
        this.slg = slg;
    }

    public double getOps() {
        return ops;
    }

    public void setOps(double ops) {
        this.ops = ops;
    }
}
