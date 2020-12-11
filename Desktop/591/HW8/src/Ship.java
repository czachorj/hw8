
public abstract class Ship {
	
	private int bowRow;
	private int bowColumn;
	protected int length;
	private boolean horizontal;
	protected boolean[] hit = new boolean[4];
	
	
	// TODO: okToPlaceShipAt and placeShipAt

	
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



	boolean isSunk() {
		for (int a=0; a<this.getLength(); a++) {
			if (!this.hit[a]) {
				return false;
			}
		}
	return true;
}

	
	
	boolean shootAt(int row, int column) {
		if (this.isSunk()) {
			return false;
		}
		if (this.horizontal) {
			if (this.bowColumn == column) {
				for (int a = 0; a<this.getLength(); a++) {
					if (this.bowRow+a == row) {
						this.hit[a] = true;
						return true;
					}
				}
			}
		} else {
			if (this.bowRow == row) {
				for (int a = 0; a<this.getLength(); a++) {
					if (this.bowColumn+a == column) {
						this.hit[a] = true;
						return true;
					}
				}
			}
		}
		return false;
	}
	
	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		} else {
			return "S";
		}
	}
	
}
