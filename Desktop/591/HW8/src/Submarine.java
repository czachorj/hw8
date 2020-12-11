public class Submarine extends Ship {
	
	public Submarine() {
		this.length = 1;
		this.hit = new boolean[this.length];

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