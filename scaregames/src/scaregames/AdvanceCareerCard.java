package scaregames;

public class AdvanceCareerCard extends TrainingCard {
	
	public AdvanceCareerCard(){
		
	}
	
	/**
	 * toString()
	 */
	@Override
	public String toString(){
		return "Career Advance";
	}
	
	/**
	 * Play
	 */
	@Override
	public Monster play(Monster m){
		return m.advanceCareer();
	}
	
	/**
	 * Needs monster
	 */
	@Override
	public boolean needsMonster(){
		return true;
	}

}
