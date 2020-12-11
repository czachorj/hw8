
public class Ocean {
	
	Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	
	Ocean() {
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		
		for (int a = 0; a<10; a++) {
			for (int b = 0; b<10; b++) {
				EmptySea emptySea = new EmptySea();
				ships[a][b] = emptySea;
			}
		}
	}
	
	public void placeAllShipsRandomly() {
		
	}
	
	public boolean isOccupied(int row, int column) {
		return true;
	}
	
	public boolean shootAt(int row, int column) {
		return true;
	}
	
	public int getShotsFired() {
		return this.shotsFired;
	}
	
	public int getHitCount() {
		return this.hitCount;
	}
	
	public int getShipsSunk() {
		return this.shipsSunk;
	}
	
	public boolean isGameOver() {
		return false;
	}
	
	public Ship[][] getShipArray() {
		return this.ships;
	}
	
	public void print() {
		
	}
	
}
