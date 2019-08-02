package com.battleship;

public class Cruiser extends Ship {

    public Cruiser(){
        super();
        length = 3;
        hit = new boolean[length];
    }

    @Override
    String getShipType(){
        return "cruiser";
    }

    @Override
    public String toString(int row, int column){

        int index;
        if (horizontal){
            index = column - this.bowColumn;
        }
        else{
            index = row - this.bowRow;
        }
        if (hit[index]){
            return "S";
        }
        else{
            return "C";
        }
    }

    @Override
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        this.bowColumn = column;
        this.bowRow = row;
        this.horizontal = horizontal;
        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = this;
            if (horizontal){
                column += 1;
            }
            else {
                row += 1;
            }
        }
    }
}
