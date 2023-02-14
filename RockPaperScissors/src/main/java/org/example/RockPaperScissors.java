package org.example;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    /**
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        //declare variables of the number of wins, losses and ties
        //And the choice of Item the user and computer uses
        int userWins = 0, computerWins = 0, ties = 0;
        int userItem, computerItem;

        //Variable to see if the user wants to play again
        boolean repeatGame;


        /**
         * change to an array
         * and ask about constants
         */

        //declare the constant of the min and max # of rounds
        int MIN_ROUNDS = 1;
        int MAX_ROUNDS = 10;

        //declare and initialise a Scanner object
        //to read console inputs
        Scanner myScanner = new Scanner(System.in);

        //declare and initialise a Random number generater
        //to choose a random item to play
        Random rng = new Random();

        //welcome message
        System.out.println("_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_");
        System.out.println("Rock Paper Scissors\n");
       // System.out.println("_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");

        /**
         * repeat zone, do a loop from here
         * and state variebels to zero here maybe?
         */


        //prompt user for the number of rounds they want to play
        System.out.println("How Many Rounds do you want to Play: ");
        //Scans input as the total number of Rounds
        int totalRounds = myScanner.nextInt();

        //tests to see if the number of rounds are outside the given range
        if ((totalRounds<MIN_ROUNDS) | (totalRounds>MAX_ROUNDS)) {
            System.out.println("ERROR Input Outside of Range");

            /**
             * create an end condition
             */
        }
        /**
         * maybe do an else statement
         */


        //Creates a for loop for each round of the game
        //with roundCount as the round Counter
        for(int roundCount=0; roundCount<totalRounds; roundCount++) {

            //prompt User to choose an item 0:Rock, 1:Paper or 2:Scissors
            System.out.println("Choose an Item, either: Rock(1), Paper(2) or Scissors(3)");
            //Scans input as the User's item
            userItem = myScanner.nextInt()-1;

            //Generate a random number to determine the computer's Item
            computerItem = rng.nextInt(3);

            /**
             *do a function to show what the computer playes maybe? ask about it
             */

            //The if statements determines if the user wins, losses or ties
            //showing a message for each case and tracking it
            if (userItem == computerItem) {
                //The user ties with the computer
                System.out.println("Tie");
                //records the tie to the totals
                ties = ties+1;

            } else if (((userItem+1)%3)==computerItem) {
                //The computer wins
                System.out.println("The Computer Wins");
                //records the loss to the totals
                computerWins++;

            }else if (((computerItem+1)%3)==userItem){
                // The user wins
                System.out.println("You Win!!!");
                //records the win to the totals
                userWins++;

            }
        }


        //The last round has finished
        //so the running totals of the wins, losses and ties are shown
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");
        System.out.println("The final scores are:");
        System.out.println (ties + " rounds tied");
        System.out.println("The Computer Won "+ computerWins + " rounds");
        System.out.println("You Won "+ userWins + " rounds\n");
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");


        //To declare an overall winner
        if (userWins == computerWins){
            //The user and computer got the same amount of wins
            System.out.println("It's a Draw, Both You and the Computer won the same amount of rounds");

        } else if (userWins < computerWins) {
            //The computer is the winner
            System.out.println("Sorry, The Computer is the Overall Winner");

        } else if (userWins > computerWins) {
            //The user is the winner
            System.out.println("Well Done, You are the Overall Winner!!!!!!");
        }

        //closing pattern
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");



    }
}