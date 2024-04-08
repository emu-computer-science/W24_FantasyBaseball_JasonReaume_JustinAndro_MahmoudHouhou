package defaultPackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;


public class Team implements Serializable {
    private ArrayList<Player> team = new ArrayList<>();
    private ArrayList<Player> draftedOrder = new ArrayList<>();

    private String name;

    private int catcherCount = 1;
    private int firstBaseCount = 1;
    private int secondBaseCount = 1;
    private int thirdBaseCount = 1;
    private int SSC = 1;
    private int leftFieldCount = 1;
    private int rightFieldCount = 1;
    private int centerFieldCount = 1;
    private int pitcherCount = 5;

    public Team(String name) {
        this.name = name;
    }

    //checks if player is available and drafts if he is
    public boolean addPlayer(Player teammate) {
        switch (teammate.getPosition()) {
            case "C":
                if (catcherCount == 0) {
                    System.out.println("Max Catchers reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                catcherCount--;
                return true;
            case "1B":
                if (firstBaseCount == 0) {
                    System.out.println("Max first basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                firstBaseCount--;
                return true;
            case "2B":
                if (secondBaseCount == 0) {
                    System.out.println("Max second basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                secondBaseCount--;
                return true;
            case "3B":
                if (thirdBaseCount == 0) {
                    System.out.println("Max third basemen reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                thirdBaseCount--;
                return true;
            case "SS":
                if (SSC == 0) {
                    System.out.println("Max Short Stops reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                SSC--;
                return true;
            case "LF":
                if (leftFieldCount == 0) {
                    System.out.println("Max Left Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                leftFieldCount--;
                return true;
            case "CF":
                if (centerFieldCount == 0) {
                    System.out.println("Max Center Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                centerFieldCount--;
                return true;
            case "RF":
                if (rightFieldCount == 0) {
                    System.out.println("Max Right Fielders reached");
                    return false;
                }
                teammate.assignWeight(teammate.getPosition());
                System.out.println("Drafted: " + teammate.toString() + "\n");
                team.add(teammate);
                draftedOrder.add(teammate);
                rightFieldCount--;
                return true;
            case "P":
                if (pitcherCount == 0) {
                    System.out.println("Max Pitchers reached");
                    return false;
                }

                switch (pitcherCount) {
                    case 5:
                        teammate.setPosition("P1");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        draftedOrder.add(teammate);
                        pitcherCount--;
                        return true;
                    case 4:
                        teammate.setPosition("P2");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        draftedOrder.add(teammate);
                        pitcherCount--;
                        return true;
                    case 3:
                        teammate.setPosition("P3");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        draftedOrder.add(teammate);
                        pitcherCount--;
                        return true;
                    case 2:
                        teammate.setPosition("P4");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        draftedOrder.add(teammate);
                        pitcherCount--;
                        return true;
                    case 1:
                        teammate.setPosition("P5");
                        teammate.assignWeight(teammate.getPosition());
                        System.out.println("Drafted: " + teammate.toString() + "\n");
                        team.add(teammate);
                        draftedOrder.add(teammate);
                        pitcherCount--;
                        return true;
                    default:
                        System.out.println("An unknown error has occurred");
                }
            default:
                System.out.println("ERROR");
                return false;
        }
    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getTeam() {
        return team;
    }


    public void team() {
        ArrayList<Player> temp = team;
        Collections.sort(temp);

        for (Player p : temp) {
            System.out.println(p.getPosition() + " " + p.getName());
        }

        System.out.println();
    }

    public void displayPitch(ArrayList<Pitcher> pitchers) {
        if (this.getPitcherCount() == 0) {
            System.out.println("already drafted 5 pitchers");
            return;
        }
        for (Pitcher player : pitchers) {
            System.out.println(player.toString());
        }
    }

    public void displayPos(String position, ArrayList<Batter> allNonPitchers) {
        for (Batter player : allNonPitchers) {
            if (this.isDrafted(position)) {
                System.out.println("you can not draft anymore " + position);
                return;
            }
            if (player.getPosition().equals(position))
                System.out.println(player.toString());
        }
    }

    public void displayPos(ArrayList<Batter> allNonPitchers) {
        for (Batter player : allNonPitchers) {
            if (player.getPosition().equals("C")) {
                if (catcherCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("1B")) {
                if (firstBaseCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("2B")) {
                if (secondBaseCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("3B")) {
                if (thirdBaseCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("SS")) {
                if (SSC == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("LF")) {
                if (leftFieldCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("RF")) {
                if (rightFieldCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            } else if (player.getPosition().equals("CF")) {
                if (centerFieldCount == 0)
                    continue;
                System.out.println(player.toString());
                continue;
            }
        }
    }

    //generated getters with inteleJ just incase they're needed
    public int getCatcherCount() {
        return catcherCount;
    }

    public int getFirstBaseCount() {
        return firstBaseCount;
    }

    public int getSecondBaseCount() {
        return secondBaseCount;
    }

    public int getThirdBaseCount() {
        return thirdBaseCount;
    }

    public int getSSC() {
        return SSC;
    }

    public int getLeftFieldCount() {
        return leftFieldCount;
    }

    public int getRightFieldCount() {
        return rightFieldCount;
    }

    public int getCenterFieldCount() {
        return centerFieldCount;
    }

    public int getPitcherCount() {
        return pitcherCount;
    }

    public void setTeam(ArrayList<Player> team) {
        this.team = team;
    }

    public boolean isDrafted(String position) {
        switch (position) {
            case "C":
                if (catcherCount == 0)
                    return true;
                return false;
            case "1B":
                if (firstBaseCount == 0)
                    return true;
                return false;
            case "2B":
                if (secondBaseCount == 0)
                    return true;
                return false;
            case "3B":
                if (thirdBaseCount == 0)
                    return true;
                return false;
            case "SS":
                if (SSC == 0)
                    return true;
                return false;
            case "LF":
                if (leftFieldCount == 0)
                    return true;
                return false;
            case "RF":
                if (rightFieldCount == 0)
                    return true;
                return false;
            case "CF":
                if (centerFieldCount == 0)
                    return true;
                return false;
            case "P":
                if (pitcherCount == 0)
                    return true;
                return false;
            default:
                return false;
        }
    }
    public void displayStars() {
        System.out.println("Team: " + name + " (STARS)");
        for (int i = 0; i < draftedOrder.size(); i++) {
            Player player = draftedOrder.get(i);
            System.out.println((i + 1) + ". " + player.getName() + " (" + player.getPosition() + ")");
        }
    }
}
