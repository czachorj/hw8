
public class Destroyer extends Ship {
	
	public Destroyer() {
		this.length = 2;
		this.hit = new boolean[this.length];

	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "destroyer";
	}
	
}