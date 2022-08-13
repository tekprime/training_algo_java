package com.company;

import java.util.*;

public class Hangman {
    public static void main(String[] args) {
        List<String> wordsToGuess = Arrays.asList("Thrilling", "Tomorrow", "Dawn", "Computer");

        List<Character> userGuess = new ArrayList<>();

        Random rand = new Random();

        String word = wordsToGuess.get(rand.nextInt(wordsToGuess.size()));

        System.out.println(word);


        printCurrentState(userGuess, word);

        while(!userGuess.toString().equals(word)) {
            nextGuess(userGuess);
            printCurrentState(userGuess, word);

        }

    }

    private static void nextGuess(List<Character> userGuess) {
        Scanner userCharInput = new Scanner(System.in);
        String userStr = userCharInput.nextLine();
        userGuess.add(userStr.charAt(0));
    }

    private static void printCurrentState(List<Character> userGuess, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (userGuess.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
            } else {
                System.out.print("-");
            }
        }
        System.out.println();
    }
}
