package id.ac.its.waldo.rpscardgame;
import java.util.Random;
public class Card {
	private int type;

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Card(int type) {
		this.type = type;
	}
	
	public Card() {
		Random rand = new Random();
		this.type = rand.nextInt(3);
	}
}