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
	
	void battlshipGameRunner() {
		Ocean newOcean = new Ocean();
		int r=0;
		int c=0;
		newOcean.placeAllShipsRandomly();
		newOcean.print();
		Scanner s = new Scanner(System.in);
		
		while(!newOcean.isGameOver()) {
		System.out.println("Enter the coordinate you'd like to attack. Format should be row number then column number. Each an integer between 0 and 9:");
		r = s.nextInt();
		c = s.nextInt();

		newOcean.shootAt(r, c);
		System.out.println(newOcean.getShotsFired());
		
		}
		
	}
	
	
	public static void main(String[] args) {
		BattleshipGame newGame = new BattleshipGame();
		newGame.battlshipGameRunner();
		

		//right now this just prints the ship placements -- need to fix print method.
		// maybe shift what's in the print method now into a testPrint method so we can 
		// see the placements of the ships to properly debug and make sure everything's working
//		e.print();
	

	}

}
