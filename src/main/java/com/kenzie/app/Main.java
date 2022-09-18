package com.kenzie.app;

// import necessary libraries

import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Main {
    /* Java Fundamentals Capstone project:
       - Define as many variables, properties, and methods as you decide are necessary to
       solve the program requirements.
       - You are not limited to only the class files included here
       - You must write the HTTP GET call inside the CustomHttpClient.sendGET(String URL) method
         definition provided
       - Your program execution must run from the main() method in Main.java
       - The rest is up to you. Good luck and happy coding!

     */

    public static void main(String[] args) throws JsonProcessingException {
        //Write main execution code here
        String jeopardy = jeopardyGame.main();
        boolean playAgain = true;
        while (playAgain){
        System.out.println("You Won! What did you win? Knowledge! *\nCrowd Cheers with excitement*");
            System.out.println("Want to play again? Think you can handle it?");
                //your game code here
                System.out.println("Y/N?");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();//this will take the answer of the user
                //else the loop will exit
                if (answer.equalsIgnoreCase("y")){
                    playAgain = true;
                    jeopardyGame.main();
                } else{
                    playAgain = false;
                }
                    
                }


        }


    }








