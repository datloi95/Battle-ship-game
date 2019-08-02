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
            return "S";
        }
        return "X";
    }

    @Override
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        Cruiser cruiser = new Cruiser();
        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = cruiser;
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }
}
