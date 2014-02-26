package scaregames;

public class UndergradCelia extends Monster {
	/**
	 * Constructor that sets up Undergrad Celia
	 */
	public UndergradCelia () {
		setUp("Undergrad Celia", "Python Nu Kappa", "Charm", 20, 60);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a Scream Ind Willie
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Undergrad Celia advances to Mailroom Mae!");
			MailroomMae mon = new MailroomMae();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad Celia cannot advance yet!");
			return this;
		}
	}
}
