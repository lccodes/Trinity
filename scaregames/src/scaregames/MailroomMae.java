package scaregames;

public class MailroomMae extends Monster {
	/**
	 * Constructor to set up Mailroom Mae
	 */
	public MailroomMae () {
		setUp("Mailroom Mae", "Python Nu Kappa", "Snake Eyes", 30, 90);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a Scream Ind Willie
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Mailroom Mae advances to Monster Inc. Mae!");
		else
			System.out.println("Mailroom Mae cannot advance yet!");
		
		return (getTurns() >= 3) ? new MonsterIncMae() : this;
	}

}
