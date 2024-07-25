import java.util.Random;

public class Snake extends Obstacle{

	private static Random r = new Random();
	int snakeDamage = r.nextInt(6) + 1;
	
	public Snake() {
		super(4, "Yılan", r.nextInt(3) + 3 , 12, 0);
		// TODO Auto-generated constructor stub
	}
	
	public int obstacleNumber() {
		Random r = new Random();
		int obsNumber = r.nextInt(5) + 1;
		return obsNumber;
	}

	

	
	
	

}
