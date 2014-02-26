package scaregames;

public class UndergradCarrie extends Monster {
	/**
	 * Constructor for Undergrad Carrie
	 */
	public UndergradCarrie () {
		setUp("Undergrad Carrie", "Python Nu Kappa", "Scaraoke Blast", 20, 80);
	}
	
	/**
	 * Details how UndergradCarrie advances his career
	 * @return a Scream Ind Willie
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Undergrad Carrie advances to Scream Ind. Williams!");
			ScreamIndWilliams mon = new ScreamIndWilliams();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Undergrad Carrie cannot advance yet!");
			return this;
		}
	}

}
