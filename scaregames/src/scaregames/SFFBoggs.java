package scaregames;

public class SFFBoggs extends Monster{
	
	public SFFBoggs () {
		setUp("SFF Boggs", "Roar Omegar Roar", "Camoflauge", 60, 120);
	}
	
	/**
	 * SFFBoggs' invisibility speciality
	 */
	@Override
	public void useSpecial(){
		
	}
	
	/**
	 * Decreases the monster's value in response to an attack
	 * @param int value; how wounded we were
	 */
	@Override
	public void getAttacked(int value){
		if(getTurns() > 2){
			System.out.println(name + " has lost " + value + " confidence points!");
			cp = (cp-value < 0) ? 0 : cp-value;
			if(isExiled()){
				System.out.println(name + " has been exiled to the human world!");
			}
		}else{
			System.out.println("SFFBoggs uses invisibility to hide from this attack!");
		}
	}
	
	/**
	 * hasSpecial is true because he does
	 */
	@Override
	public boolean hasSpecial(){
		return true;
	}

}
