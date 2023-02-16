package org.example;

import java.util.Scanner;
import java.util.Random;

import static java.lang.System.exit;

public class RockPaperScissors {

    /**Variable to see if the user wants to play again*/
    public static boolean repeatGame;

    /**declare and initialise a Scanner object to read console inputs*/
    public static Scanner myScanner = new Scanner(System.in);

    /**declare and initialise a Random number generator */
    public static Random rng = new Random();



    public static void main(String[] args) {
        //welcome message
        System.out.println("_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");
        System.out.println("Rock Paper Scissors");

        do{
            //Asks the user for the amount of rounds they want to play
            int totalRounds = rounds();

            //plays a full game and returns an array of scores
            int[] results = fullGame(totalRounds);

            //The last round has finished
            declareWinner(results);

            //Asks the user if they want to play again
            playAgain();

        }while(repeatGame);

    }


    /**
     * Asks the user for the amount of rounds they want to play
     * if user chooses outside the range, an error message is printed
     * and the program quits
     * @return the number of rounds the user wants to play
     */
    public static int rounds(){
        //CONSTANTS of the min and max # of rounds
        final int MIN_ROUNDS = 1;
        final int MAX_ROUNDS = 10;

        //prompt user for the number of rounds they want to play
        System.out.println("\n_,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_");
        System.out.println("\nHow Many Rounds do you want to Play: ");
        //Scans input as the total number of Rounds
        int totalRounds = myScanner.nextInt();

        //tests to see if the number of rounds are outside the given range
        if ((totalRounds<MIN_ROUNDS) | (totalRounds>MAX_ROUNDS)) {
            System.out.println("ERROR Input Outside of Range");
            exit(0);
        }

        return totalRounds;
    }


    /**
     * Plays one whole game with an amount of rounds chosen by the user,
     *then returns the total results
     * @param totalRounds the amount of rounds the user wants to play
     * @return  total result after the whole game {ties, computer wins, user wins,}
     */
    public static int[] fullGame(int totalRounds){
        //An empty array to hold the running total of scores
        // {ties, computer wins, user wins,}
        int[] scores ={0,0,0};

        //Variables of the choice of Item the user and computer uses
        int userChoice, computerChoice;

        //Creates a for loop for each round of the game
        //with roundCount as the round Counter
        for(int roundCount=0; roundCount<totalRounds; roundCount++) {

            //prompt User to choose an item 1:Rock, 2:Paper or 3:Scissors
            //the -1 is for calculating who wins
            System.out.println("\nChoose an Item, either: Rock(1), Paper(2) or Scissors(3)");
            //Scans input as the User's item
            userChoice = myScanner.nextInt()-1;

            //Generate a random number to determine the computer's Item
            computerChoice = rng.nextInt(3);

            //Plays one round and records the result to the running total of scores
            oneRound(scores,userChoice,computerChoice);
        }

        return scores;
    }


    /**
     * Determines the result of one round, shows the result and tracks it
     * in a running total
     * Someone wins if their item is 1 greater than their opponent's item
     * eg: paper(1) beats rock(0)
     * % is used to wrap rock around to be greater than scissors
     * @param scores int[3] the results running total for the whole game {ties, computer wins, user wins,}
     * @param userItem the item the user chooses (0-2 range)
     * @param computerItem the item the computer chooses (0-2 range)
     * @return  returns the total result after this round
     */
    public static int[] oneRound(int[] scores, int userItem, int computerItem){
        //Someone wins if their item is 1 greater than their opponent's item
        //eg: paper(1) beats rock(0)
        //% is used to wrap rock around to be greater than scissors
        if (userItem == computerItem) {
            //The user ties with the computer
            System.out.println("Tie");
            //records the tie to the totals
            scores[0]++;

        } else if (((userItem+1)%3)==computerItem) {
            //The computer wins
            System.out.println("The Computer Wins");
            //records the loss to the totals
            scores[1]++;

        }else if (((computerItem+1)%3)==userItem){
            // The user wins
            System.out.println("You Win!!!");
            //records the win to the totals
            scores[2]++;
        }

        return scores;
    }


    /**
     * Shows the final scores and declares the overall winner
     * @param scores int[3] with number of {ties, computer wins, user wins,}
     */
    public static void declareWinner(int[] scores){

        //so the running totals of the wins, losses and ties are shown
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");
        System.out.println("The Final Scores are:");
        System.out.println (scores[0] + " rounds Tied");
        System.out.println("The Computer Won "+ scores[1] + " rounds");
        System.out.println("You Won "+ scores[2] + " rounds");
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");


        //To declare an overall winner
        if (scores[2] == scores[1]){
            //The user and computer got the same amount of wins
            System.out.println("It's a Draw, Both You and the Computer won the same amount of rounds");

        } else if (scores[2] < scores[1]) {
            //The computer is the winner
            System.out.println("Sorry, The Computer is the Overall Winner");

        } else if (scores[2] > scores[1]) {
            //The user is the winner
            System.out.println("Well Done, You are the Overall Winner!!!!!!");
        }
        //closing pattern
        System.out.println("\n _,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,__,.-'~'-.,_\n");
    }


    /**
     * Will prompt the user if they want to play again
     * will either stop or continue the do-while loop of the whole program
     */
    public static void playAgain(){
        //prompt user if they want to play again
        System.out.println("Do you want to play again y/n?");
        //Scans input as the user's response
        String response = myScanner.nextLine();

        //switch will change the repeatGame variable based on user's response
        switch (response){
            case "y":
                repeatGame=true;
                break;
            case "n":
                repeatGame=false;
                System.out.println("\nThanks for Playing!\n");
                break;
        }
    }




}