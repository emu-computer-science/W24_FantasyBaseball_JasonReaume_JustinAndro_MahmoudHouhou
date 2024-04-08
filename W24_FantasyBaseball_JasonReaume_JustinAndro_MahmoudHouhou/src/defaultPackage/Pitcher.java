package defaultPackage;


import java.io.Serializable;

public class Pitcher extends Player implements Serializable
{
    private String name;
    private String team;
    private String position;
    private double era, g, gs, ip, bb, so;

    public Pitcher(String name, String team, String position, double era, double g,
                   double gs, double ip, double bb, double so) {
        super(name,team,position);
        this.name = name;
        this.team = team;
        this.position = position;
        this.era = era;
        this.g = g;
        this.gs = gs;
        this.ip = ip;
        this.bb = bb;
        this.so = so;
    }

    @Override
    public String toString() {
        return this.name + " " + this.team + " " + this.position + " " + this.ip;
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

    public void setPosition(String position) {
        this.position = position;
    }

    public double getIp() {
        return ip;
    }
}
