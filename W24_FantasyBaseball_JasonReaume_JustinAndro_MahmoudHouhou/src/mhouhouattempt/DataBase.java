package mhouhouattempt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {
    //last name, first initial, Position, Team, AB, SB, AVG, OBP, SLG
    private  String pitchersDatabase;
    private  String battersDatabase;

    ArrayList<Batter> catchers = new ArrayList<>();
    ArrayList<Batter> firstBase = new ArrayList<>();
    ArrayList<Batter> secondBase = new ArrayList<>();
    ArrayList<Batter> thirdBase = new ArrayList<>();
    ArrayList<Batter> shortStop = new ArrayList<>();
    ArrayList<Batter> leftField = new ArrayList<>();
    ArrayList<Batter> centerField = new ArrayList<>();
    ArrayList<Batter> rightField = new ArrayList<>();

    //These hold all the Non-pitcher and the other holds all the pitchers
    ArrayList<Batter> allNonPitchers = new ArrayList<>();
    ArrayList<Pitcher> pitcher = new ArrayList<>();

    ArrayList<Batter> draftedNPs = new ArrayList<>();
    ArrayList<Pitcher> draftedP = new ArrayList<>();

    public DataBase(String pitchersDatabase, String battersDatabase)
    {
        this.pitchersDatabase = pitchersDatabase;
        this.battersDatabase = battersDatabase;
        initializePitcher();
        initializeBatters();
    }

    private void initializePitcher() {
        try (BufferedReader reader = new BufferedReader(new FileReader(getPitchersDatabase())))
        {
            String data;
            String[] line = new String[9];
            int tempC = 0;
            reader.readLine();
            while ((data = reader.readLine()) != null)
            {
                line = data.split(" ");

                line[0] = line[0].substring(0, 1);
                line[1] = line[1] + ",";
                pitcher.add(new Pitcher((line[1] + " " + line[0]), line[2], "P", Double.parseDouble(line[3]),
                        Double.parseDouble(line[4]), Double.parseDouble(line[5]), Double.parseDouble(line[6]),
                        Double.parseDouble(line[7]), Double.parseDouble(line[8])));
            }
        } catch (IOException e)
        {
            System.out.println("Error reading the file");
        }

    }

    private void initializeBatters()  {
        try (BufferedReader reader = new BufferedReader(new FileReader(getBattersDatabase())))
        {
            String data;
            String[] line = new String[11];

            reader.readLine();
            while ((data = reader.readLine()) != null)
            {
                line = data.split(" ");

                //first initial
                line[0] = line[0].substring(0, 1);
                //add comma to last name
                line[1] = line[1] + ",";
                //Player: pitcher:
                Batter(line, allNonPitchers);

                //Player: batter: LastName FirstName Team Position AVG OBP AB SLG SB R H HR
                switch (line[2])
                {
                    case "C":
                        Batter(line, catchers);
                        break;
                    case "1B":
                        Batter(line, firstBase);
                        break;
                    case "2B":
                        Batter(line, secondBase);
                        break;
                    case "3B":
                        Batter(line, thirdBase);
                        break;
                    case "SS": //none pitcher?
                        Batter(line, shortStop);
                        break;
                    case "LF":
                        Batter(line, leftField);
                        break;
                    case "CF":
                        Batter(line, centerField);
                        break;
                    case "RF":
                        Batter(line, rightField);
                        break;
                    default:
                        break;
                }
            }
            reader.close();
        } catch (IOException e)
        {
            System.out.println("Error reading the file");
        }
    }

    private void Batter(String[] line, ArrayList<Batter> catchers)
    {
        catchers.add(new Batter((line[1] + " " + line[0]), line[3], line[2], Double.parseDouble(line[9]),
                Double.parseDouble(line[10]), Double.parseDouble(line[4]), Double.parseDouble(line[11]),
                Double.parseDouble(line[8]), Double.parseDouble(line[5]), Double.parseDouble(line[6]),
                Double.parseDouble(line[7])));
    }



    public void getPlayer(String name, Team team) {
        for(Batter player : allNonPitchers) {
            if(player.getName().equalsIgnoreCase(name)) {
                if(draftedNPs.contains(name)) {//small fix here.
                    System.out.println(player.getName() + " has already been drafted.\n");
                }

                team.addPlayer(player);
                draftedNPs.add(player);
                return;
            }
        }

        for(Pitcher player : pitcher) {
            if(player.getName().equalsIgnoreCase(name)) {
                if(draftedP.contains(name)) {
                    System.out.println(player.getName() + " has already been drafted.\n");
                    return;
                }

                team.addPlayer(player);
                draftedP.add(player);
                System.out.println("Pitcher " +name+" is added.");
                return;
            }
        }
        System.out.println("Could not locate: " + name + " in the MLB database.\n");
        return;
    }

    public void print() {
        for(Batter i : allNonPitchers) {
            System.out.println(i.toString());
        }
    }

    //Getter Methods
    public ArrayList<Batter> getCatchers() {
        return catchers;
    }

    public ArrayList<Batter> getFirstBase() {
        return firstBase;
    }

    public ArrayList<Batter> getSecondBase() {
        return secondBase;
    }

    public ArrayList<Batter> getThirdBase() {
        return thirdBase;
    }

    public ArrayList<Batter> getShortStop() {
        return shortStop;
    }

    public ArrayList<Batter> getLeftField() {
        return leftField;
    }

    public ArrayList<Batter> getCenterField() {
        return centerField;
    }

    public ArrayList<Batter> getRightField() {
        return rightField;
    }

    public ArrayList<Batter> getAllNonPitchers() {
        return allNonPitchers;
    }

    public ArrayList<Pitcher> getPitcher() {
        return pitcher;
    }

    public String getPitchersDatabase()
    {
        return pitchersDatabase;
    }

    public String getBattersDatabase()
    {
        return battersDatabase;
    }

    public void setPitchersDatabase(String pitchersDatabase)
    {
        this.pitchersDatabase = pitchersDatabase;
    }

    public void setBattersDatabase(String battersDatabase)
    {
        this.battersDatabase = battersDatabase;
    }

    public void display(String position) {
        switch(position) {
            case "C":
                for(Batter player : catchers)
                    System.out.println(player.toString());
                break;
            case "1B":
                for(Batter player : firstBase)
                    System.out.println(player.toString());
                break;
            case "2B":
                for(Batter player : secondBase)
                    System.out.println(player.toString());
                break;
            case "3B":
                for(Batter player : thirdBase)
                    System.out.println(player.toString());
                break;
            case "SS":
                for(Batter player : shortStop)
                    System.out.println(player.toString());
                break;
            case "LF":
                for(Batter player : leftField)
                    System.out.println(player.toString());
                break;
            case "CF":
                for(Batter player : centerField)
                    System.out.println(player.toString());
                break;
            case "RF":
                for(Batter player : rightField)
                    System.out.println(player.toString());
                break;
            default:
                System.out.println("Error\n\n");
                break;
        }
    }
}
