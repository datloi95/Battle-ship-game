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
            return "X";
        }
        return "S";
    }
}
