package scaregames;

public class RookieRandall extends Monster {
	
	/**
	 * Constructor
	 * Uses set values for Rookie Randall
	 */
	public RookieRandall(){
		setUp("Rookie Randall", "Roar Omegar Roar", "Strangle", 30, 60);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a rookie randall
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Rookie Randall advances to SFF Boggs");
		return (getTurns() >= 3) ? new SFFBoggs() : this;
	}
}
