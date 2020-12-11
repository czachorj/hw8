
public class EmptySea extends Ship {
	
	public EmptySea() {
		this.length = 1;
		for (int a = 0; a<this.length; a++) {
			this.hit[a] = false;
		}
	}
	
	@Override
	int getLength() {
		return this.length;
	}
	
	@Override
	String getShipType() {
		return "empty";
	}
	
	@Override
	boolean shootAt(int row, int column) {
		return false;
	}
	
	@Override
	boolean isSunk() {
		return false;
	}
	
	@Override
	public String toString() {
		return this.getShipType();
	}
	
}
