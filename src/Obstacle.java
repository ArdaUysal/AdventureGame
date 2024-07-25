import java.util.Random;

public class Obstacle {
	
	private int id;
	private String name;
	private int damage,healthy,money,defHealthy;
	
	
	public Obstacle(int id, String name, int damage, int healthy, int money) {
		this.id = id;
		this.name = name;
		this.damage = damage;
		this.healthy = healthy;
		this.money = money;
		this.defHealthy = healthy;
	}
	
	public Obstacle() {
		
	}
	
	public int obstacleNumber() {
		Random r = new Random();
		int obsNumber = r.nextInt(3) + 1;
		return obsNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		if(healthy < 0) {
			this.healthy = 0;
		}
		this.healthy = healthy;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getDefHealthy() {
		return defHealthy;
	}

	public void setDefHealthy(int defHealthy) {
		this.defHealthy = defHealthy;
	}
	
	
	
	
	
}
