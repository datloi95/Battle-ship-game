package com.battleship;

import java.util.Random;
import java.util.*;
import java.util.Arrays;

public class Ocean {

    Ship[][] ships = new Ship[10][10];
    final int NUMSHIP = 4;
    int shotsFired;
    int hitCount;
    int shipsSunk;
    ArrayList<Ship> shipList = new ArrayList<>();

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

    boolean isOccupied(int row, int column) {

        if (ships[row][column] instanceof EmptySea) {
            return false;
        }
        return true;
    }

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

    int getShotsFired() {

        return shotsFired;
    }

    int getHitCount() {

        return hitCount;
    }

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

    boolean isGameOver() {

        for (int i=0; i<shipList.size(); ++i){
            if (!shipList.get(i).isSunk()){
                return false;
            }
        }
        return true;
    }

    Ship[][] getShipArray() {
        return ships;
    }

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
