package com.griffin.games.java;

/**
 * Created by Griffin Potts on 7/2/2020
 */

import java.util.Scanner;

public class Game {
    public static char[][] NewBoard(){
        //This is gonna be where a new board is made at the beginning of each game
        char game[][] = new char[3][3];

        for(int i = 0; i < 3; i ++){
            for(int j = 0; j < 3; j++){
                game[i][j] = ' ';
            }
        }

        /*I don't know if it'll be an issue, but you may have to manually make each index a ' ' or whatever
        * null value you choose*/
        return game;
    }

    public static void rules(){
        //you're gonna wanna write specifically what the user should expect
        System.out.println("I mean you're playing Tic Tac Toe, it's not hard.");
        System.out.println("   |   |\n---+---+---\n   |   |\n---+---+---\n   |   |");
        System.out.println("First input will be what row, and second will be the column, both starting with zero");
    }

    public static Boolean check(int moveY, int moveX, char[][] gameBoard){
        //This will be used to make sure that the two doodads are
        System.out.println("you got to the Check method");

        if (moveY < 0 || moveY > 2 || moveX < 0 || moveX > 2){
            System.out.println("Sorry, that's out of bounds, my guy");
            return false;
        }
        else{
            if (gameBoard[moveY][moveX] == ' '){
                return true;
            }
            else if(gameBoard[moveY][moveX] != ' '){
                System.out.println("That space is taken, smooth brain");
                return false;
            }
        }
        return false;
    }

    public static char[][] move(char[][] gameBoard, String currentPlayer){ // idk if you need to return the array
        //this will call check() then attempt to move. This should re-run if it is unsuccessful
        Boolean dog = true;
        Scanner moveObj = new Scanner(System.in);

        while (dog){

            System.out.println("Which row would you like to move to?");
            String moveY = moveObj.nextLine();

            System.out.println("Which column would you like to move to?");
            String moveX = moveObj.nextLine();


            Boolean validation = check(Integer.valueOf(moveY), Integer.valueOf(moveX), gameBoard);

            if (validation = false) {//this is the false condition
                System.out.println("Oof, pal. Looks like that just ain't a valid move.");
            }
            else if (validation){
                System.out.println("you got to the else");
                if (currentPlayer == "one"){
                    gameBoard[Integer.valueOf(moveY)][Integer.valueOf(moveX)] = 'X';
                }
                else if (currentPlayer == "two"){
                    gameBoard[Integer.valueOf(moveY)][Integer.valueOf(moveX)] = 'O';
                }
                dog = false;
            }
            else{
                System.out.println("something went horribly wrong");
            }
        }
        return gameBoard;
    }

    public static void printBoard(char[][] gameBoard){
        for(int y = 0; y < gameBoard.length; y++){
            if (y < 2){
                System.out.println(" " + gameBoard[y][0] + " | " + gameBoard[y][1] + " | " + gameBoard[y][2]);
                System.out.println("---+---+---");
            }
            else{
                System.out.println(" " + gameBoard[y][0] + " | " + gameBoard[y][1] + " | " + gameBoard[y][2]);
            }
        }
    }
    public static Boolean win(char[][] gameBoard){
        //this will check to see if any win condition has been met. It will return in true if the game is over
        for (int j = 0; j < 2; j++){
            if (j == 0){
                char mark = 'X';
            }
            else{
                char mark = 'O';
            }
            for (int y = 0; y < 3; y++){
                if(gameBoard[y][0] == mark && gameBoard[y][1] == mark && gameBoard[y][2] == mark){
                    Boolean success = true;
                    break;
                }
                else if(gameBoard[0][y] == mark && gameBoard[1][y] == mark && gameBoard[2][y] == mark) {
                    Boolean success = true;
                    break;
                }
                else if(gameBoard[0][0] == mark && gameBoard[1][1] == mark && gameBoard[2][2] == mark){
                    Boolean success = true;
                    break;
                }
                else if(gameBoard[2][0] == mark && gameBoard[1][1] == mark && gameBoard[0][2] == mark){
                    Boolean success = true;
                    break;
                }
                else{
                    Boolean success = false;
                    break;
                }
            }
            if (success){
                break;
            }
        }
        return success;
    }

    public static void main(String[] args){
        rules();

        //Get the player's names
        Scanner NameObj = new Scanner(System.in);
        System.out.println("Player one name: ");
        String playerOne = NameObj.nextLine();

        System.out.println("Player two name: ");
        String playerTwo = NameObj.nextLine();

        Boolean flag = true;
        while (flag){ //flag error will resolve when you give an exit condition to the loop
            char [][] gameBoard = NewBoard();

            //do another for loop that will cycle between each player.
            for (int i = 1; i < 10; i++){
                printBoard(gameBoard);

                if (i % 2 == 1){
                    System.out.println("It's " + playerOne + "'s turn!");
                    gameBoard = move(gameBoard, "one");
                }
                else{
                    System.out.println("It's " + playerTwo + "'s turn!");
                    gameBoard = move(gameBoard, "two");
                }
                /*Boolean gameOver = win(gameBoard); //evaluate whether the game is over or not
                if (gameOver){
                    break;

                }*/
            }

            //You'll have to be sure to mark flag as 'false' at some point
            System.out.println("Would you like to play again? (Y/N)");
            String choice = NameObj.nextLine();

            if (choice == "N"){
                flag = false;
            }
            NameObj.close();

            System.out.println("Here we go again");
        }
    }
}
