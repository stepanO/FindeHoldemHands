package Home;

import static org.junit.Assert.*;
import Home.*;
import org.junit.Test;

public class testDefinition {
	
	Map[] mapFlash = new Map[]{new Map(0,1),
			new Map(8,1),
			new Map(2,1),
			new Map(3,1),
			new Map(1,1)};
	Map[] mapStreet = new Map[]{new Map(0,0),
			new Map(1,0),
			new Map(2,2),
			new Map(3,2),
			new Map(4,3)};
	Map[] mapKare = new Map[]{new Map(1,0),
			new Map(1,1),
			new Map(1,2),
			new Map(1,3),
			new Map(4,3)};
	Map[] mapFullHouse = new Map[]{new Map(1,0),
			new Map(1,0),
			new Map(1,2),
			new Map(3,2),
			new Map(3,3)};
	Map[] mapStreetFlash = new Map[]{new Map(1,0),
			new Map(2,0),
			new Map(3,0),
			new Map(4,0),
			new Map(5,0)};
	Map[] mapFlashRoyal = new Map[]{new Map(0,0),
			new Map(1,0),
			new Map(2,0),
			new Map(3,0),
			new Map(4,0)};
	Map[] mapPair = new Map[]{new Map(4,0),
			new Map(4,1),
			new Map(2,0),
			new Map(3,2),
			new Map(8,0)};
	Map[] mapSet = new Map[]{new Map(4,0),
			new Map(4,1),
			new Map(4,2),
			new Map(3,3),
			new Map(6,2)};
	Map[] mapSenior = new Map[]{new Map(1,2),
			new Map(4,1),
			new Map(6,2),
			new Map(9,3),
			new Map(10,2)};
	
	@Test
	public void testFindCombination() {
//		assertEquals(Definition.findCombination(mapFlash), "Флеш");
//		assertEquals(Definition.findCombination(mapStreet), "Стрит");
//		assertEquals(Definition.mapIsFlash(mapFlash), true);
		
	}
	@Test
	public void testMapIsStreet() {
		assertEquals(Definition.mapIsStreet(mapStreet), true);
		assertEquals(Definition.mapIsStreet(mapKare), false);
		assertEquals(Definition.mapIsStreet(mapFullHouse), false);
		assertEquals(Definition.mapIsStreet(mapFlashRoyal), true);
		assertEquals(Definition.mapIsStreet(mapFlash), false);
		assertEquals(Definition.mapIsStreet(mapPair), false);
		assertEquals(Definition.mapIsStreet(mapSet), false);
	}
	
	@Test
	public void testMapIsFlash() {
		assertEquals(Definition.mapIsFlash(mapStreet), false);
		assertEquals(Definition.mapIsFlash(mapKare), false);
		assertEquals(Definition.mapIsFlash(mapFullHouse), false);
		assertEquals(Definition.mapIsFlash(mapFlashRoyal), true);
		assertEquals(Definition.mapIsFlash(mapFlash), true);
		assertEquals(Definition.mapIsFlash(mapPair), false);
		assertEquals(Definition.mapIsFlash(mapSet), false);
	}
	
	@Test
	public void testMapIsPairSetKare() {
		assertEquals(Definition.mapIsPairSetKare(mapStreet)[0], 0);
		assertEquals(Definition.mapIsPairSetKare(mapStreet)[1], 0);
		assertEquals(Definition.mapIsPairSetKare(mapKare)[0], 4);
		assertEquals(Definition.mapIsPairSetKare(mapKare)[1], 1);
		assertEquals(Definition.mapIsPairSetKare(mapFullHouse)[0], 3);
		assertEquals(Definition.mapIsPairSetKare(mapFullHouse)[1], 2);
		assertEquals(Definition.mapIsPairSetKare(mapFlashRoyal)[0], 4);
		assertEquals(Definition.mapIsPairSetKare(mapFlashRoyal)[1], 1);
		assertEquals(Definition.mapIsPairSetKare(mapFlash)[0], 4);
		assertEquals(Definition.mapIsPairSetKare(mapFlash)[1], 1);
		assertEquals(Definition.mapIsPairSetKare(mapPair)[0], 4);
		assertEquals(Definition.mapIsPairSetKare(mapPair)[1], 1);
		assertEquals(Definition.mapIsPairSetKare(mapSet)[0], 4);
		assertEquals(Definition.mapIsPairSetKare(mapSet)[1], 1);
	}

}
