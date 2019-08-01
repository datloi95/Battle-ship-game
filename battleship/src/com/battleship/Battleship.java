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
