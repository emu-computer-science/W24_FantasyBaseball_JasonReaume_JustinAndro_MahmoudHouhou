
public class FantasyDraft {

	public static void main(String[] args) {
		Database stubDatabase = new Database();
		Team stubTeam = new Team();
		Player stubPlayer = new Player();
		UserInteraction stubUser = new UserInteraction();

		stubDatabase.initializedpitcher();
		stubDatabase.serialize();
		stubDatabase.initializedbatter();
		stubDatabase.getPlayer("a");
		stubDatabase.display("a");

		stubTeam.add();
		stubTeam.remove();
		stubTeam.display();
		stubTeam.sortPositions();
		
		stubPlayer.setStatus("a");
		stubPlayer.getStatus();
		stubPlayer.getPosition();
		stubPlayer.getName();
		stubPlayer.assignRole("a");

		stubUser.ODRAFT("a", "a");
		stubUser.IDRAFT("a");
		stubUser.OVERALL("a");
		stubUser.POVERALL();
		stubUser.TEAM("a");
		stubUser.STARS("a");
		stubUser.SAVE("a");
		stubUser.RESTORE("a");
		stubUser.EVALFUN("a");
		stubUser.PEVALFUN("a");
		stubUser.HELP();
		stubUser.QUIT();
		stubUser.wasSuccessful("a");
	}
}
