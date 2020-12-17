import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OceanTest {
	
	Ocean newOcean = new Ocean();
	Ocean arrayNewOcean = new Ocean();
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
	 * testing occupied method for non sunk ships
	 */
	
	@Test
	void testIsOccupied1() {
		
		newBattleship.placeShipAt(3, 0, true, newOcean);
		assertEquals(newOcean.isOccupied(3, 1), true);
		assertEquals(newOcean.isOccupied(4,2), false);
		
	}
	
	/*
	 * testing occupied method if out of bounds
	 */
	@Test
	void testIsOccupied2() {
		
		assertEquals(newOcean.isOccupied(13,0), false);
		
	}

	// testing that we record if a ship is in location for shootAt()
	@Test
	void testShootAt() {
		newCruiser1.placeShipAt(4, 3, false, newOcean);
		assertEquals(newOcean.shootAt(5, 3),true);
		assertEquals(newOcean.shootAt(3,3), false);
	}

	// testing that we record 2 shots are fired when 2 shots are fired.
	@Test
	void testGetShotsFired() {
		newOcean.shootAt(4, 6);
		newOcean.shootAt(7, 0);
		assertEquals(newOcean.getShotsFired(),2);
	}

	// testing that we accurately record a hit guess.
	@Test
	void testGetHitCount() {
		newCruiser1.placeShipAt(2, 3, true, newOcean);
		newOcean.shootAt(2, 4);
		assertEquals(newOcean.getHitCount(),1);
		
	}
	
	// testing that we accurately record a missed guess.
	@Test
	void testGetMissCount() {		
		newCruiser1.placeShipAt(2, 3, true, newOcean);
		newOcean.shootAt(2, 6);
		assertEquals(newOcean.getMissCount(),1);
	}

	// testing that our method accurately records when a ship is sunk.
	@Test
	void testGetShipsSunk() {
		newSub1.placeShipAt(8,8, true, newOcean);
		newOcean.shootAt(8,8);
		assertEquals(newOcean.getShipsSunk(),1);
		
	}

	// we are testing to see that the game ends when 10 ships are sunk
	@Test
	void testIsGameOver() {
		newOcean.shipsSunk = 10;
		assertEquals(newOcean.isGameOver(), true);
	}
	
	// we are testing to see that the game is not over prematurely
	@Test
	void testIsGameOverNo() {
		newOcean.shipsSunk = 9;
		assertEquals(newOcean.isGameOver(), false);
	}

	// we are testing that when we place 2 ships, that getShipArray() returns what ship is in which position
	@Test
	void testGetShipArray() {
		Ship[][] shipTest = arrayNewOcean.getShipArray();
		newCruiser2.placeShipAt(3, 4, true, arrayNewOcean);
		newSub4.placeShipAt(9, 9, false, arrayNewOcean);
		assertEquals("empty", shipTest[0][0].getShipType());
		assertEquals("cruiser", shipTest[3][5].getShipType());
		assertEquals("submarine", shipTest[9][9].getShipType());
		
	}

}
