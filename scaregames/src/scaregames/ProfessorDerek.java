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
		if(getTurns() >= 3)
			System.out.println("Professor Derek advances to Tenured Knight");
		return (getTurns() >= 3) ? new TenuredKnight() : this;
	}

}
