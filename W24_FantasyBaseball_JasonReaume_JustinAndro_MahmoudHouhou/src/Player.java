
public class Player {
	private String status;
	private String position;
	private String name;

	public Player() {
		status = null;
		position = null;
		name = null;
	}

	public String setStatus(String status) {
		System.out.println("UserInteraction.setStatus is not yet implemented");
		if (status == "draftable") {
			return status;
		} else {
			return status;
		}
	}

	public void assignRole(String role) {
		System.out.println("UserInteraction.assignRole is not yet implemented");
	}

	public String getStatus() {
		System.out.println("UserInteraction.getStatus is not yet implemented");
		return status;
	}

	public String getPosition() {
		System.out.println("UserInteraction.getPosition is not yet implemented");
		return position;
	}

	public String getName() {
		System.out.println("UserInteraction.getName is not yet implemented");
		return name;
	}

}
