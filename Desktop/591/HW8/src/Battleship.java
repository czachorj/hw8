
public class Battleship extends Ship {
	
	public Battleship() {
		this.length = 4;
		for (int a = 0; a < this.length; a++) {
			this.hit[a] = false;
		}
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
