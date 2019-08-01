package com.battleship;

public class Destroyer extends Ship {

    public Destroyer(){
        super();
        length = 2;
    }

    @Override
    String getShipType(){
        return "destroyer";
    }

    @Override
    public String toString(){
        if (isSunk()){
            return "X";
        }
        return "S";
    }
}
