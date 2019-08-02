package com.battleship;




public class Ship {


    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = false;
    boolean [] hit = new boolean[4];;

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

        bowColumn = column;
        bowRow = row;
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

        for (int i=0; i<length; ++i){
            if (!hit[i]){
                return  false;
            }
        }
        return true;
    }


    boolean shootAt(int row, int column){

        int index;
        if (horizontal){
            index = column - bowColumn;
        }
        else{
            index = row - bowRow;
        }
        if (!hit[index]){
            hit[index] = true;
            int a = 3;
            return true;
        }
        return false;
    }

}
