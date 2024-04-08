package defaultPackage;

import java.io.*;
import java.util.ArrayList;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;



public class Main {
    private static String[] arguments = new String[5];
    private static League majorleague = new League();

    public static void main(String[] args) throws Exception {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        majorleague.addTeam("A");
        majorleague.addTeam("B");
        majorleague.addTeam("C");
        majorleague.addTeam("D");


        DataBase db = new DataBase("Pitchers.txt", "Batters.txt");
        help();

        while(true) {
            System.out.print("->");
            String input = reader.readLine();
            arguments = input.split(" ");

            if(arguments[0].equalsIgnoreCase("ODRAFT") && arguments.length - 1 != 2) {
                arguments[1] = arguments[1].substring(1);
                arguments[2] = arguments[2].substring(0,arguments[2].length() - 1);
                db.getPlayer((arguments[1] + " " + arguments[2]), majorleague.getTeam(arguments[3]));
            } else if(arguments[0].equalsIgnoreCase("IDRAFT")) {
                arguments[1] = arguments[1].substring(1);
                arguments[2] = arguments[2].substring(0,arguments[2].length() - 1);
                db.getPlayer((arguments[1] + " " + arguments[2]), majorleague.getTeam(0));
            } else if(arguments[0].equalsIgnoreCase("OVERALL") && arguments.length - 1 < 1) {
                majorleague.getTeam(0).displayPos(db.getAllNonPitchers());
            } else if(arguments[0].equalsIgnoreCase("OVERALL")) {
                majorleague.getTeam(0).displayPos(arguments[1],db.getAllNonPitchers());
            } else if(arguments[0].equalsIgnoreCase("POVERALL")) {
                majorleague.getTeam(0).displayPitch(db.getPitcher());
            } else if(arguments[0].equalsIgnoreCase("TEAM") && arguments.length - 1 == 1 && arguments.length - 1 != 0){
                majorleague.getTeam(arguments[1]).team(); //Prints out team in order of position
            } else if (arguments[0].equalsIgnoreCase("Quit")) { //Exits the Program
                System.out.println("Draft system is now completed.");
                break;
            } else if(arguments[0].equalsIgnoreCase("help")){
                help();
            } else if(arguments[0].equalsIgnoreCase("STARS") && arguments.length - 1 == 1){
                majorleague.getTeam(arguments[1]).displayStars();
            } else if(arguments[0].equalsIgnoreCase("EVALFUN")){
                System.out.println("This is a WIP");;
            } else if(arguments[0].equalsIgnoreCase("PEVALFUN")){
                System.out.println("This is a WIP");;
            } else if(arguments[0].equalsIgnoreCase("save")){
                System.out.print("Enter a file name: ");
                input = reader.readLine();;
                onSerializeTeams(input, majorleague.getTeams());
            } else if(arguments[0].equalsIgnoreCase("restore")){
                System.out.print("Enter the name of existing file: ");
                input = reader.readLine();;
                onDeserializeTeams(input);
            }else {
                System.out.println("Invalid command\n");
            }
        }
    }

    //used to print out the commands, last few don't work pvalfun evalfun and stars
    static void help(){
        System.out.println("Please enter one of the following commands:\n\tODRAFT [playername] [league member]\n\t" +
                "IDRAFT [playername]\n\tOVERALL [position]\n\tPOVERALL\n\tTEAM [team name]\n\tSAVE\n\tRESTORE\n\tHelp\n\tQuit\n\t" +
                "pevalfun\n\tevalfun\n\tstars");
    }


    //https://www.geeksforgeeks.org/how-to-serialize-arraylist-in-java/
    //used this for next few methods on serialization
    private static void onSerializeTeams(String filename, ArrayList<Team> listTeams)
    {
        try
        {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(listTeams);
            oos.close();
            fos.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    private static void onDeserializeTeams(String filename)
    {
        try
        {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);

            majorleague.setTeams((ArrayList) ois.readObject());

            ois.close();
            fis.close();
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
            return;
        }
        catch (ClassNotFoundException c)
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }


}
