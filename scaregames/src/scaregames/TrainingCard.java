package scaregames;

public class TrainingCard implements Card {
	
	public TrainingCard(){
	}

	@Override
	public boolean isMonster() {
		return false;
	}
	
	/**
	 * All training cards get played
	 */
	public Monster play(){
		return null;
	}
	
	/**
	 * Checks if it needs a monster
	 */
	public boolean needsMonster(){
		return false;
	}

	public Monster play(Monster monster) {
		// TODO Auto-generated method stub
		return null;
	}

}
