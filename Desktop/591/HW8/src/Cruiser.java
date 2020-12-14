
public class Cruiser extends Ship {
	
	public Cruiser() {
		this.length = 3;
		this.hit = new boolean[3];
		

	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "cruiser";
	}
	
}