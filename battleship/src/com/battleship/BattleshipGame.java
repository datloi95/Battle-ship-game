package com.battleship;

public class BattleshipGame {

    public static void main(String[] args) {
	// write your code here
        BattleshipGame game = new BattleshipGame();
        game.playGame();
    }

    void playGame(){
        // Initialize the computer ocean
        Ocean ComputerOcean = new Ocean();
        ComputerOcean.placeAllShipsRandomly();
        ComputerOcean.print();
        // Initialize human ocean
        //Ocean humanOcean = new Ocean();

    }
}
