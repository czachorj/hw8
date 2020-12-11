
public class Destroyer extends Ship {
	
	public Destroyer() {
		this.length = 2;
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
		return "destroyer";
	}
	
}