package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class RulesOfGame {
    public static void main(String[] args) {
      String[] teleport =   {"3,1", "4,2", "5,10"};
      int[] squares = {0, 1, 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
      int dice = 6;
      int start = 0;

        Map<Integer, Integer> teleMap = new HashMap<>();
        Set<Integer> outcomeSet = new HashSet<>();

        for (String tele : teleport
             ) {
            String[] teleD = tele.split(",");
            int from_square = Integer.parseInt(teleD[0]);
            int to_square = Integer.parseInt(teleD[1]);
            teleMap.put(from_square,to_square);
        }
        for (int i = 1; i <= dice ; i++) {
            int currentSquare = squares[i];
            if(teleMap.containsKey(currentSquare)) outcomeSet.add(teleMap.get(currentSquare));
            else outcomeSet.add(currentSquare);

        }

        System.out.println(outcomeSet);




    }
}
