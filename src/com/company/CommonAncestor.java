package com.company;


import java.util.*;


class CommonAncestor {

    public static void main(String[] args) {
        Map<Integer, List<Integer>> parentsGraph;
        parentsGraph = new HashMap<>();

        int[][] pairs = {{1, 3}, {2, 3}, {3, 6},
                {5, 6}, {5, 7}, {4, 5}, {15, 21},
                {4, 8}, {4, 9}, {9, 11}, {14, 4}, {13, 12},
                {12, 9}, {15, 13}
        };

        for (int[] arr : pairs) {
            if (parentsGraph.containsKey(arr[1])) {
                List<Integer> parents = parentsGraph.get(arr[1]);
                parents.add(arr[0]);
                parentsGraph.put(arr[1], parents);
            } else {
                List<Integer> parents = new ArrayList<>();
                parents.add(arr[0]);
                parentsGraph.put(arr[1], parents);
            }


        }

        System.out.println(parentsGraph);

        Set<Integer> firstResult = depthFirstTraversal(parentsGraph, 8);

       // System.out.println("result for 8 : ");
        // firstResult.stream().forEach(System.out::println);

        Set<Integer> secondResult = depthFirstTraversal(parentsGraph, 6);

        System.out.println("result for 6 depth : ");
        secondResult.stream().forEach(System.out::println);

        Set<Integer> thirdResult = breadthFirstTraversal(parentsGraph, 6);

        System.out.println("result for 6 breadth : ");
        thirdResult.stream().forEach(System.out::println);

        /*Set<Integer> commonAncestors = new HashSet<>();

        firstResult.stream().forEach((e) -> {
            if (secondResult.contains(e)) commonAncestors.add(e);
        });

        System.out.println("result for common : ");
        commonAncestors.stream().forEach(System.out::println);*/


    }

    private static Set<Integer> breadthFirstTraversal(Map<Integer, List<Integer>> parentsGraph, int i) {
        Set<Integer> visited = new LinkedHashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        visited.add(i);
        while (!q.isEmpty()) {
            int item = q.poll();

            if (parentsGraph.containsKey(item)) {
                for (int parent : parentsGraph.get(item)) {
                    if (!visited.contains(parent)) {
                        visited.add(parent);
                        q.add(parent);

                    }
                }
            }
        }
        return visited;
    }

    private static Set<Integer> depthFirstTraversal(Map<Integer, List<Integer>> parentsGraph, int i) {
        Set<Integer> visited = new LinkedHashSet<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(i);
        visited.add(i);

        while (!stack.isEmpty()) {
            int item = stack.pop();
            if (parentsGraph.containsKey(item)) {
                for (int parent : parentsGraph.get(item)) {
                    if (!visited.contains(parent)) {
                        visited.add(parent);
                        stack.push(parent);
                    }
                }
            }
        }
        return visited;
    }


    // standard constructor, getters, setters
}



