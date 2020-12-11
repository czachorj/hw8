
public abstract class Ship {
	
	private int bowRow;
	private int bowColumn;
	protected int length;
	private boolean horizontal;
	protected boolean[] hit = new boolean[4];
	
	
	public Ship() {
	}
	
	int getBowRow() {
		return bowRow;
	}
	
	int getBowColumn() {
		return bowColumn;
	}
	
	boolean isHorizontal() {
		return horizontal;
	}
	
	void setBowRow(int row) {
		this.bowRow = row;
	}
	
	void setBowColumn(int column) {
		this.bowColumn = column;
	}
	
	void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	
	abstract int getLength();
	abstract String getShipType();
	
//	boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
//		if (row>9 || column>9) {
//			return false;
//		}
//		
//		
//	}
	
}
