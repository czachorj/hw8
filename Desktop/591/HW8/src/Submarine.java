public class Submarine extends Ship {
	
	public Submarine() {
		this.length = 1;
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
		return "submarine";
	}
	
}