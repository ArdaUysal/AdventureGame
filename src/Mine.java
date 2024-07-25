import java.util.Random;
import java.util.Scanner;

public class Mine extends BattleLoc{
	
	private Scanner input = new Scanner(System.in);

	public Mine(Player player) {
		super(player, "Maden", new Snake(), "Sürpriz");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean onLocation() {
		System.out.println("Şu an buradasınız: " + this.getName());
		System.out.println("Dikkatli ol! Burada " + this.getObstacle().getName() + " yaşıyor.");
		int obsNumber = this.getObstacle().obstacleNumber();
		System.out.println("Burada " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor!");
		System.out.print("<S>avaş veya <K>aç: ");
		String isFight = input.nextLine();
				
		if(isFight.equalsIgnoreCase("S") && combat(obsNumber)) {
			System.out.println("Tüm düşmanları yendiniz!");
			winAward();
			return true;
		}
		
		if(this.getPlayer().getHealthy() <= 0) {
			System.out.println("Malesef verdiğin savaşta mağlup oldun!");
			return false;
		}
		
		return true;
		
	}
	
	@Override
	public void obstacleStats(int i) {
		System.out.println();
		System.out.println(i + ". Canavar İstatistikleri");
		System.out.println("------------------------------------");
		System.out.println("Sağlık: " + this.getObstacle().getHealthy());
		System.out.println("Hasar: " + this.getObstacle().getDamage());
		System.out.println("Ödülü: Silah,Zırh veya Para");
		System.out.println();
	}
	
	@Override
	public void winAward() {
		Random toolType = new Random();
		Random tool = new Random();
		// Hangi tür ödül düşeceğini belirler
		int toolTypeValue = toolType.nextInt(100) + 1;
		System.out.println("tooltype: "+ toolTypeValue);
		// Belirlenen türden hangisinin düşeceğini belirler
		int toolValue = tool.nextInt(100) + 1;
		System.out.println("tool: "+ toolValue);
		if(toolTypeValue <= 15) {
			if(toolValue <= 20) {
				System.out.println("Vay canına! Bir TÜFEK buldun!");
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
			} else if(toolValue <= 50) {
				System.out.println("Vay canına! Bir KILIÇ buldun!");
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
			} else {
				System.out.println("Vay canına! Bir TABANCA buldun!");
				this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));
			}
		} else if(toolTypeValue <= 30) {
			if(toolValue <= 20) {
				System.out.println("Vay canına! Bir AĞIR ZIRH buldun!");
				this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(3));
			} else if(toolValue <= 50) {
				System.out.println("Vay canına! Bir ORTA ZIRH buldun!");
				this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(2));
			} else {
				System.out.println("Vay canına! Bir HAFİF ZIRH buldun!");
				this.getPlayer().getInventory().setArmor(Armor.getArmorObjByID(1));
			}
		} else if(toolTypeValue <= 55) {
			if(toolValue <= 20) {
				System.out.println("Vay canına! 10 adet ALTIN buldun!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 10);
			} else if(toolValue <= 50) {
				System.out.println("Vay canına! 5 adet ALTIN buldun!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 5);
			} else {
				System.out.println("Vay canına! 1 adet ALTIN buldun!");
				this.getPlayer().setMoney(this.getPlayer().getMoney() + 1);
			}
		} else {
			System.out.println("Üzgünüm! Madende değerli hiçbir şey bulamadın, oldukça şanssız bir gün!");
		}
		
	}

}
