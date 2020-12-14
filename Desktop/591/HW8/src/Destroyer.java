
public class Destroyer extends Ship {
	
	public Destroyer() {
		this.length = 2;
		this.hit = new boolean[2];

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