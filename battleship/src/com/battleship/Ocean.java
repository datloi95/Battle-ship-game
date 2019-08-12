package com.battleship;

import java.util.Random;
import java.util.*;

/**
 * Ocean class will generate a map with randomized ships for both human and computer
 */
public class Ocean {

    Ship[][] ships = new Ship[10][10];
    final int NUMSHIP = 4;
    private int shotsFired;
    private int hitCount;
    private int shipsSunk;
    private ArrayList<Ship> shipList = new ArrayList<>();

    Ocean() {
        shotsFired = 0;
        hitCount = 0;
        shipsSunk = 0;

        for (int i = 0; i < 10; ++i) {
            for (int j =0; j<10; ++j) {
                ships[i][j] = new EmptySea();
            }
        }


    }

    /**
     * Place all the ship randomly on the 10x10 map
     */
    void placeAllShipsRandomly() {

        Random rand = new Random();


        int[] sizes = {5,4,3,2};

        for (int i=0; i<NUMSHIP; i++) {

            while(true) {
                // Obtain a number between [0 - 9].
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);
                boolean horizontal = rand.nextBoolean();

                if (ships[row][col] instanceof EmptySea) {
                    String shipType;
                    Ship ship = null;
                    switch (sizes[i]){
                        case 5:
                            shipType = "Aircraft Carrier";
                            ship = new AircraftCarrier();
                            break;
                        case 4:
                            shipType = "Battleship";
                            ship = new Battleship();
                            break;
                        case 3:
                            shipType = "Cruiser";
                            ship = new Cruiser();
                            break;
                        case 2:
                            shipType = "Destroyer";
                            ship = new Destroyer();
                            break;
                    }
                    if (ship.okToPlaceShipAt(row, col, horizontal, this)) {
                        ship.placeShipAt(row, col, horizontal, this);
                        shipList.add(ship);
                        break;
                    }


                }
            }
        }

    }

    /**
     * Check if the target grid is occupied
     * @param row Row number
     * @param column Column number
     * @return boolean This returns whether the grid is occupied or not
     */
    boolean isOccupied(int row, int column) {

        if (ships[row][column] instanceof EmptySea) {
            return false;
        }
        return true;
    }

    /**
     *
     * @param row Row number
     * @param column Column number
     * @return boolean This returns whether the target shot is a hit or not
     */
    boolean shootAt(int row, int column) {

        shotsFired++;
        if (isOccupied(row, column)) {
            if (ships[row][column].shootAt(row, column)){
                hitCount++;
                return true;
            }
        }

        return false;
    }

    /**
     * This method returns the number of shots already fired
     * @return int number of shots fired
     */
    int getShotsFired() {

        return shotsFired;
    }

    /**
     * This method returns the number of hit
     * @return int number of hits
     */
    int getHitCount() {

        return hitCount;
    }

    /**
     * This method returns the number of ships sunk of the player
     * @return int num
     */
    int getShipsSunk() {
        int localShipSunk = 0;
        for(int i=0; i<shipList.size(); ++i){
            if (shipList.get(i).isSunk()){
                localShipSunk++;
            }
        }
        shipsSunk = localShipSunk;
        return shipsSunk;
    }

    /**
     * This medthod is to check if the game ends
     * @return boolean check if the game ends
     */
    boolean isGameOver() {

        for (int i=0; i<shipList.size(); ++i){
            if (!shipList.get(i).isSunk()){
                return false;
            }
        }
        return true;
    }

    /**
     * This method is to return ships array from ocean map
     * @return Ship[][] return ship array
     */
    Ship[][] getShipArray() {
        return ships;
    }

    /**
     * This method is to print out the player's map for visual display
     */
    void print() {

        for(int i=0; i<11; i++) {
            for(int j=0; j<11; j++) {
                if (i==0 && j==0){
                    System.out.print("  ");
                    continue;
                }
                if (i==0){
                    System.out.print((j-1) + " ");
                }
                else if (j==0){
                    System.out.print((i-1) + " ");
                }
                else {
                    System.out.print(ships[i-1][j-1].toString((i-1), (j-1))+ " ");
                }
            }
            System.out.println();
        }

//        for (int i = 0; i < shipList.size(); i++) {
//            System.out.println(Arrays.toString(shipList.get(i).hit));
//            System.out.println("Sunk state: " + shipList.get(i).isSunk());
//        }
    }
}
