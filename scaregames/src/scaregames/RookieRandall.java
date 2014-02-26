package scaregames;

public class RookieRandall extends Monster {
	
	/**
	 * Constructor
	 * Uses set values for Rookie Randall
	 */
	public RookieRandall(){
		setUp("Rookie Randall", "Roar Omega Roar", "Strangle", 30, 100);
	}
	
	/**
	 * Details how UndergradRandy advances his career
	 * @return a rookie randall
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Rookie Randall advances to SFF Boggs!");
			SFFBoggs mon = new SFFBoggs();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Rookie Randall cannot advance yet!");
			return this;
		}
	}
}
