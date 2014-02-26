package scaregames;

public class MailroomSullivan extends Monster{
	
	/**
	 * Constructor uses the set values for Undergrad Randy
	 */
	public MailroomSullivan(){
		setUp("Mailroom Sullivan", "Oozma Kappa", "Monster Stamp", 30, 100);
	}
	
	/**
	 * Details how Mailroom Sullivan advances his career
	 * @return a SFF Sulley
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3)
			System.out.println("Mailroom Sullivan advances to SFF Sulley");
		return (getTurns() >= 3) ? new SFFSulley() : this;
	}

}
