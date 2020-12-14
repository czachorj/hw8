import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OceanTest {
	
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

	@Test
	void testShootAt() {
		newCruiser1.placeShipAt(4, 3, false, newOcean);
		assertEquals(newOcean.shootAt(5, 3),true);
		assertEquals(newOcean.shootAt(3,3), false);
	}

	@Test
	void testGetShotsFired() {
		newOcean.shootAt(4, 6);
		newOcean.shootAt(7, 0);
		assertEquals(newOcean.getShotsFired(),2);
	}

	@Test
	void testGetHitCount() {
		newCruiser1.placeShipAt(2, 3, true, newOcean);
		newOcean.shootAt(2, 4);
		assertEquals(newOcean.getHitCount(),1);
		
	}
//
	@Test
	void testGetMissCount() {		
		newCruiser1.placeShipAt(2, 3, true, newOcean);
		newOcean.shootAt(2, 6);
		assertEquals(newOcean.getMissCount(),1);
	}
//
//	@Test
//	void testGetShipsSunk() {
//		newSub1.placeShipAt(1,0, true, newOcean);
//		newOcean.shootAt(1, 0);
//		assertEquals(newOcean.getShipsSunk(),1);
//		
//	}
//
//	@Test
//	void testIsGameOver() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetShipArray() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testPrint() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testTestPrint() {
//		fail("Not yet implemented");
//	}

}
