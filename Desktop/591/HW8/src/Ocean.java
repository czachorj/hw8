import java.util.*;

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
		int a;
		int b;
		boolean horizontal = true;
		Random r = new Random();
		
		// place one battle ship
		while (true) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			Battleship bs = new Battleship();
			
			if (bs.okToPlaceShipAt(a, b, horizontal, this)) {
				bs.placeShipAt(a, b, horizontal, this);
				break;
			} else if (bs.okToPlaceShipAt(a, b, !horizontal, this)) {
				bs.placeShipAt(a, b, !horizontal, this);
				break;
			}			
		}
		
		// place two cruisers
		int cruisersPlaced = 0;
				while (cruisersPlaced < 2) {
					a = r.nextInt(10);
					b = r.nextInt(10);
					Cruiser cr = new Cruiser();
					
					if (cr.okToPlaceShipAt(a, b, horizontal, this)) {
						cr.placeShipAt(a, b, horizontal, this);
						cruisersPlaced++;
					} else if (cr.okToPlaceShipAt(a, b, !horizontal, this)) {
						cr.placeShipAt(a, b, !horizontal, this);
						cruisersPlaced++;
					}			
				}
				
				// place 3 destroyers
				int destroyersPlaced = 0;
						while (destroyersPlaced < 3) {
							a = r.nextInt(10);
							b = r.nextInt(10);
							Destroyer des = new Destroyer();
							
							if (des.okToPlaceShipAt(a, b, horizontal, this)) {
								des.placeShipAt(a, b, horizontal, this);
								destroyersPlaced++;
							} else if (des.okToPlaceShipAt(a, b, !horizontal, this)) {
								des.placeShipAt(a, b, !horizontal, this);
								destroyersPlaced++;
							}			
						}
						
						// place 4 submarines
						int subsPlaced = 0;
								while (subsPlaced < 4) {
									a = r.nextInt(10);
									b = r.nextInt(10);
									Submarine sub = new Submarine();
									
									if (sub.okToPlaceShipAt(a, b, horizontal, this)) {
										sub.placeShipAt(a, b, horizontal, this);
										subsPlaced++;
									} else if (sub.okToPlaceShipAt(a, b, !horizontal, this)) {
										sub.placeShipAt(a, b, !horizontal, this);
										subsPlaced++;
									}			
								}
										
		
	}
	
	public boolean isOccupied(int row, int column) {
		// invalid user response
		if (row<0 || row>9 || column<0 || column>9) {
			return false;
		}
		
		if (ships[row][column].getShipType() != "empty") {
			return true;
		}
		return false;
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
