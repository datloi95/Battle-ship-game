package com.battleship;
import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {
	// write your code here
        BattleshipGame game = new BattleshipGame();
        game.playGame();
    }

    void playGame(){
        // Initialize the Computer ocean and its input
        Ocean ComputerOcean = new Ocean();
        ComputerOcean.placeAllShipsRandomly();
        System.out.println("%%%%%%%%% Computer Board %%%%%%%%%%");
        ComputerOcean.print();

        Scanner userRow = new Scanner(System.in);
        Scanner userCol = new Scanner(System.in);

        //Initialize human ocean
        Ocean HumanOcean = new Ocean();
        HumanOcean.placeAllShipsRandomly();
        System.out.println("\n%%%%%%%%% Human Board %%%%%%%%%%");
        HumanOcean.print();

        while (!ComputerOcean.isGameOver()){

            System.out.println("Input row number: ");
            int row = userRow.nextInt();
            System.out.println("Input column number: ");
            int column = userCol.nextInt();
            System.out.println("Shoot at row " + row + " and column " + column + " ");
            if (ComputerOcean.shootAt(row,column)){
                System.out.println("HIT");
            } else{
                System.out.println(("MISSED"));
            };
            ComputerOcean.print();
            if(ComputerOcean.isGameOver()){
                break;
            }
        }
        System.out.println(("Game Over!!!"));


    }
}
