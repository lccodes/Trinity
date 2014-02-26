package scaregames;

public class ProfessorDerek extends Monster {
	
	/**
	 * Constructor uses the set values for Undergrad Mike
	 */
	public ProfessorDerek(){
		setUp("Professor Derek", "Administration", "No Credit", 30, 60);
	}
	
	/**
	 * Details how Professor Derek advances his career
	 * @return a Professor Derek
	 */
	@Override
	public Monster advanceCareer(){
		if(getTurns() >= 3){
			System.out.println("Professor Derek advances to Tenured Knight!");
			TenuredKnight mon = new TenuredKnight();
			int cpDif = this.CPMAX - this.cp;
			mon.upCP(-cpDif, 0);
			return mon;
		}
		else{
			System.out.println("Professor Derek cannot advance yet!");
			return this;
		}
	}

}
