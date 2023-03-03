package com.company;

import java.util.HashMap;
import java.util.Map;

public class WordScramble {
    public static void main(String[] args) {
        String[] words = {"cat", "baby", "god", "bird", "car", "ax"};
        String string1 = "tcabnihjs";
        Map<Character, Integer> countStringMap = countLetters(string1);

        for (String word: words
             ) {
            Map<Character, Integer> countWordMap = countLetters(word);
            boolean wordDetected = true;
            for(Character character: countWordMap.keySet()) {
                int currentWordCharCount = countWordMap.get(character);
                int letterCharCount = countStringMap.containsKey(character) ? countStringMap.get(character):0;
                if (currentWordCharCount > letterCharCount) {
                    wordDetected = false;
                    break;
                }
            }
            if (wordDetected) {
                System.out.println(word);
                break;
            }
        }


    }
    private static Map<Character, Integer> countLetters(String str){
        Map<Character, Integer> countletmap = new HashMap<>();
        for (int i = 0; i < str.length() ; i++) {
            Character currentChar = str.charAt(i);
            int count = countletmap.containsKey(currentChar) ? countletmap.get(currentChar): 0;
            countletmap.put(currentChar, count + 1);
        }
        return countletmap;

    }


}
