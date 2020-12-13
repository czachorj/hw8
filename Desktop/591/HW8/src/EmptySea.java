
public class EmptySea extends Ship {
	
	public EmptySea() {
		this.length = 1;
		
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
	
//	@Override
//	public String toString() {
//		return this.getShipType();
//	}
	
}
