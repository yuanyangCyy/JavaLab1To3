package com.fxexample.lab1to3;


import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {

    public static void main(String[] args) {
        // store some words for random

        System.out.println("Starting Lab 2...");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Welcome to Hangman game");

            System.out.println("1) Cosmetics Brands");
            System.out.println("2) Animals");
            System.out.println("3) Countries");
            System.out.println("4) Exit");
            System.out.print("Select a topic (1-4) > ");




            String chioce = scanner.nextLine().trim();

            if(chioce.equals("1")) {
                String[] cosmetics = {"lancome", "clinique", "chanel", "dior"};
                playOneRound(cosmetics,scanner);
            }else if(chioce.equals("2")) {
                String[] animals = {"cat", "dog", "horse", "pig", "sheep"};
                playOneRound(animals,scanner);
            }else if(chioce.equals("3")) {
                String[] contries = {"canada", "china", "japan", "france"};
                playOneRound(contries, scanner);
            }else if(chioce.equals("4")) {
                System.out.println("Goodbye!");
                break;
            } else {
                System.out.println("Invalid choice");

            }


        }

        scanner.close();
    }









    private static void playOneRound(String[] words, Scanner scanner) {
        String word = pickRandom(words).toLowerCase();   //
        char[] masked = new char[word.length()];
        Arrays.fill(masked, '*');

        int misses = 0;

        while (hasStars(masked)) {
            System.out.print("(Guess) Enter a letter in word " + new String(masked) + " > ");
            String token = scanner.next();
            char guess = Character.toLowerCase(token.charAt(0));


            if (alreadyRevealed(masked, guess)) {
                System.out.println(guess + " is already in the word");
                continue;
            }


            boolean hit = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    masked[i] = guess;
                    hit = true;
                }
            }
            if (!hit) {
                System.out.println(guess + " is not in the word");
                misses++;
            }
        }


        System.out.println("The word is " + word + ". You missed " + misses + " time" + (misses == 1 ? "" : "s"));
    }

    private static boolean askReplay(Scanner scanner) {
        System.out.print("Do you want to guess another word? Enter y or n> ");
        String ans = scanner.next().trim().toLowerCase();
        return !ans.isEmpty() && ans.charAt(0) == 'y';
    }

    private static String pickRandom(String[] words) {
        return words[new Random().nextInt(words.length)];
    }

    private static boolean hasStars(char[] masked) {
        for (char c : masked) if (c == '*') return true;
        return false;
    }

    private static boolean alreadyRevealed(char[] masked, char guess) {
        for (char c : masked) if (c == guess) return true;
        return false;
    }
}