
public class Battleship extends Ship {
	
	public Battleship() {
		this.length = 4;
		this.hit = new boolean[4];
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
