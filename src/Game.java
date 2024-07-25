import java.util.Scanner;

public class Game {
	
	private Scanner input = new Scanner(System.in);
	
	public void start() {
		System.out.println("Macera oyununa hoşgeldiniz! Lütfen bir isim giriniz: ");
		String playerName = input.nextLine();
		Player player = new Player(playerName);
		System.out.println("Merhaba " + player.getName() + ". Oyuna başlamadan önce karakterini seç!");
		player.selectChar();
		player.printPlayerInfo();
		player.setDefHealthy(player.getHealthy());
		
		Location location = null;
		while(true) {
			System.out.println();
			System.out.println("=== Bölgeler ===");
			System.out.println("1-)Güvenli Ev --> Burada canınız yenilenir ve bu bölgede düşman yoktur.");
			System.out.println("2-)Mağaza --> Buradan zırh ve silah satın alırsınız.");
			System.out.println("3-)Mağara --> <Ödül> Yemek : Dikkat et karşına zombi çıkabilir!");
			System.out.println("4-)Orman --> <Ödül> Odun : Dikkat et karşına vampir çıkabilir!");
			System.out.println("5-)Nehir --> <Ödül> Su : Dikkat et karşına ayı çıkabilir!");
			System.out.println("6-)Maden --> <Ödül> Silah,Zırh,Para kazanma ihtimali : Dikkat et karşına yılan çıkabilir!");
			System.out.println("0-)Oyundan Çık ");
			System.out.print("Seçiminiz: ");
			int selectLoc = input.nextInt();
			if(player.getInventory().isFood() && selectLoc == 3 || player.getInventory().isWood() && selectLoc == 4 || player.getInventory().isWater() && selectLoc == 5) {
				System.out.println("Buradaki ödülleri topladın. Burada işin bitti. Sizi güvenli eve aktarıyorum! Canınız fullenecek!");
				selectLoc = 7;
			} 
			
			switch(selectLoc) {
				case 0:
					System.out.println("Oyundan çıktınız, güle güle!");
					break;
				case 1:
					location = new SafeHouse(player);
					break;
				case 2:
					location = new ToolStore(player);
					break;
				case 3:	
					location = new Cave(player);
					break;
				case 4:
					location = new Forest(player);
					break;
				case 5:
					location = new River(player);
					break;
				case 6:
					location = new Mine(player);
					break;
				default:
					location = new SafeHouse(player);
					break;
			}
			
			if(selectLoc == 0) {
				break;
			}
			
			if(!location.onLocation()) {
				System.out.println("GAME OVER!");
				break;
			}
			
			if(player.getInventory().isFood() && player.getInventory().isWater() && player.getInventory().isWood()) {
				System.out.println("Tebrikler! Tüm ödülleri topladınız ve bu zorlu yolculuğu tamamladınız!");
				break;
			}
		}
		
		
		
	}
	
}
