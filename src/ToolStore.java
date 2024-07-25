

import java.util.Scanner;

public class ToolStore extends NormalLoc {
	
	Scanner input = new Scanner(System.in);

	public ToolStore(Player player) {
		super(player, "Mağaza");
	}

	@Override
	public boolean onLocation() {
		System.out.println("Silah Mağazasındasınız.");
		System.out.println();
		System.out.println("1-)Silahlar");
		System.out.println("2-)Zırhlar");
		System.out.println("3-)Çıkış Yap");
		System.out.print("Seçiminiz: ");
		int select = input.nextInt();
		
		while(select < 1 || select > 3) {
			System.out.println("Lütfen geçerli bir işlem yapınız!");
			select = input.nextInt();
		}
		
		switch(select) {
			case 1:
				printWeaponList();
				buyWeapon();
				break;
			case 2:
				printArmorList();
				buyArmor();
				break;
			case 3:
				System.out.println("Yine bekleriz! :)");
				return true;
		}
		
		return true;
	}
	
	public void printWeaponList() {
		System.out.println("-----SİLAHLAR-----");
		System.out.println();
		for(Weapon weapon : Weapon.weapons()) {
			System.out.println("ID: " + weapon.getId() 
								+ " Silah: " + weapon.getName()
								+ " Hasar: " + weapon.getDamage()
								+ " Ücret: " + weapon.getMoney());
		}
		System.out.println();
		System.out.println("İptal etmek için '0' tuşlayın.");
	}
	
	public void buyWeapon() {
		System.out.print("Almak istediğiniz silahı seçin: ");
		int selectWeapon = input.nextInt();
		while(selectWeapon != 0 && selectWeapon < 1 || selectWeapon > Weapon.weapons().length) {
			System.out.println("Lütfen geçerli bir işlem yapınız!");
			selectWeapon = input.nextInt();
		}
		if(selectWeapon == 0) {
			onLocation();
		} else {
			Weapon weapon = Weapon.getWeaponObjByID(selectWeapon);
			if(weapon.getMoney() > this.getPlayer().getMoney()) {
				System.out.println("Bu silahı alabilmek için yeterli paranız yok!");
				printWeaponList();
				buyWeapon();
			} else {
				int newPlayerMoney = this.getPlayer().getMoney() - weapon.getMoney();
				this.getPlayer().setMoney(newPlayerMoney);
				System.out.println("Yeni paranız: " + this.getPlayer().getMoney());
				
				System.out.println("Önceki silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
				this.getPlayer().getInventory().setWeapon(weapon);
				System.out.println("Yeni silahınız: " + this.getPlayer().getInventory().getWeapon().getName());
				this.getPlayer().printPlayerInfo();
			}
		}
		
	}
	
	public void printArmorList() {
		System.out.println("-----ZIRHLAR-----");
		System.out.println();
		for(Armor armor : Armor.armors()) {
			System.out.println("ID: " + armor.getId() 
								+ " Zırh: " + armor.getName()
								+ " Savunma: " + armor.getDefence()
								+ " Ücret: " + armor.getMoney());
		}
		System.out.println();
		System.out.println("İptal etmek için '0' tuşlayın.");
	}
	
	public void buyArmor() {
		System.out.print("Almak istediğiniz zırhı seçin: ");
		int selectArmor = input.nextInt();
		while(selectArmor != 0 && selectArmor < 1 || selectArmor > Armor.armors().length) {
			System.out.println("Lütfen geçerli bir işlem yapınız!");
			selectArmor = input.nextInt();
		}
		if(selectArmor == 0) {
			onLocation();
		} else {
			Armor armor = Armor.getArmorObjByID(selectArmor);
			if(armor.getMoney() > this.getPlayer().getMoney()) {
				System.out.println("Bu silahı alabilmek için yeterli paranız yok!");
				printArmorList();
				buyArmor();
			} else {
				int newPlayerMoney = this.getPlayer().getMoney() - armor.getMoney();
				this.getPlayer().setMoney(newPlayerMoney);
				System.out.println("Yeni paranız: " + this.getPlayer().getMoney());
				
				System.out.println("Önceki zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
				this.getPlayer().getInventory().setArmor(armor);
				System.out.println("Yeni Zırhınız: " + this.getPlayer().getInventory().getArmor().getName());
				this.getPlayer().printPlayerInfo();
			}
		}
		
	}
	
	

}
