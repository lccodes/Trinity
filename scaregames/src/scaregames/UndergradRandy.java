package scaregames;

public class UndergradRandy extends Monster {
	
	/**
	 * Constructor uses the set values for Undergrad Randy
	 */
	public UndergradRandy(){
		setUp("Undergrad Randy", "Roar Omega Roar", "Bite", 20, 60);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a rookie randall
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("UndergradRandy advances to RookieRandall");
		else
			System.out.println("UndergradRandy cannot advance yet!");
		
		return (getTurns() >= 3) ? new RookieRandall() : this;
	}

}
