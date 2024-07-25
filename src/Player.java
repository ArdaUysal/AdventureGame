import java.util.Scanner;

import GameCharPackage.Archer;
import GameCharPackage.GameChar;
import GameCharPackage.Knight;
import GameCharPackage.Samurai;

public class Player {
	
	private Inventory inventory;
	private String name;
	private String charName;
	private int damage;
	private int healthy;
	private int money;
	private int defHealthy;
	
	private Scanner input = new Scanner(System.in);
	
	public Player(String name) {
		this.name = name;
		this.inventory = new Inventory();
	}
	
	public void selectChar() {
		
		boolean isSelect = false;
		
		while(!isSelect) {
			System.out.println("--------------------------------------------------");
			System.out.println("    Karakter || ID || Hasar || Sağlık || Para ");
			System.out.println("1-) Samuray  || 1  ||   5   ||   21   ||  15  ");
			System.out.println("2-)  Okçu    || 2  ||   7   ||   18   ||  20  ");
			System.out.println("3-) Şovalye  || 3  ||   8   ||   24   ||  5   ");
			String selectID = input.nextLine();
			switch(selectID) {
			case "1":
				System.out.println("Samuray karakterini seçtiniz! Başarılar!");
				initPlayer(new Samurai());
				isSelect = true;
				break;
			case "2":
				System.out.println("Okçu karakterini seçtiniz! Başarılar!");
				initPlayer(new Archer());
				isSelect = true;
				break;
			case "3":
				System.out.println("Şovalye karakterini seçtiniz! Başarılar!");
				initPlayer(new Knight());
				isSelect = true;
				break;
			default:
				System.out.println("Geçersiz ID! Lütfen tekrar seçiniz.");
				break;
		}
	}	
	}
	
	public void initPlayer(GameChar gameChar) {
		this.charName = gameChar.getCharName();
		this.damage = gameChar.getDamage();
		this.healthy = gameChar.getHealthy();
		this.defHealthy = gameChar.getHealthy();
		this.money = gameChar.getMoney();
	}
	
	public void printPlayerInfo() {
		System.out.println("Oyuncu adı: " + this.getName() 
							+ "|| Karakter: " + this.getCharName() 
							+ "|| Hasar: " + this.getDamage() 
							+ "|| Sağlık: " + this.getHealthy()
							+ "|| Zırh: " + this.getInventory().getArmor().getName()
							+ "|| Zırh Savunması: " + this.getInventory().getArmor().getDefence()
							+ "|| Para: " + this.getMoney());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage + this.getInventory().getWeapon().getDamage();
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

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public int getDefHealthy() {
		return defHealthy;
	}

	public void setDefHealthy(int defHealthy) {
		this.defHealthy = defHealthy;
	}

	public Scanner getInput() {
		return input;
	}

	public void setInput(Scanner input) {
		this.input = input;
	}
	
	
	
	
	
}
