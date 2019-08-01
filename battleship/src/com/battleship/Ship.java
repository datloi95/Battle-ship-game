package com.battleship;

//import java.util.*;


public class Ship {

    //ArrayList<Location> ship = new ArrayList<>();

    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = false;

    int getBowRow() {
        return bowRow;
    }

    int getBowColumn() {
        return bowColumn;
    }


    String getShipType() {
        return " ";
    };

    boolean okToPlaceShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        for (int i=0; i<length; ++i){

            if (row > 9 || column > 9){
                return false;
            }
            if (!(ocean.ships[row][column] instanceof EmptySea)) {
                return false;
            }
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
        return true;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = new Ship();
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }


   boolean isSunk(){

        return false;
    }


    boolean shootAt(int row, int column){

        return false;
    }


}
