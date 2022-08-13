package com.company;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SumSubset {
    public static void main(String[] args) {
        /*char[][] grid1 = {
                {'c', 'c', 'x', 't', 'i', 'b'},
                {'c', 'c', 'a', 't', 'n', 'i'},
                {'a', 'c', 'n', 'n', 't', 't'},
                {'t', 'c', 's', 'i', 'p', 't'},
                {'a', 'o', 'o', 'o', 'a', 'a'},
                {'o', 'a', 'a', 'a', 'o', 'o'},
                {'k', 'a', 'i', 'c', 'k', 'i'}
        };*/
        int[] candidates = {1, 2, 4, 8, 16, 32, 64, 128};
        int target = 243;

        List<List<Integer>> result = combinationSum(candidates, target);

       for(List<Integer> list : result) {
           for (Integer e : list) {
               System.out.print(e + " ");
           }
           System.out.println();
       }

        /*int rows = grid1.length;
        int cols = grid1[0].length;
        String word = "bat";

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid1[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];

                    if (dfs(grid1, cols, rows, i, j, word, 0, visited, "")) {
                        // add to a map the root key and list of coordinates.
                        System.out.println("done");
                    }
                }
            }

        }*/


    }

    private static List<List<Integer>> combinationSum(int[] candidates, int target) {
     List<List<Integer>> result = new ArrayList<>();
     Arrays.sort(candidates);
     findCombinations(candidates, 0, target, new ArrayList<Integer>(), result);

     return result;

    }

    private static void findCombinations(int[] candidates, int index, int target, ArrayList<Integer> integers, List<List<Integer>> result) {
        if(target == 0) {
              result.add(new ArrayList<>(integers));
              return;
        }
        if (target < 0) {
            return;
        }

        for (int j = index; j <candidates.length ; j++) {

            if (j == 0 || candidates[j] != candidates[j-1]) {
                integers.add(candidates[j]);
                findCombinations(candidates, j +1, target - candidates[j], integers, result);
                integers.remove(integers.size() - 1);
            }

        }


    }

    private static boolean dfs(char[][] grid1, int cols, int rows, int i, int j, String word,
                               int index, boolean[][] visited, String path) {
        if (word.length() == index) {
            System.out.println(path);
            return true;
        }

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid1[i][j] != word.charAt(index) || visited[i][j] == true ) return false;

        path += word.charAt(index) + "(" + String.valueOf(i)
                + ", " + String.valueOf(j) + ") ";
        //wordcord.add( new int[]{i,j});

        visited[i][j] = true;

        if (dfs(grid1, cols, rows, i + 1, j, word, index + 1, visited, path) ||
                dfs(grid1, cols, rows, i - 1, j, word, index + 1, visited, path) ||
                dfs(grid1, cols, rows, i, j + 1, word, index + 1, visited, path) ||
                dfs(grid1, cols, rows, i, j - 1, word, index + 1, visited, path)
        ) {
            return true;
        }

        return false;
    }

}

