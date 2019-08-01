package com.battleship;

public class Battleship extends Ship {

    public Battleship(){
        super();
        length = 4;
    }

    @Override
    String getShipType(){
        return "battleship";
    }

    @Override
    public String toString(){
        if (isSunk()){
            return "X";
        }
        return "S";
    }
}
