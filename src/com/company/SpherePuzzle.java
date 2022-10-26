package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpherePuzzle {
    public static void main(String[] args) {

        String room1 = "..b.r..r.R.B...b";
        Map<Character, Integer> sphereMap = new HashMap<>();
        Map<Character, List<Integer>> holesMap = new HashMap<>();

        populateMaps(room1, sphereMap, holesMap);

        System.out.println(sphereMap);
        System.out.println(holesMap);


    }

    private static void populateMaps(String room1, Map<Character, Integer> sphereMap, Map<Character, List<Integer>> holesMap) {



        for (int i = 0; i < room1.length(); i++) {
            char c = room1.charAt(i);

           if(c != '.') {
               if (Character.isUpperCase(c)) {
                   sphereMap.put(c,i);

               } else {
                   if(holesMap.containsKey(c)) {
                       holesMap.get(c).add(i);
                   }
                   else {
                       List<Integer> listofholes = new ArrayList<>();
                       listofholes.add(i);
                       holesMap.put(c, listofholes);
                   }

               }
           }
        }
    }
}
