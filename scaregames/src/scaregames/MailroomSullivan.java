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
		if(getTurns() >= 3){
			System.out.println("Mailroom Sullivan advances to SFF Sully!");
			SFFSulley mon = new SFFSulley();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Mailroom Sullivan cannot advance yet!");
			return this;
		}
	}

}
