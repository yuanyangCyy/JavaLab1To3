package com.fxexample.lab1to3;

import java.util.Arrays;
import java.util.Random;

public class HangmanGame {
    public static void main(String[] args) {
       //define the words

        String[] words = {"write", "that", "program", "java", "system", "object"};

// random a word

        Random random = new Random();
        String word = words[random.nextInt(words.length)];



        char[] masked = new char[word.length()];
        Arrays.fill(masked, '*');


        System.out.println("Hangman is ready!");
        System.out.println("Word: " + new String(masked)); //


    }
}