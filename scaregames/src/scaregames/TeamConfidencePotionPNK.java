package scaregames;

public class TeamConfidencePotionPNK extends TrainingCard{
	@Override
	public Monster play(Monster m) {
		if (m.house.equals("Python Nu Kappa")) {
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
		return "Team Confidence Potion PNK";
	}
	
	@Override
	public boolean needsMonster(){
		return true;
	}
}
