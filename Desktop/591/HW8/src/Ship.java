
public abstract class Ship {

	int bowRow;			// the row w/ the front of the ship
	int bowColumn;		// column with the front of the ship
	int length;
	boolean horizontal;
	boolean[] hit = new boolean[4]; //telling whether the ship has been hit.
	int shipHitCount = 0;

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

	int getLength() {
		return length;
	}

	abstract String getShipType();


/*
 * this method checks if a ship is sunk 
 */
	boolean isSunk() {
		// return true if every part of ship is hit


		//////**alternate method**////
		//		if(this.shipHitCount == this.getLength()) {
		//			return true;
		//		}
		//		else {
		//			return false;
		//		}
		//	}

		for (int a=0; a<this.getLength(); a++) {

			if (hit[a] == false) {

				return false;
			}
		}
		return true;
	}


/////////ALTERNATE METHOD/////////////
	//	boolean shootAt(int row, int column) {
	//
	//		//	 if part of the ship is hit and hasn't been sunk, mark that ship as hit
	//		if(!this.isSunk()) {
	//			if (this.horizontal) {
	//				hit[column - this.bowColumn] = true;
	//				++shipHitCount;
	//				return true;
	//			}
	//			else {
	//				hit[row-this.bowRow] = true;
	//				++shipHitCount;
	//				return true;
	//			}
	//		}
	//		else {
	//			return false;
	//		}
	//
	//	}

/*
 * this method takes in a row and column and returns true if the given input location contains a real afloat ship and
 * updates the number of shots that have been fired
 */
	boolean shootAt (int row, int column) {
		if(this.isSunk() == true) {
			return false;
		}

		if(this.horizontal) {
			for(int a=0; a<this.getLength(); a++) {
				if (this.bowRow == row) {
					if (this.bowColumn + a == column) {
						this.hit[a] = true;
						++shipHitCount;
						return true;
					}
				}
			}
		}
		else {

			for (int a = 0; a<this.getLength(); a++) {
				if (this.bowColumn == column) {
					if (this.bowRow + a == row) {
						this.hit[a] = true;
						++shipHitCount;
						return true;
					}
				}
			}
		}
		
		System.out.println(shipHitCount);
		return false;
	}

	@Override
	public String toString() {
		if (this.isSunk()) {
			return "x";
		} 
		else {
			return "S";
		}
	}

/*
 * returns true if it is a VALID move to put a ship of length with its bow in this location with the given orientation.
 * will not actually place the ship.
 */
	public boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		// check if ship is already in the position
		if (ocean.isOccupied(row, column) ) {
			return false;
		}
		// check if there is another ship immediately to the right
		if (ocean.isOccupied(row, column+1) ) {
			return false;
		}
		// check if there is a ship immediately to the left
		if (ocean.isOccupied(row, column-1) ) {
			return false;
		}


		if (horizontal) {
			// if the ship will stick out of bounds
			if (column + this.length > 10) {
				return false;
			}

			//if ship will touch another ship horizontally
			if (ocean.isOccupied(row, column+1)) {
				return false;
			}
			//if ship will touch another ship horizontally
			if (ocean.isOccupied(row, column + this.length+1)) {
				return false;
			}
			//if ship will touch another ship horizontally
			if (ocean.isOccupied(row, column-1)) {
				return false;
			}


			for (int a=column; a<column+this.length; a++) {

				// if ship will "overwrite" a previous ship's placement
				if (ocean.isOccupied(row, a) ) {
					return false;
				} 

				if (row > 0) {
					// if ship touches vertically
					if (ocean.isOccupied(row-1, a) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(row-1, a-1) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(row-1, a+1) ) {
						return false;
					} 
				}

				if (row < 10) {
					// if ship touches vertically
					if (ocean.isOccupied(row+1, a) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(row+1, a-1) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(row+1, a+1) ) {
						return false;
					} 
				}

			}
			// vertical
		} else {
			// if the ship will stick out of bounds
			if (row + this.length > 10) {
				return false;
			}
			// if the ship has another ship immediately below it
			if (ocean.isOccupied(row + this.length+1, column)) {
				return false;
			}
			// if the ship has another ship immediately above it
			if (ocean.isOccupied(row-1, column)) {
				return false;
			}

			for (int a=row; a<row+this.length; a++) {
				// if the ship will overwrite another ship
				if (ocean.isOccupied(a, column) ) {
					return false;
				} 

				if (a > 0) {
					// if ship touches vertically
					if (ocean.isOccupied(a-1, column) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(a-1, column-1) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(a-1, column+1) ) {
						return false;
					} 
				}

				if (a < 10) {
					// if ship touches vertically
					if (ocean.isOccupied(a+1, column) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(a+1, column-1) ) {
						return false;
					} 
					// if ship touches diagonally
					if (ocean.isOccupied(a+1, column+1) ) {
						return false;
					} 
				}		
			}
		}
		return true;
	}

/*
 * this method actually places the ship in the ocean given a row, column, horizontal location, and ocean.
 */
	public void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {
		this.setBowColumn(column);
		this.setBowRow(row);
		this.setHorizontal(horizontal);


		// puts the ship in the ocean, given row and column values -- if cleared that it is okToPlaceShipAt these values
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
