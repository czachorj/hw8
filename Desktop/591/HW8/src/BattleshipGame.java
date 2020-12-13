import java.util.*;
public class BattleshipGame {

	 // TODO: create these methods
	//accept "shots" from the user
	//display the results
	//print scores
	//ask the user if they want to play again.
	
	// row numbers should be displayed along the left edge of the array, and
	//column numbers should be displayed along the top. Numbers should be 0 to 9, not 1 to 10.
	//The top left corner square should be 0, 0. Use different characters to indicate locations that
	//	contain a hit, locations that contain a miss, and locations that have never been fired upon.

//	public static void beginGame() {
//		Ocean newOcean = new Ocean();
//		newOcean.placeAllShipsRandomly();
//		newOcean.print();
//		
//	}
	
	void battleshipGameRunner() {
		Ocean newOcean = new Ocean();
		int r=0;
		int c=0;
		newOcean.placeAllShipsRandomly();
		newOcean.print();
		Scanner s = new Scanner(System.in);
		
		while(!newOcean.isGameOver()) {
		System.out.println("Enter the coordinate you'd like to attack. Format should be row number then column number. Each an integer between 0 and 9:");
		r = s.nextInt();                                    //scan input for r (row) and c (col) coordinates from user
		c = s.nextInt();

		if(newOcean.shootAt(r, c)) {                        //if shootAt is true i.e. if we hit, print hit
			System.out.println("Hit!");
			System.out.println("__________________");
			System.out.println();
			Ship [][] targetShip = newOcean.getShipArray(); //get array of ocean at current state
			if(targetShip[r][c].isSunk()) {                 //if targetShip at the location hit is sunk, print what type of ship got sunk
				System.out.println("You just sunk a " + targetShip[r][c].getShipType());
				System.out.println("______________");
				System.out.println();
			}
			
		}
		else {
			System.out.println("Miss.");                    //if shootAt is false, that means it was a miss
			System.out.println("_______________");
			System.out.println();
		}
		
		System.out.println("Shots Fired: " + newOcean.getShotsFired());    //print out current count of shots
		System.out.println("Hits: " + newOcean.getHitCount()); //print out hits
		System.out.println("Misses: " + newOcean.getMissCount()); //print out misses
		System.out.println();
		newOcean.print();                //print ocean as is
		}
		

		System.out.println("You sunk all the ships in " + newOcean.getShotsFired() + " turns.");
		
	}
	
	/*
	 * method to determine if player wants to play again
	 */
	boolean playAgain() {
		Scanner s = new Scanner(System.in);
		String answer;
		System.out.println("Do you want to play again? (y/n) ");
		answer = s.next();
		if(answer.startsWith("y") || answer.startsWith("Y")) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	
	public static void main(String[] args) {
		BattleshipGame newGame = new BattleshipGame();
		newGame.battleshipGameRunner();       //play first game
		
		while(newGame.playAgain()) {           //while player wants to keep playing, keep looping and calling battleshipGamerunner
			newGame.battleshipGameRunner();
		}
		
		

		//right now this just prints the ship placements -- need to fix print method.
		// maybe shift what's in the print method now into a testPrint method so we can 
		// see the placements of the ships to properly debug and make sure everything's working
//		e.print();
	

	}

}
