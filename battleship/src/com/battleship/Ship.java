package com.battleship;

/**
 * Ship class provides utility method for a ship
 */
public class Ship {


    int bowRow;
    int bowColumn;
    int length;
    boolean horizontal = false;
    boolean [] hit;

    /**
     * This method is to return row number of the ship
     * @return int row number
     */
    int getBowRow() {
        return bowRow;
    }

    /**
     * This method is to return column number of the ship
     * @return int column number
     */
    int getBowColumn() {
        return bowColumn;
    }

    /**
     * This method is to return the format output for the ship for visual display. To be overridden by ship type.
     * @param row
     * @param column
     * @return String
     */
    public String toString(int row, int column){
        return " ";
    }

    String getShipType() {
        return " ";
    };

    /**
     * This method checks if it is ok the place the ship on a particular position
     * @param row Row position
     * @param column Column position
     * @param horizontal Ship orientation
     * @param ocean Ocean map
     * @return boolean
     */
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

    /**
     * This method places the ship on the map
     * @param row Row number
     * @param column Column number
     * @param horizontal Ship orientation
     * @param ocean Ocean map
     */
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

    /**
     * This method checks if the ship is sunk
     * @return boolean
     */
    boolean isSunk(){

        for (int i=0; i<hit.length; ++i){
            if (!hit[i]){
                return  false;
            }
        }
        return true;
    }

    /**
     * This method does the action of shooting the target
     * @param row Row number
     * @param column Column number
     * @return boolean
     */
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
