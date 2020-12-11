
public abstract class Ship {
	
	int bowRow;
	int bowColumn;
	int length;
	boolean horizontal;
	boolean[] hit;
	
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
	
	
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		if (ocean.isOccupied(row, column) ) {
			return false;
		}
		
		if (horizontal) {
			if (column + this.length > 10) {
				return false;
			}
			
			if (ocean.isOccupied(row, column + this.length+1)) {
				return false;
			}
			
			for (int a=column; a<column+this.length; a++) {
				if (ocean.isOccupied(row, a) ) {
					return false;
				} 
				
				if (row > 0) {
					if (ocean.isOccupied(row-1, a) ) {
						return false;
					} 
					if (ocean.isOccupied(row-1, a-1) ) {
						return false;
					} 
					if (ocean.isOccupied(row-1, a+1) ) {
						return false;
					} 
				}
				
				if (row < 10) {
					if (ocean.isOccupied(row+1, a) ) {
						return false;
					} 
					if (ocean.isOccupied(row+1, a-1) ) {
						return false;
					} 
					if (ocean.isOccupied(row+1, a+1) ) {
						return false;
					} 
				}
				
			}
		// vertical
		} else {
			if (row + this.length > 10) {
				return false;
			}
			
			if (ocean.isOccupied(row + this.length+1, column)) {
				return false;
			}
			
			
			for (int a=row; a<row+this.length; a++) {
				if (ocean.isOccupied(a, column) ) {
					return false;
				} 
				
				if (a > 0) {
					if (ocean.isOccupied(a-1, column) ) {
						return false;
					} 
					if (ocean.isOccupied(a-1, column-1) ) {
						return false;
					} 
					if (ocean.isOccupied(a-1, column+1) ) {
						return false;
					} 
				}
				
				if (a < 10) {
					if (ocean.isOccupied(a+1, column) ) {
						return false;
					} 
					if (ocean.isOccupied(a+1, column-1) ) {
						return false;
					} 
					if (ocean.isOccupied(a+1, column+1) ) {
						return false;
					} 
				}
				
			}
			
		}
		
		return true;
		
	}
	
	
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowColumn(column);
		this.setBowRow(row);
		this.setHorizontal(horizontal);
		
		if (horizontal) {
			for (int c = column; c<column+this.length; c++) {
				ocean.ships[row][c] = this;
			}
		} else {
			for (int r = row; r<row+this.length; r++) {
				ocean.ships[r][column] = this;
			}
		}
	}
	
	
	
	
	
	
	
	
}
