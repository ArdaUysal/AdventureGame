
public class Inventory {
	
	private Weapon weapon;
	private Armor armor;
	private boolean food = false,water = false,wood = false;

	public Inventory() {
		this.weapon = new Weapon("Yumruk",0,0,0);
		this.armor = new Armor("Paçavra",0,0,0);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public void setArmor(Armor armor) {
		this.armor = armor;
	}

	public boolean isFood() {
		return food;
	}

	public void setFood(boolean food) {
		this.food = food;
	}

	public boolean isWater() {
		return water;
	}

	public void setWater(boolean water) {
		this.water = water;
	}

	public boolean isWood() {
		return wood;
	}

	public void setWood(boolean wood) {
		this.wood = wood;
	}
	
	
	
	
	
}