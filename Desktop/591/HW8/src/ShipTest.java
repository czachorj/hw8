
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class ShipTest {

	/*
	 * setting up for unit testing
	 */

	Ocean newOcean = new Ocean();
	Battleship newBattleship = new Battleship();
	Destroyer newDestroyer1 = new Destroyer();
	Destroyer newDestroyer2 = new Destroyer();
	Destroyer newDestroyer3 = new Destroyer();
	Cruiser newCruiser1 = new Cruiser();
	Cruiser newCruiser2 = new Cruiser();
	Submarine newSub1 = new Submarine();
	Submarine newSub2 = new Submarine();
	Submarine newSub3 = new Submarine();
	Submarine newSub4 = new Submarine();
	EmptySea newEmptySea = new EmptySea();

	/*
	 * before each test case, perform the following setup/placement of ships
	 */

	@Before
	public void setup() {
		newBattleship.placeShipAt(5, 7, false, newOcean);
		newDestroyer1.placeShipAt(0, 1, true, newOcean);
		newDestroyer2.placeShipAt(0, 6, true, newOcean);
		newDestroyer3.placeShipAt(6, 4, false, newOcean);
		newCruiser1.placeShipAt(3, 4, true, newOcean);
		newCruiser2.placeShipAt(5, 9, false, newOcean);
		newSub1.placeShipAt(4, 0, true, newOcean);
		newSub2.placeShipAt(8, 1, true, newOcean);
		newSub3.placeShipAt(9, 4, true, newOcean);
		newSub4.placeShipAt(3, 9, true, newOcean);

	}


	@Test
	void testGetBowRow() {
		newBattleship.placeShipAt(5, 7, false, newOcean);
		assertEquals(newBattleship.getBowRow(),5);

	}

	@Test
	void testGetBowColumn() {
		newDestroyer2.placeShipAt(0, 6, true, newOcean);
		assertEquals(newDestroyer2.getBowColumn(),6);
	}

	@Test
	void testIsHorizontal() {
		newCruiser1.placeShipAt(3, 4, true, newOcean);
		assertEquals(newCruiser1.isHorizontal(),true);
	}

	/*
	 * testing lengths of each ship below
	 */

	@Test
	void testGetLength() {
		assertEquals(newSub1.getLength(),1);
	}
	@Test
	void testGetLength1() {
		assertEquals(newBattleship.getLength(),4);
	}
	@Test
	void testGetLength2() {
		assertEquals(newDestroyer1.getLength(),2);
	}
	@Test
	void testGetLength3() {
		assertEquals(newCruiser1.getLength(),3);
	}

	/*
	 * testing ship type of each ship below
	 */
	@Test
	void testGetShipType() {
		assertEquals(newDestroyer1.getShipType(), "destroyer");
		assertEquals(newSub1.getShipType(), "submarine");
		assertEquals(newBattleship.getShipType(), "battleship");
		assertEquals(newCruiser1.getShipType(), "cruiser");
	}

	/*
	 * testing to see if submarine gets sunk
	 */
	@Test
	void testIsSunk1() {
		newSub1.placeShipAt(4, 0, true, newOcean);
		newSub1.shootAt(4,0);
		assertEquals(newSub1.isSunk(),true);

	}
	/*
	 * testing if destroyer gets sunk 
	 *THIS DOES NOT WORK
	 */
	@Test
	void testIsSunk2() {
		newDestroyer2.placeShipAt(0, 6, true, newOcean);
		newDestroyer2.shootAt(0, 6);
		newDestroyer2.shootAt(0, 7);

		assertEquals(newDestroyer2.isSunk(),true);

	}


	/*
	 * testing to see if destroyer doesn't get sunk what will be spit out
	 */
	@Test
	void testIsSunk3() {
		newDestroyer2.placeShipAt(0, 6, true, newOcean);
		newDestroyer2.shootAt(0, 6);
		newDestroyer2.shootAt(5,9);

		assertEquals(newDestroyer2.isSunk(),false);

	}

	/*
	 * testing whether shootAt works for both a miss and a hit
	 */

	@Test
	void testShootAt1() {
		newDestroyer3.placeShipAt(6, 4, false, newOcean);
		assertEquals(newDestroyer3.shootAt(6, 4), true);


	}
	@Test
	void testShootAt2() {
		newDestroyer3.placeShipAt(6, 4, false, newOcean);
		assertEquals(newDestroyer3.shootAt(0, 6),false);


	}



	@Test
	void testToString() {
		newCruiser2.placeShipAt(5, 9, false, newOcean);
		newSub1.placeShipAt(4, 0, true, newOcean);
		newCruiser2.shootAt(5, 9);
		newSub1.shootAt(4, 0);
		assertEquals(newCruiser2.toString(),"S");
		assertEquals(newSub1.toString(),"x");
	}
	/*
	 * testing if it's okay to place a ship of length 4 starting at the end of the grid, going horizontally
	 */
	@Test
	void testOkToPlaceShipAt1() {
		assertEquals(newBattleship.okToPlaceShipAt(9, 9, true, newOcean), false);

		/*
		 * testing if it's okay to place a ship of length 3 that would run off the grid vertically
		 */
	}
	@Test
	void testOkToPlaceShipAt2() {

		assertEquals(newCruiser1.okToPlaceShipAt(8, 7, false, newOcean), false);

		/*
		 * testing if it's okay to place a ship of length 1 in middle of grid
		 */
	}
	@Test
	void testOkToPlaceShipAt3() {

		assertEquals(newSub1.okToPlaceShipAt(5, 5, true, newOcean), true);

	}

	/*
	 * testing if it's okay to place a ship of length 1 that is diagonally adjacent to an already placed ship
	 */
	@Test
	void testOkToPlaceShipAt4() {	
		newSub1.placeShipAt(5, 5, true, newOcean);
		assertEquals(newSub2.okToPlaceShipAt(6, 6, true, newOcean), false);

	}

	/*
	 * testing if it's okay to place a ship where there is already a ship placed
	 */
	@Test
	void testOkToPlaceShipAt5() {	
		newBattleship.placeShipAt(5, 5, true, newOcean);
		assertEquals(newCruiser1.okToPlaceShipAt(4, 6, false, newOcean), false);

	}
	/*
	 * testing if it's okay to place a ship that is right next to an already placed ship (left/right/top/bottom) both horizontal and vertical
	 */
	@Test
	void testOkToPlaceShipAt6() {	
		newDestroyer1.placeShipAt(5, 5, true, newOcean);
		assertEquals(newSub2.okToPlaceShipAt(5, 7, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(5, 4, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(4, 5, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(6, 5, true, newOcean), false);

	}
	@Test
	void testOkToPlaceShipAt7() {	
		newDestroyer1.placeShipAt(5, 5, false, newOcean);
		assertEquals(newSub2.okToPlaceShipAt(5, 6, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(5, 4, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(4, 5, true, newOcean), false);
		assertEquals(newSub2.okToPlaceShipAt(7, 5, true, newOcean), false);
	}
	//	@Test
	//	void testOkToPlaceShipAt8() {	
	//		newSub1.placeShipAt(5, 5, true, newOcean);
	//		assertEquals(newSub2.okToPlaceShipAt(6, 6, true, newOcean), false);
	//
	//	}

	/*
	 * testing emptySea methods below
	 */


	@Test
	void testEmptySea1() {
		assertEquals(newEmptySea.getLength(),1);
	}

	@Test
	void testEmptySea3() {
		assertEquals(newEmptySea.getShipType(), "empty");
	}
	@Test
	void testEmptySea4() {
		assertEquals(newEmptySea.shootAt(9, 5), false);
	}
	@Test
	void testEmptySea5() {
		assertEquals(newEmptySea.isSunk(), false);
	}
	@Test
	void testEmptySea6() {
		assertEquals(newEmptySea.toString(), "-");
	}


}
