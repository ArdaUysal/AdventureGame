package GameCharPackage;
public class GameChar {
	private int damage, healthy, money;
	private String charName;

	public GameChar(String charName ,int damage, int healthy, int money) {
		this.charName = charName;
		this.damage = damage;
		this.healthy = healthy;
		this.money = money;
	}

	
	
	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}


	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getHealthy() {
		return healthy;
	}

	public void setHealthy(int healthy) {
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
