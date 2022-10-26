package com.company;

import java.util.HashMap;
import java.util.Map;

public class WinningHands {
    public static void main(String[] args) {
        // System.out.println(10 % 2);
        String tiles1 = "11133555";
        Map<Character, Integer> numMap = numbersCount(tiles1);
        System.out.println(numMap);
        boolean notvalid = false;
        int pairCount = 0;
        for (Map.Entry entry: numMap.entrySet()
             ) {
            int number = Character.getNumericValue((char) entry.getKey());
            int repeat =  (int) entry.getValue();
            int remain1 = repeat % 3;
            if (remain1 == 2) {
                pairCount++;
            } else if ( remain1 != 0 ) {
                notvalid = true;
                break;
            }
        }
        if ( pairCount == 1 && !notvalid) System.out.println("TRUE");
        else System.out.println("FALSE");


    }

    private static Map<Character, Integer> numbersCount(String s) {
        Map<Character, Integer> count_map = new HashMap<>();
        for (int i = 0; i < s.length() ; i++) {
            char currentChar = s.charAt(i);
            int charCount = count_map.containsKey(currentChar) ? count_map.get(currentChar):0;
            count_map.put(currentChar, charCount + 1);
        }
        return count_map;
    }


}
