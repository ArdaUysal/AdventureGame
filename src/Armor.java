
public class Armor {
	
	private String name;
	private int id,defence,money;
	
	public Armor(String name, int id, int defence, int money) {
		this.name = name;
		this.id = id;
		this.defence = defence;
		this.money = money;
	}
	
	public static Armor[] armors() {
		Armor[] armorList = new Armor[3];
		armorList[0] = new Armor("Hafif Zırh",1,1,15);
		armorList[1] = new Armor("Orta Zırh",2,3,25);
		armorList[2] = new Armor("Ağır Zırh",3,5,40);
		return armorList;
	}
	
	public static Armor getArmorObjByID(int id) {
		for(Armor armor : Armor.armors()) {
			if(id == armor.getId()) {
				return armor;
			}
		}
		return null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDefence() {
		return defence;
	}

	public void setDefence(int defence) {
		this.defence = defence;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
	
}
