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
            return "S";
        }
        return "X";
    }

    @Override
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = new Submarine();
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }

}
