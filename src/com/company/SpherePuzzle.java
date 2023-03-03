package com.company;

import java.util.*;

public class SpherePuzzle {
    public static void main(String[] args) {

        String room1 = "RBGYygbr";
        Map<Character, Integer> sphereMap = new HashMap<>();
        Map<Character, List<Integer>> holesMap = new HashMap<>();

        populateMaps(room1, sphereMap, holesMap);

        int minSteps = getMinimumSteps(sphereMap, holesMap);

        System.out.println(sphereMap);
        System.out.println(holesMap);

        System.out.println(minSteps);


    }

    private static int getMinimumSteps(Map<Character, Integer> sphereMap, Map<Character, List<Integer>> holesMap) {
        int minSteps = 0;
        for (Map.Entry entry: sphereMap.entrySet()
             ) {
            char sphere = (char) entry.getKey();
            int sphere_pos = (int) entry.getValue();
            List<Integer> holesList = holesMap.get(Character.toLowerCase(sphere));
            holesList.replaceAll(e -> Math.abs(e - sphere_pos));
            minSteps += Collections.min(holesList);

        }
        return minSteps;
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
