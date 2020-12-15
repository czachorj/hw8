import java.util.*;

public class Ocean {
	
	Ship[][] ships = new Ship[10][10];
	private int shotsFired;
	private int hitCount;
	private int shipsSunk;
	private int missCount;
	boolean [][] allFired = new boolean [10][10]; //array to keep track of spots that were fired upon but had no ship
	Ocean() {
		// creates empty ocean and initializes game variables
		shotsFired = 0;
		hitCount = 0;
		shipsSunk = 0;
		missCount =0;
		for (int a = 0; a<10; a++) {
			for (int b = 0; b<10; b++) {
				EmptySea emptySea = new EmptySea();
				ships[a][b] = emptySea;
				allFired[a][b] = false; //initiate all fired as false
			}
		}
	}
	
	public void placeAllShipsRandomly() {
		// place the ships randomly, starting with the larger ships first
		int a; 
		int b;
		boolean horizontal = true;
		Random r = new Random();
		
		// place one battle ship ;; will keep looping until gets a valid placement
		while (true) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			Battleship bs = new Battleship();
			
			if (bs.okToPlaceShipAt(a, b, horizontal, this)) {
				bs.placeShipAt(a, b, horizontal, this);
				break;
				
			// if cant place it horizontally, try vertically, and if that doesnt work, pick new numbers
			} else if (bs.okToPlaceShipAt(a, b, !horizontal, this)) {
				bs.placeShipAt(a, b, !horizontal, this);
				break;
			}			
		}
		
		// place 2 cruisers
		int cruisersPlaced = 0;
		while (cruisersPlaced < 2) {
			a = r.nextInt(10);
			b = r.nextInt(10);
			Cruiser cr = new Cruiser();
			
			if (cr.okToPlaceShipAt(a, b, horizontal, this)) {
				cr.placeShipAt(a, b, horizontal, this);
				cruisersPlaced++;
				
			// if cant place it horizontally, try vertically, and if that doesnt work, pick new numbers
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
				
			// if cant place it horizontally, try vertically, and if that doesnt work, pick new numbers
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
			
			// if cant place it horizontally, try vertically, and if that doesnt work, pick new numbers
			} else if (sub.okToPlaceShipAt(a, b, !horizontal, this)) {
				sub.placeShipAt(a, b, !horizontal, this);
				subsPlaced++;
			}			
		}
	}
	
	public boolean isOccupied(int row, int column) {
		// error checking
		if (row < 0 || row > 9 || column < 0 || column > 9) {
			return false;
		}
		
		// return true if the location is not empty (ie contains a ship)
		if (ships[row][column].getShipType() != "empty") {
			return true;
		}
		// if no ship, return false
		return false;
	}
	
	public boolean shootAt(int row, int column) {
		allFired[row][column] = true; //mark that spot as a miss and add it to the array to keep track
		++this.shotsFired;
		// return true if location contains an afloat ship
		
		if (this.isOccupied(row, column)) {
			if (ships[row][column].isSunk() == false) {
				ships[row][column].shootAt(row, column);

				this.hitCount++;
				return true;
			}
		}

		++this.missCount;
		return false;

	}
	
	public int getShotsFired() {
		return this.shotsFired;
	}
	
	public int getHitCount() {
		return this.hitCount;
	}
	
	public int getMissCount() {
		return this.missCount;
	}
	
	public int getShipsSunk() {
		return this.shipsSunk;
	}
	
	public boolean isGameOver() {
		// if all ships are sunk, return true. first instance of a non-sinked ship, return false
		for (int g = 0; g<10; g++) {
			for (int k = 0; k<10; k++) {
				if (ships[g][k].getShipType() == "empty") {
					continue;
				}
				if (ships[g][k].isSunk() == true) {
					continue;
					
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	
	public Ship[][] getShipArray() {
		// returns 10x10 array of ships
		return this.ships;
	}
	
	
	public void print() {
		System.out.println("     0 1 2 3 4 5 6 7 8 9 ");
		System.out.println("    ---------------------");
		for(int i=0; i<10; i++) {
			System.out.print(i + " | ");
			for(int j=0; j<10; j++) {

				if(!allFired[i][j]) {
					System.out.print(" .");
				}
//				else if(ships[i][j].shootAt(i, j)){
//
//					System.out.print(" " + ships[i][j].toString());   //will print x if hit and s if sunk for ships fired at
//				}
//				
//				else {
//					System.out.print(" -");
//				}

				else{
					System.out.print(" " + ships[i][j].toString());
				}
			}
			System.out.println();
		}
	}


	
	
	
	
	// right now this just prints the ship placements -- need to fix print method.
	// maybe shift what's in the print method now into a testPrint method so we can 
	// see the placements of the ships to properly debug and make sure everything's working
	public void testPrint() {
		System.out.println("     0 1 2 3 4 5 6 7 8 9 ");
		System.out.println("    ---------------------");
		
		for (int i = 0; i < 10; i++) {
			System.out.print(i + " | ");
			for (int j = 0; j < 10; j++) {
				if (ships[i][j].getShipType() == "battleship") {
					System.out.print("b ");
				}
				else if (ships[i][j].getShipType() == "cruiser"){
					System.out.print("c ");
				}
				else if (ships[i][j].getShipType() == "destroyer"){
					System.out.print("d ");
				}
				else if (ships[i][j].getShipType() == "submarine"){
					System.out.print("s ");
				}
				else {
					System.out.print("- ");
				}
			}
			System.out.println();
		}
		

	}
	}
	
	

	
	

