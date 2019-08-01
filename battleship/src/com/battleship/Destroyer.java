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
            return "S";
        }
        return "X";
    }

    @Override
    void placeShipAt(int row, int column, boolean horizontal, Ocean ocean) {

        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = new Destroyer();
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }
}
