package com.battleship;

public class AircraftCarrier extends Ship {

    public AircraftCarrier(){
        super();
        length = 5;
        hit = new boolean[length];
    }

    @Override
    String getShipType(){
        return "aircraftcarrier";
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
            return "A";
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

