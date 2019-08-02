package com.battleship;




public class Ship {


    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = false;
    boolean [] hit;

    int getBowRow() {
        return bowRow;
    }

    int getBowColumn() {
        return bowColumn;
    }


    public String toString(int row, int column){
        return " ";
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
                column += 1;
            }
            else {
                row += 1;
            }
        }
        return true;
    }

    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        this.bowColumn = column;
        this.bowRow = row;
        this.horizontal = horizontal;

        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = new Ship();
            if (horizontal){
                column += 1;
            }
            else {
                row += 1;
            }
        }
    }

    boolean isSunk(){

        for (int i=0; i<hit.length; ++i){
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
            return true;
        }
        return false;

    }

}
