package scaregames;

public class UndergradMike extends Monster{
	/**
	 * Constructor uses the set values for Undergrad Mike
	 */
	public UndergradMike(){
		setUp("Undergrad Mike", "Oozma Kappa", "Trivia Tackle", 30, 40);
	}
	
	/**
	 * Details how UndergradMike advances his career
	 * @return a SFF Wazowski
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Undergrad Mike advances to SFF Wazowski");
		return (getTurns() >= 3) ? new SFFWazowski() : this;
	}
	

}
