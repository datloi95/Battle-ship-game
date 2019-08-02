package com.battleship;

public class AircraftCarrier extends Ship {

    public AircraftCarrier(){
        super();
        length = 5;
    }

    @Override
    String getShipType(){
        return "aircraftcarrier";
    }

    @Override
    public String toString(){
        if (isSunk()){
            return "S";
        }
        return "X";
    }

    @Override
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        AircraftCarrier aircraftCarrier = new AircraftCarrier();
        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = aircraftCarrier;
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }
}

