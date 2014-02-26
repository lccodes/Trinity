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
		if(getTurns() >= 3){
			System.out.println("Undergrad Randy advances to Rookie Randall!");
			RookieRandall mon = new RookieRandall();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad Randy cannot advance yet!");
			return this;
		}
	}

}
