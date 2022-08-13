package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Stream;

public class MonsterPack {

    private final static int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        char[][] grid = {
                {'-', 'M', 'M', '-', '-', 'M'},
                {'-', '-', '-', '-', 'M', '-'},
                {'-', 'M', '-', '-', 'M', '-'},
                {'P', 'M', '-', '-', 'M', '-'},
                {'-', 'M', '-', '-', 'M', '-'},
        };
        List<int[]> result = numberofPacks(grid);

        int cols = grid[0].length;
        for (int[] coord : result) {

            System.out.println("(" + coord[0] / cols +"," + coord[0] % cols + ")" + coord[1]);
        }

    }

    public static List<int[]> numberofPacks(char[][] grid){

        if (grid == null || grid.length == 0) return null;
        int danger = 0;
        ArrayList<int[]> result = new ArrayList<int[]>();
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                  if (grid[i][j] == 'M') {
                      // Top left Monster found
                     danger = exploreMonsterPack(grid, rows, cols, i, j);
                     int index = i * cols + j;
                     int[] arr = {index, danger};
                     result.add(arr);


                  }

            }

        }
        return result;
    }

    private static int exploreMonsterPack(char[][] grid, int rows, int cols, int i, int j) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i*cols + j);
        grid[i][j] = '-';
        int danger = 1;
        while (!q.isEmpty()) {
            int index = q.poll();
            int row = index / cols;
            int col = index % cols;
            for (int[] direction: DIRECTIONS){
                int x = row + direction[0];
                int y = col + direction[1];
                if (x > -1 && x < rows && y > -1 && y < cols && grid[x][y] == 'M'){
                    grid[x][y] = '-';
                    q.add(x*cols +y);
                    ++danger;
                }
            }
        }
      return danger;
    }
}
