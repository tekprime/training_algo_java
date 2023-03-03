package com.company;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class QIt {
    int row;
    int col;
    int dist;

    public QIt(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}
public class ThreatDetection {

    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        char[][] board1 = {
                {'-', '-', '-', 'M', '-', '-'},
                {'-', '-', '-', '-', 'M', '-'},
                {'M', '-', '-', 'P', '-', '-'},
                {'M', '-', '-', '-', '-', '-'},
                {'-', 'M', '-', '-', '-', '-'},
        };

        int rows = board1.length;
        int cols = board1[0].length;

        int x =0, y=0, distance;

        outer: for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(board1[i][j] == 'P') {
                    x = i;
                    y= j;
                    break outer;
                }

            }
        }
        distance = findminDistance(board1, x, y, rows, cols);

        System.out.println(distance);



    }

    private static int findminDistance(char[][] board1, int x, int y, int rows, int cols) {

        HashSet<Integer> set = new HashSet<>();
        int distance = -1;


        for (int i = x + 1; i < rows ; i++) {
            distance++;
            if (board1[i][y] == 'M') {
                set.add(distance);
                break;
            }
        }
        distance = -1;

        for (int i1 = x - 1; i1 >= 0 ; i1--) {
            distance++;
            if (board1[i1][y] == 'M') {
                set.add(distance);
                break;
            }
        }

        distance = -1;

        for (int i2 = y + 1; i2 < cols ; i2++) {
            distance++;
            if (board1[x][i2] == 'M') {
                set.add(distance);
                break;
            }
        }
        distance = -1;
        for (int i3 = y - 1; i3 >= 0 ; i3--) {
            distance++;
            if (board1[x][i3] == 'M') {
                set.add(distance);
                break;
            }
        }


        return Collections.min(set);
    }
    /*private static final int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

    public static void main(String[] args) {
      char[][]  board = {
                           {'-', '-', '-', '-', '-', '-'},
                           {'-', '-', '-', '-', 'M', '-'},
                           {'M', '-', '-', 'P', '-', '-'},
                           {'M', '-', '-', '-', '-', '-'},
                           {'-', 'M', '-', '-', '-', '-'}};

      int rows = board.length;
      int cols = board[0].length;
      boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols ; j++) {
                if(board[i][j] == 'P') {
                    int minD = findminMDist(board, i, j, rows, cols, visited);
                    System.out.println(minD);
                }
            }

        }


    }

    private static int findminMDist(char[][] board, int i, int j, int rows, int cols, boolean[][] visited) {

        Queue<QIt> q = new LinkedList<>();
        q.add(new QIt(i, j, 0));
        visited[i][j] = true;

        while(!q.isEmpty()){
            QIt p = q.remove();

            if (board[p.row][p.col] == 'M') return p.dist - 1;

            for (int[] direction: directions
                 ) {
                int x = p.row + direction[0];
                int y = p.col + direction[1];
                if (x >= 0 && x < rows && y >= 0 && y < cols && !visited[x][y]) {
                    q.add(new QIt(x,y, p.dist + 1));
                    visited[x][y] = true;

                }

            }

        }
        return 0;

    }*/
}
