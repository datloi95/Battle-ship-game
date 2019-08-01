package com.battleship;

public class Cruiser extends Ship {

    public Cruiser(){
        super();
        length = 3;
    }

    @Override
    String getShipType(){
        return "cruiser";
    }

    @Override
    public String toString(){
        if (isSunk()){
            return "X";
        }
        return "S";
    }
}
