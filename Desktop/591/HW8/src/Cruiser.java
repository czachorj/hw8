
public class Cruiser extends Ship {
	
	public Cruiser() {
		this.length = 3;
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
		return "cruiser";
	}
	
}