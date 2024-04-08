package defaultPackage;

import java.io.Serializable;


public class Batter extends Player implements Serializable{
    private String name;
    private String team;
    private String position;
    private double avg, obp, ab, slg, sb, r, h, hr;

    public Batter(String name, String team, String position, double avg, double obp
            , double ab, double slg, double sb, double r, double h, double hr) {
        super(name,team,position);
        this.name = name;
        this.team = team;
        this.position = position;
        this.avg = avg;
        this.obp = obp;
        this.ab = ab;
        this.slg = slg;
        this.sb = sb;
        this.r = r;
        this.h = h;
        this.hr = hr;
    }

    @Override
    public String toString() {
        return name + " " + team + " " + position + " " + avg;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public double getObp() {
        return obp;
    }

    public void setObp(double obp) {
        this.obp = obp;
    }

    public double getAb() {
        return ab;
    }

    public void setAb(double ab) {
        this.ab = ab;
    }

    public double getSlg() {
        return slg;
    }

    public void setSlg(double slg) {
        this.slg = slg;
    }

    public double getSb() {
        return sb;
    }

    public void setSb(double sb) {
        this.sb = sb;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getHr() {
        return hr;
    }

    public void setHr(double hr) {
        this.hr = hr;
    }

    @Override
    public void setPosition(String position) {
        this.position = position;
    }

    public double getAvg() {
        return avg;
    }
}