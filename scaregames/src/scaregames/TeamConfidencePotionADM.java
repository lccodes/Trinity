package scaregames;

public class TeamConfidencePotionADM extends TrainingCard{
	@Override
	public Monster play(Monster m) {
		if (m.house.equals("Administration")) {
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
		return "Team Confidence Potion ADM";
	}
	
	@Override
	public boolean needsMonster(){
		return true;
	}

}
