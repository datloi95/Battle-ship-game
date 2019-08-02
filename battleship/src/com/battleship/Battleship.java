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

        Battleship battleship = new Battleship();
        for (int i=0; i<length; ++i) {
            ocean.ships[row][column] = battleship;
            if (horizontal){
                row += 1;
            }
            else {
                column += 1;
            }
        }
    }
}
