package com.battleship;

import java.util.*;

public class ComputerAI {

    String mode;
    Ship[][] ships = new Ship[10][10];

    ArrayList<Integer> shipLength = new ArrayList<>();

    ComputerAI(){
        shipLength.add(5);
        shipLength.add(4);
        shipLength.add(3);
        shipLength.add(2);

        for (int i = 0; i < 10; ++i) {
            for (int j =0; j<10; ++j) {
                ships[i][j] = new EmptySea();
            }
        }
    }



}
