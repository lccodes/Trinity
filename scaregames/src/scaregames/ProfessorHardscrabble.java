package scaregames;

public class ProfessorHardscrabble extends Monster {

	/**
	 * Constructor uses the set values for Undergrad Mike
	 */
	public ProfessorHardscrabble(){
		setUp("Professor Hardscrabble", "Administration", "Distainful Stare", 20, 80);
	}
	
	/**
	 * Details how Professor Hardscrabble advances his career
	 * @return a Tenured Hardscrabble
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Professor Hardscrabble advances to Tenured Hardscrabble!");
			TenuredHardscrabble mon = new TenuredHardscrabble();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Professor Hardscrabble cannot advance yet!");
			return this;
		}
	}

}
