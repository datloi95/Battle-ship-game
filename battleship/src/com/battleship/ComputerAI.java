package com.battleship;

import java.util.*;

/**
 * This class provides utility methods for computer AI
 */
public class ComputerAI {

    String mode;
    private Ship[][] ships = new Ship[10][10];

    private ArrayList<Integer> shipLength = new ArrayList<>();
    private Stack<int[]> possibleHits = new Stack<int[]>();
    String computerMode = "Hunt";
    int pointShot;
    int pointHit;

    ComputerAI(){
        shipLength.add(5);
        shipLength.add(4);
        shipLength.add(3);
        shipLength.add(2);

        for (int i = 0; i < 10; ++i) {
            for (int j =0; j<10; ++j) {
                ships[i][j] = new EmptySea();
            }
        }
    }

    void play(Ocean humanOcean){

        int opponentShipSunk = humanOcean.getShipsSunk();

    }

    void changeMode(int humanShipSunk, int humanHitCount, int humanShotFired, int[] prevCoordinate){

        int row = prevCoordinate[0];
        int col = prevCoordinate[1];

        for (int i=1; i <= 5; i++) {
            if ((col - i) >= 0 && (col - i) < 10) {
                int[] point1 = {row, col - i};
                possibleHits.push(point1);
            }
            if ((col + i) >= 0 && (col + i) < 10) {
                int[] point2 = {row, col + i};
                possibleHits.push(point2);
            }
            if ((row - i) >= 0 && (row - i) < 10) {
                int[] point3 = {row - i, col};
                possibleHits.push(point3);
            }
            if ((row + i) >= 0 && (row + i) < 10) {
                int[] point4 = {row + i, col};
                possibleHits.push(point4);
            }
        }
    }

    int[] shootCoordinate(){
        Random rand = new Random();
        System.out.println("Computer mode: " + computerMode);
        if(computerMode == "Target"){
            if (!possibleHits.empty()){
                return possibleHits.pop();
            }
        }

        int row = rand.nextInt(10);
        int col = rand.nextInt(10);
        int coordinate[] = {row, col};
        return coordinate;
    }
}
