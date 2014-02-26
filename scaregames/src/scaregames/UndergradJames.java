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
		if(getTurns() >= 3){
			System.out.println("Undergrad James advances to Mailroom Sullivan!");
			MailroomSullivan mon = new MailroomSullivan();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad James cannot advance yet!");
			return this;
		}
	}

}
