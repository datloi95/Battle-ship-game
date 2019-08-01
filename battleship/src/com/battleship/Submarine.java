package com.battleship;

public class Submarine extends Ship {

    public Submarine(){
        super();
        length = 3;
    }

    @Override
    String getShipType(){
        return "submarine";
    }

    @Override
    public String toString(){
        if (isSunk()){
            return "X";
        }
        return "S";
    }

}
