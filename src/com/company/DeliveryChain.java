package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class DeliveryChain {
    public static void main(String[] args) {

        Map<String, List<String>> adjMap;



        String[][] paths = {
                {"A", "B"},
                {"A", "C"},
                {"B", "K"},
                {"C", "K"},
                {"E", "L"},
                {"F", "G"},
                {"J", "M"},
                {"E", "F"},
                {"G", "H"},
                {"G", "I"},
                {"C", "G"}
        };

        Set<String> endNodes = new HashSet<>();
        Set<String> startNodes = new HashSet<>();

        Map<Integer, Set<String>> fringemap = getStartEndNodes(paths, endNodes, startNodes);

      //  startNodes.stream().forEach(System.out::print);

    //    System.out.println();
        endNodes.stream().forEach(System.out::print);


        adjMap = getAdjMap(paths);

        System.out.println(adjMap);

        Set<String> result = breadthFirstTraversal(adjMap, fringemap.get(0), "A");

        result.stream().forEach(System.out::println);
    }

    private static Map<String, List<String>> getAdjMap(String[][] paths) {

        Map<String, List<String>> adjMap = new HashMap<>();

        for (String[] arr : paths) {
            if (adjMap.containsKey(arr[0])) {
                List<String> children = adjMap.get(arr[0]);
                children.add(arr[1]);
                adjMap.put(arr[0], children);
            } else {
                List<String> children = new ArrayList<>();
                children.add(arr[1]);
                adjMap.put(arr[0], children);
            }


        }
        return adjMap;
    }

    private static  Map<Integer, Set<String>> getStartEndNodes(String[][] paths, Set<String> end, Set<String> start) {

        Set<String> parentSet = new HashSet<>();
        Set<String> childSet = new HashSet<>();

        Map<Integer, Set<String>> localmap = new HashMap<>();


        for (String[] parentChild : paths) {
            String parent = parentChild[0];
            String child = parentChild[1];

            if (!parentSet.contains(parent)) parentSet.add(parent);
            if (!childSet.contains(child)) childSet.add(child);


        }

       end = parentSet.stream().filter(e -> !childSet.contains(e)).collect(Collectors.toSet());
        start = childSet.stream().filter(e -> !parentSet.contains(e)).collect(Collectors.toSet());

        localmap.put(0, start);
        localmap.put(1, end);

       return localmap;


    }

    private static Set<String> breadthFirstTraversal(Map<String, List<String>> adjMap, Set<String> endPoints, String i) {
        Set<String> visited = new LinkedHashSet<>(); // this node visited set
        Set<String> destinations = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(i);
        visited.add(i);
        while (!q.isEmpty()) {
            String item = q.poll();
            if(endPoints.contains(item)) destinations.add(item);
            if (adjMap.containsKey(item)) {
                for (String child : adjMap.get(item)) {
                    if (!visited.contains(child)) {
                        visited.add(child);
                        q.add(child);
                    }
                }
            }
        }
        return destinations;
    }
}
