package com.battleship;
import java.util.Scanner;

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

        Scanner userRow = new Scanner(System.in);
        Scanner userCol = new Scanner(System.in);

        while (!ComputerOcean.isGameOver()){

            System.out.println("Input row number: ");
            int row = userRow.nextInt();
            System.out.println("Input column number: ");
            int column = userCol.nextInt();
            System.out.println("Shoot at row " + row + " and column " + column + " ");
            ComputerOcean.shootAt(row,column);
            ComputerOcean.print();
            if(ComputerOcean.isGameOver()){
                break;
            }
        }
        System.out.println(("Game Over!!!"));
        // Initialize human ocean
        //Ocean humanOcean = new Ocean();

    }
}
