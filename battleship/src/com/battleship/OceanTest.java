package com.battleship;

import junit.framework.TestCase;

public class OceanTest extends TestCase {

    Ocean oceanTest = new Ocean();

    public void testPlaceAllShipsRandomly() {
        oceanTest.placeAllShipsRandomly();
        oceanTest.print();
    }

    public void testIsOccupied() {
        testPlaceAllShipsRandomly();
        assertFalse(oceanTest.isOccupied(0,0));
    }

    public void testShootAt() {
        testPlaceAllShipsRandomly();
        assertFalse(oceanTest.shootAt(1,0));
    }

    public void testGetShotsFired() {
        testPlaceAllShipsRandomly();
        oceanTest.shootAt(0,0);
        assertEquals(1,oceanTest.getShotsFired());
    }

    public void testGetHitCount() {
        testPlaceAllShipsRandomly();
        oceanTest.shootAt(0,0);
        assertEquals(0,oceanTest.getHitCount());
    }

    public void testGetShipsSunk() {
        testPlaceAllShipsRandomly();
        oceanTest.shootAt(0,0);
        assertEquals(0,oceanTest.getShipsSunk());
    }

    public void testIsGameOver() {
        testPlaceAllShipsRandomly();
        assertFalse(oceanTest.isGameOver());
    }

    public void testGetShipArray() {
        testPlaceAllShipsRandomly();
        assertEquals(oceanTest.ships, oceanTest.getShipArray());
    }

}