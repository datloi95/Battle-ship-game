package com.company;

public class Location {

    int row, col;
    String shipType;
    

    public Location(int x , int y, String shipType) {
        this.row = x;
        this.col = y;
        this.shipType = shipType;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    public String getShipType() {
        return this.shipType;
    }


}
