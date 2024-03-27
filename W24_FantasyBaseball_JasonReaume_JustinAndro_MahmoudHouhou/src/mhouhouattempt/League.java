package mhouhouattempt;

import java.util.ArrayList;

public class League {
    private ArrayList<Team> teams = new ArrayList<>();
    public League() {}

    public void addTeam(String name) {
        teams.add(new Team(name));
    }

    //Finds provided team
    public Team getTeam(String teamName) {
        for(Team t : teams) {
            if(t.getName().equalsIgnoreCase(teamName)) {
                return t;
            }
        }

        return null;
    }
    //Gets team based on index
    public Team getTeam(int index) {
        return teams.get(index);
    }

    //Getter Method for team
    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams)
    {
        this.teams = teams;
    }
}
