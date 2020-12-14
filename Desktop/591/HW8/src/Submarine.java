public class Submarine extends Ship {
	
	public Submarine() {
		this.length = 1;
		this.hit = new boolean[1];

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