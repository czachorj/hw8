
public class Battleship extends Ship {
	
	public Battleship() {
		this.length = 4;
		this.hit = new boolean[this.length];
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "battleship";
	}
	
}
