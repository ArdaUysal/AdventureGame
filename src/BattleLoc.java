

import java.util.Random;
import java.util.Scanner;

public abstract class BattleLoc extends Location{
	
	private Obstacle obstacle;
	private String award;
	
	private Scanner input = new Scanner(System.in);

	public BattleLoc(Player player, String name,Obstacle obstacle,String award) {
		super(player, name);
		this.obstacle = obstacle;
		this.award = award;
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
	
	public void winAward() {
		if(this.getAward().equalsIgnoreCase("food")) {
			this.getPlayer().getInventory().setFood(true);
			System.out.println("Mağaradan " + this.getAward() + " ödülünü kazandınız!");
		} else if(this.getAward().equalsIgnoreCase("wood")) {
			this.getPlayer().getInventory().setWood(true);
			System.out.println("Ormandan " + this.getAward() + " ödülünü kazandınız!");
		} else {
			this.getPlayer().getInventory().setWater(true);
			System.out.println("Nehirden " + this.getAward() + " ödülünü kazandınız!");
		}
	}
	
	public void afterHit() {
		System.out.println();
		System.out.println("Sizin canınız: " + this.getPlayer().getHealthy());
		System.out.println("Canavarın canı: " + this.getObstacle().getHealthy());
		System.out.println();
	}
	
	public void playerStats() {
		System.out.println();
		System.out.println("Oyuncu İstatistikleri");
		System.out.println("------------------------------------");
		System.out.println("Sağlık: " + this.getPlayer().getHealthy());
		System.out.println("Zırh: " + this.getPlayer().getInventory().getArmor().getName());
		System.out.println("Bloklama: " + this.getPlayer().getInventory().getArmor().getDefence());
		System.out.println("Silah: " + this.getPlayer().getInventory().getWeapon().getName());
		System.out.println("Hasar: " + this.getPlayer().getDamage());
		System.out.println();
	}
	
	public void obstacleStats(int i) {
		System.out.println();
		System.out.println(i + ". Canavar İstatistikleri");
		System.out.println("------------------------------------");
		System.out.println("Sağlık: " + this.getObstacle().getHealthy());
		System.out.println("Hasar: " + this.getObstacle().getDamage());
		System.out.println("Para Ödülü: " + this.getObstacle().getMoney());
		System.out.println();
	}
	
	
	
	public boolean firstAttackPlayer(int obsNumber) {
		for(int i = 1; i <= obsNumber ; i++) {
			this.getObstacle().setHealthy(this.getObstacle().getDefHealthy());
			playerStats();
			obstacleStats(i);
			while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
				System.out.print("<V>ur veya <K>aç: ");
				String isHit = input.nextLine();
				
				if(isHit.equalsIgnoreCase("V")) {
					System.out.println("Vurdunuz!");
					this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getDamage());
					afterHit();
					if(this.getObstacle().getHealthy() > 0) {
						System.out.println("Canavar size vurdu!");
						int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
						if(obstacleDamage < 0) {
							obstacleDamage = 0;
						}
						this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
						afterHit();
						if(this.getPlayer().getHealthy() <= 0) {
							return false;
						}
					} 
				}
				else {
					return false;
				}
				
			}
			this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
			this.getPlayer().printPlayerInfo();
		}
		
		return true;
		
	}
	
	public boolean firstAttackObstacle(int obsNumber) {
		for(int i = 1; i <= obsNumber ; i++) {
			this.getObstacle().setHealthy(this.getObstacle().getDefHealthy());
			playerStats();
			obstacleStats(i);
			
			System.out.println("Olamaz! Canavar seni fark etti ve sana saldırdı!");
		while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
			System.out.println("Canavar size vurdu!");
			int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
			if(obstacleDamage < 0) {
				obstacleDamage = 0;
			}
			this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
			afterHit();
			
			if(this.getPlayer().getHealthy() <= 0) {
				return false;
			}
			
			if(this.getPlayer().getHealthy() > 0) {
				System.out.print("<V>ur veya <K>aç: ");
				String isHit = input.nextLine();
				if(isHit.equalsIgnoreCase("V")) {
					this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getDamage());
					afterHit();
				} else {
					return false;
				}
			}
			
			
			
		}
		this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
		this.getPlayer().printPlayerInfo();
		}
		
		
		
		return true;
		
	}

	

	public boolean combat(int obsNumber) {
			Random r = new Random();
			int start = r.nextInt(10) + 1;
			System.out.println(start);
			if(start <= 5) {
				System.out.println("Güzel! Canavar seni fark etmedi!");
				return firstAttackPlayer(obsNumber);
			} else {
				System.out.println("Olamaz! Canavar seni fark etti!");
				return firstAttackObstacle(obsNumber);
			}
			
			
			/*while(this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealthy() > 0) {
				System.out.print("<V>ur veya <K>aç: ");
				String isHit = input.nextLine();
				
				if(isHit.equalsIgnoreCase("V")) {
					System.out.println("Vurdunuz!");
					this.getObstacle().setHealthy(this.getObstacle().getHealthy() - this.getPlayer().getDamage());
					afterHit();
					if(this.getObstacle().getHealthy() > 0) {
						System.out.println("Canavar size vurdu!");
						int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getDefence();
						if(obstacleDamage < 0) {
							obstacleDamage = 0;
						}
						this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
						afterHit();
						if(this.getPlayer().getHealthy() <= 0) {
							return false;
						}
					}
				} else {
					return false;
				}
				
			}*/
			//this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
			//this.getPlayer().printPlayerInfo();
			
			
		
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}
	
	

}
