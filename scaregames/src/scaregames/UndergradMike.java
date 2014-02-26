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
		if(getTurns() >= 3){
			System.out.println("Undergrad Mike advances to SFF Wazowski!");
			SFFWazowski mon = new SFFWazowski();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad Mike cannot advance yet!");
			return this;
		}
	}
	

}
