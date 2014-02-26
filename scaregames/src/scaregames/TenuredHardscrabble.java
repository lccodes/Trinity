package scaregames;

public class TenuredHardscrabble extends Monster {
	
	/**
	 * Constructor uses the set values for Undergrad Mike
	 */
	public TenuredHardscrabble(){
		setUp("Tenured Hardscrabble", "Administration", "Flight of Fury", 40, 120);
	}
	
	/**
	 * Details how Tenured Hardscrabble advances his career
	 * @return a Dean Hardscrabble
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Tenured Hardscrabble advances to Dean Hardscrabble!");
			DeanHardscrabble mon = new DeanHardscrabble();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Tenured Hardscrabble cannot advance yet!");
			return this;
		}
	}

}
