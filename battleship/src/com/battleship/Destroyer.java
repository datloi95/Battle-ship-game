package com.battleship;

import sun.security.krb5.internal.crypto.Des;

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

        Destroyer destroyer = new Destroyer();
        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = destroyer;
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }
}
