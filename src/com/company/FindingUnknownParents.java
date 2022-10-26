package com.company;

import java.util.*;

public class FindingUnknownParents {

    public static void main(String[] args) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        int[][] pairs = {{5, 6}, {1, 3}, {2, 3},
                {3, 6}, {15, 12}, {5, 7}, {4, 5},
                {4, 9}, {9, 12}, {30, 16}
        };
        populateMap(pairs, parentMap);

        System.out.println(parentMap);

        Set<Integer> ZeroSet = new HashSet<>();
        Set<Integer> OneSet = new HashSet<>();

        for (Map.Entry e : parentMap.entrySet()
        ) {
            populateSets(e, ZeroSet, OneSet);
        }

        System.out.println(ZeroSet);
        System.out.println(OneSet);

    }

    private static void populateSets
            (Map.Entry<Integer, Integer> e, Set<Integer> zeroSet, Set<Integer> oneSet) {
        if (e.getValue() == 0) zeroSet.add(e.getKey());
        if (e.getValue() == 1) oneSet.add(e.getKey());

    }


    private static void populateMap(int[][] pairs, Map<Integer, Integer> parentMap) {


        for (int[] pair : pairs
        ) {

            if (!parentMap.containsKey(pair[0])) parentMap.put(pair[0], 0);

            if (parentMap.containsKey(pair[1])) {

                parentMap.put(pair[1], parentMap.get(pair[1]) + 1);
            } else {
                parentMap.put(pair[1], 1);
            }
        }
    }
}




