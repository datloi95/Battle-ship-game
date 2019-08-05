package com.battleship;

public class EmptySea extends Ship {

    String status;
    EmptySea() {
        super();
        length = 1;
        hit = new boolean[length];
        status = "Unknown";
    }

    @Override
    boolean shootAt(int row, int column) {
        return false;
    }

    @Override
    boolean isSunk() {
        return false;
    }

    @Override
    public String toString() {
        return " ";
    }
}
