package com.kenzie.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;
import java.util.Scanner;

public class jeopardyGame {
    public static String main() throws JsonProcessingException {
        //Write main execution code here
        try {
            final String TEST_URL = "https://jservice.kenzie.academy/api/clues";
            //input
            //call object mapper for cluesDTO
            String httpResponseStr;
            httpResponseStr = CustomHttpClient.sendGET(TEST_URL);
            ObjectMapper objectMapper = new ObjectMapper();
            CluesDTO clueObj;
            //read data-read value
            clueObj = objectMapper.readValue(httpResponseStr, CluesDTO.class);
            //loop through list of questions
            //set variables
            int totalScore = 0;
            int min = 1;
            int max = 10;
            //random question and category generator
            Random random = new Random();
            int value = random.nextInt(max + min) + min;
            random.nextInt();
            //conditions for how many questions and current questions
            System.out.println("""
                    Welcome to Jeopardy!
                    How many can you get correct?
                    Good luck!""");
            if (clueObj.getClues().size() > 1) {
                for (int i = 0; i < 10; i++) {
                    int currentQuestion = random.nextInt(100);
                    System.out.println("Category: " + clueObj.getClues().get(currentQuestion).getCategory().getTitle());
                    System.out.println("Question: " + clueObj.getClues().get(currentQuestion).getQuestion());

                    //user input
                    //ignore cases for capitalization
                    //print results
                    Scanner myObj = new Scanner(System.in);  // Create a Scanner object
                    System.out.println("Enter Answer:");
                    String responses = myObj.nextLine();  // Read user input
                    if (responses.equalsIgnoreCase(clueObj.getClues().get(currentQuestion).getAnswer())) {
                        System.out.println("Correct! You get a point.");
                        totalScore++;
                    } else
                        System.out.println("OH NO! You almost had it! No points for you! The answer was: " + clueObj.getClues().get(currentQuestion).getAnswer());
                    System.out.println("Your current score is: " + totalScore);


                }
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}