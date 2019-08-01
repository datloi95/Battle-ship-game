package com.battleship;

import java.util.Random;

public class Ocean {

    Ship[][] ships = new Ship[10][10];
    final int NUMSHIP = 5;
    int shotsFired;
    int hitCount;
    int shipsSunk;

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


        int[] sizes = {5,4,3,3,2};

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
                        break;
                    }


                }
            }
        }

    }

//    boolean isOccupied(int row, int column) {
//
//    }
//
//    boolean shootAt(int row, int column) {
//
//    }

//    int getShotsFired() {
//
//    }
//
//    int getHitCount() {
//
//    }
//
//    int getShipsSunk() {
//
//    }
//
//    boolean isGameOver() {
//
//    }
//
//    Ship[][] getShipArray() {
//
//    }

    void print() {

        for(int i=0; i<10; i++) {
            for(int j=0; j<10; j++) {
                if (i==0){
                    System.out.print(j + " ");
                }
                else if (j==0){
                    System.out.print(i + " ");
                }
                else {
                    System.out.print(ships[i][j].toString()+ " ");
                }
            }
            System.out.println();
        }
    }
}
