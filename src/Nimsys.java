/*********************************************************************
 *  Description:  This algorithm is created for Nim game             *
 *                                                                   *
 *  Written:      22/03/2019                                         *
 *  Update:       01/04/2019                                         *
 *                                                                   *
 ********************************************************************/

import java.util.Scanner;

public class Nimsys {
    
    public static void main(String [] args){
        
        Scanner keyboard = new Scanner(System.in);
        NimPlayer NimPlayer1, NimPlayer2;

        System.out.println("Welcome to Nim\n");
        System.out.println("Please enter Player 1's name:");
        NimPlayer1 = new NimPlayer(keyboard.next());

        System.out.println("\nPlease enter Player 2's name:");
        NimPlayer2 = new NimPlayer(keyboard.next());
        System.out.println("");
        
        //Game's flow control.
        game(NimPlayer1, NimPlayer2, keyboard);       
    }
    
    public static void game(NimPlayer NimPlayer1, NimPlayer NimPlayer2, 
                                                 Scanner keyboard){   
        /*
        Variables
            playerTurn: Current player who pick stones.
            removeBound: Upper bound of removing stones.
            remainStone: How many stones are left.
        */
        
        NimPlayer playerTurn;
        int removeBound, remainStone;
        
        //The first while loop control whether or not to continue playing.
        while(true){
            System.out.println("Please enter upper bound of stone removal:");
            removeBound = keyboard.nextInt();

            System.out.println("\nPlease enter initial number of stones:");
            remainStone = keyboard.nextInt();

            //Initialize first player.
            playerTurn = NimPlayer1; 

            //The second while loop control whether or not this turn is finish.
            while(0 < remainStone){
                System.out.printf("\n%d stones left:", remainStone);
                
                //Display stones quatity.
                for(int i = 0; i < remainStone; i++){
                    System.out.print(" *");
                }

                System.out.printf("\n%s's turn - remove how many?\n", playerTurn.getPlayer());

                //Calculate how many stones are left.
                remainStone = remainStone - playerTurn.removeStone(keyboard); 

                //Change next turn player.
                playerTurn = (playerTurn.equals(NimPlayer1)) ? NimPlayer2 : NimPlayer1;
            }

            System.out.printf("\nGame Over\n%s wins!\n\n", playerTurn.getPlayer());
            System.out.println("Do you want to play again (Y/N):");

            //If player types any input apart from 'Y' then stop the game.
            if(!keyboard.next().equals("Y")){
                break;
            }
        }
    }
}