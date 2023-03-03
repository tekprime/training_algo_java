package com.company;

import java.util.HashMap;
import java.util.Map;

public class WinningHands {
    public static void main(String[] args) {

            String tiles1 = "1133355";

            Map<Integer, Integer> tileCountMap = new HashMap<>();

            for (int index = 0; index < tiles1.length(); index++) {
                int current_tiles = Character.getNumericValue(tiles1.charAt(index));
                int tile_count = (tileCountMap.containsKey(current_tiles))? tileCountMap.get(current_tiles) + 1 :1;
                tileCountMap.put(current_tiles, tile_count);
            }

            boolean isValid = true;
            int pairCount = 0;

            for (int tile : tileCountMap.keySet()) {
                if (tileCountMap.get(tile) % 3 == 2) pairCount++;
                else if (tileCountMap.get(tile) % 3 == 0) continue;
                else isValid = false;
            }

            if (pairCount == 1 && isValid) System.out.println(true);
            else System.out.println(false);

        }
    }
        /*// System.out.println(10 % 2);
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
    }*/



