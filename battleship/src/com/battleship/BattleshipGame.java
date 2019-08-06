package com.battleship;
import java.util.*;

/**
 * The BattleshipGame program implements a battleship game
 * with computer AI.
 *
 * @author  Dat Loi
 * @since   2019-08-06
 */
public class BattleshipGame {

    public static void main(String[] args) {
	// write your code here
        BattleshipGame game = new BattleshipGame();
        game.playGame();
    }

    /**
     * This method will drive the battleship game with computer
     */
    void playGame(){
        // Initialize the Computer ocean and its input
        Ocean ComputerOcean = new Ocean();
        ComputerOcean.placeAllShipsRandomly();
//        System.out.println("%%%%%%%%% Computer Board %%%%%%%%%%");
//        ComputerOcean.print();

        Scanner userRow = new Scanner(System.in);
        Scanner userCol = new Scanner(System.in);

        //Initialize human ocean
        Ocean HumanOcean = new Ocean();
        HumanOcean.placeAllShipsRandomly();
        System.out.println("\n%%%%%%%%% Human Board %%%%%%%%%%");
        HumanOcean.print();

        //Initialize Computer AI
        ComputerAI computerAI = new ComputerAI();

        String computerMode = "Hunt";
        int humanShipSunk = HumanOcean.getShipsSunk();
        while (!ComputerOcean.isGameOver()){

            try{

                // Human play
                System.out.println("Input row number: ");
                int row = userRow.nextInt();
                System.out.println("Input column number: ");
                int column = userCol.nextInt();

                if(row > 9 || row < 0 || column > 9 || column < 0){
                    System.out.println("Invalid row or column number. Try again.");
                    continue;
                }
                System.out.println("Shoot at row " + row + " and column " + column + " ");
                if (ComputerOcean.shootAt(row,column)){
                    System.out.println("HIT");
                } else{
                    System.out.println(("MISSED"));
                }


                // Computer play
                int computerCoordiates[] = computerAI.shootCoordinate();

                System.out.println("Computer Play turn. Row: "+ computerCoordiates[0] + ".Column: "+ computerCoordiates[1]);
                if (HumanOcean.shootAt(computerCoordiates[0],computerCoordiates[1])){
                    System.out.println("HIT");
                    if (computerMode == "Hunt"){
                        computerMode = "Target";
                        computerAI.computerMode = computerMode;
                        computerAI.changeMode(HumanOcean.getShipsSunk(), HumanOcean.getHitCount(), HumanOcean.getShotsFired(), computerCoordiates);
                    }
                    if(humanShipSunk != HumanOcean.getShipsSunk()){
                        humanShipSunk = HumanOcean.getShipsSunk();
                        computerMode = "Hunt";
                        computerAI.computerMode = computerMode;
                    }
                } else{
                    System.out.println(("MISSED"));

                }

//                System.out.println("%%%%%%%%% Computer Board %%%%%%%%%%");
//                ComputerOcean.print();
                System.out.println("\n%%%%%%%%% Human Board %%%%%%%%%%");
                HumanOcean.print();

                if(ComputerOcean.isGameOver() || HumanOcean.isGameOver()){
                    break;
                }

            }
            catch (InputMismatchException e){
                System.out.println("Input must be number. Try again!");
                userRow.next();
                userCol.next();
            }

        }
        System.out.println(("Game Over!!!"));


    }
}
