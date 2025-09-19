package com.fxexample.lab1to3;

public class HangmanGame {
    public static void main(String[] args) {
        // Define a list of words for the Hangman game
        String[] words = {"write", "that", "program", "java"};

        // Print available words (just to test the array works)
        System.out.print("Available words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}