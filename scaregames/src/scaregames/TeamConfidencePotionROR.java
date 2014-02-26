package scaregames;

public class TeamConfidencePotionROR extends TrainingCard{
	
	@Override
	public Monster play(Monster m) {
		if (m.house.equals("Roar Omega Roar")) {
			m.upCP(30, 0);
			System.out.println(m.name + " gained team confidence!");
		} else {
			m.upCP(10, 0);
			System.out.println(m.name + " gained confidence!");
		}
		return m;
	}
	
	@Override
	public String toString() {
		return "Team Confidence Potion ROR";
	}
	
	@Override
	public boolean needsMonster(){
		return true;
	}

}
