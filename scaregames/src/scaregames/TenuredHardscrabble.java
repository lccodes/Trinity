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
		if(getTurns() >= 3)
			System.out.println("Tenured Hardscrabble advances to Dean Hardscrabble");
		return (getTurns() >= 3) ? new DeanHardscrabble() : this;
	}

}
