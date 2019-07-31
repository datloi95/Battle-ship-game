package com.company;

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


        int[] sizes = {5,4,3,3,2}

        for (int i=0; i<NUMSHIP; i++) {
            // Obtain a number between [0 - 9].
            while(true) {
                int row = rand.nextInt(10);
                int col = rand.nextInt(10);

                if (ships[row][col] instanceof EmptySea) {
                    String shipType;
                    Ship ship;
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
                            shipType = "Submarine";
                            ship = new Submarine();
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


                }
            }
        }

    }

    boolean isOccupied(int row, int column) {

    }

    boolean shootAt(int row, int column) {

    }

    int getShotsFired() {

    }

    int getHitCount() {

    }

    int getShipsSunk() {

    }

    boolean isGameOver() {

    }

    Ship[][] getShipArray() {

    }

    void print() {

    }




}
