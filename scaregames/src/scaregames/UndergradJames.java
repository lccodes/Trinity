package scaregames;

public class UndergradJames extends Monster{
	/**
	 * Constructor uses the set values for Undergrad James
	 */
	public UndergradJames(){
		setUp("Undergrad James", "Oozma Kappa", "Party Punch", 20, 60);
	}
	
	/**
	 * Details how UndergradJames advances his career
	 * @return a mailroom sullivan
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Undergrad James advances to Mailroom Sullivan");
		return (getTurns() >= 3) ? new MailroomSullivan() : this;
	}

}
