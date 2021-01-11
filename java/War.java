package com.company;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main{
    static final HashMap<String, Integer> cardValues = new HashMap<String, Integer>();
    static{
        cardValues.put("S2",2);
        cardValues.put("S3",3);
        cardValues.put("S4",4);
        cardValues.put("S5",5);
        cardValues.put("S6",6);
        cardValues.put("S7",7);
        cardValues.put("S8",8);
        cardValues.put("S9",9);
        cardValues.put("S10",10);
        cardValues.put("SJ",11);
        cardValues.put("SQ",12);
        cardValues.put("SK",13);
        cardValues.put("SA",14);
        cardValues.put("D2",2);
        cardValues.put("D3",3);
        cardValues.put("D4",4);
        cardValues.put("D5",5);
        cardValues.put("D6",6);
        cardValues.put("D7",7);
        cardValues.put("D8",8);
        cardValues.put("D9",9);
        cardValues.put("D10",10);
        cardValues.put("DJ",11);
        cardValues.put("DQ",12);
        cardValues.put("DK",13);
        cardValues.put("DA",14);
        cardValues.put("C2",2);
        cardValues.put("C3",3);
        cardValues.put("C4",4);
        cardValues.put("C5",5);
        cardValues.put("C6",6);
        cardValues.put("C7",7);
        cardValues.put("C8",8);
        cardValues.put("C9",9);
        cardValues.put("C10",10);
        cardValues.put("CJ",11);
        cardValues.put("CQ",12);
        cardValues.put("CK",13);
        cardValues.put("CA",14);
        cardValues.put("H2",2);
        cardValues.put("H3",3);
        cardValues.put("H4",4);
        cardValues.put("H5",5);
        cardValues.put("H6",6);
        cardValues.put("H7",7);
        cardValues.put("H8",8);
        cardValues.put("H9",9);
        cardValues.put("H10",10);
        cardValues.put("HJ",11);
        cardValues.put("HQ",12);
        cardValues.put("HK",13);
        cardValues.put("HA",14);

    }

    public static ArrayList<String> keys = new ArrayList<>(
            Arrays.asList("S2","S3","S4","S5","S6","S7","S8","S9","S10","SJ","SQ","SK","SA","D2","D3","D4","D5","D6",
                    "D7","D8","D9","D10","DJ","DQ","DK","DA","C2","C3","C4","C5","C6","C7","C8","C9","C10","CJ","CQ",
                    "CK","CA","H2","H3","H4","H5","H6","H7","H8","H9","H10","HJ","HQ","HK","HA"));

    //==================================================================================================================
    //=================================================WAR==============================================================
    public static void wargame(){

    }
    public static void war(){
        Collections.shuffle(keys); //shuffle cards at the beginning of each game

        ArrayList<String> playerOne = new ArrayList<>();
        ArrayList<String> playerTwo = new ArrayList<>();
        System.out.println("Welcome to WAR!");

        //This will parse the cards between the two players. playerOne will be the user
        for (int i = 0; i < keys.size(); i++){
            if(i % 2 == 0){
                playerOne.add(keys.get(i));
            }
            else{
                playerTwo.add(keys.get(i));
            }
        }

        System.out.println(playerOne); //test
        System.out.println(playerTwo); //test

        //You should probably include something to the effect of script specific rules here
        System.out.println(keys); //test

        //Scores
        int scoreOne = 0;
        int scoreTwo = 0;

        //the game
        while(playerOne.size() < 52 && playerTwo.size() < 52){
            System.out.println(playerOne.get(0) + " <======= VS =======> " + playerTwo.get(0));//the battle

            if(cardValues.get(playerOne.get(0)) > cardValues.get(playerTwo.get(0))){
                playerOne.add(playerTwo.get(0));
                playerTwo.remove(0);
            }
            if(cardValues.get(playerOne.get(0)) < cardValues.get(playerTwo.get(0))){
                playerTwo.add(playerOne.get(0));
                playerOne.remove(0);
            }
            if(cardValues.get(playerOne.get(0)) == cardValues.get(playerTwo.get(0))){
                // CONDITION IF THERE'S ONLY ONE CARD LEFT NEEDED

                if(playerOne.size() >= 4 && playerTwo.size() >= 4){
                    System.out.println("==== IT'S A DRAW! ====\n======================\n======= WAGER! =======");
                    System.out.println("PLAYER ONE==PLAYER TWO");
                    System.out.println("......" + playerOne.get(1) + "......" + playerTwo.get(1) + "......");
                    System.out.println("......" + playerOne.get(2) + "......" + playerTwo.get(2) + "......");

                    //DON'T FORGET TO ADD THE CONSEQUENCES
                }
                if(playerOne.size() < 4 && playerTwo.size() >= 4){
                    System.out.println("==== IT'S A DRAW! ====\n======================\n======= WAGER! =======");
                    System.out.println("PLAYER ONE==PLAYER TWO");
                    System.out.println("..NULL........" + playerTwo.get(1) + "......");
                    System.out.println("..NULL........" + playerTwo.get(2) + "......");
                }
                if(playerOne.size() >= 4 && playerTwo.size() < 4){
                    System.out.println("==== IT'S A DRAW! ====\n======================\n======= WAGER! =======");
                    System.out.println("PLAYER ONE==PLAYER TWO");
                    System.out.println("......" + playerOne.get(1) + "........NULL..");
                    System.out.println("......" + playerOne.get(2) + "........NULL..");
                }
            }
            else{
                System.out.println("something fucked up");
            }
        }
    }
    //==================================================================================================================
    //================================================MAIN==============================================================
    public static void main(String[] args) {
        // as you add games, be sure to include their names in the following list
        String[] gamesList = {"War","Solitaire"};
        System.out.println(cardValues.get("S4"));//test
	    // write your code here
        System.out.println("Hello! PottBot here!\nWelcome to your very own deck of cards! Let's get started\nWhat game would you like to play?");
        for (int i = 0; i < gamesList.length; i++){
            System.out.println(i + 1 + ". " + gamesList[i]);
        }
        war();
    }
}
