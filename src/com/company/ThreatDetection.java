package com.company;

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
    private static final int[][] directions = {{0,1}, {1,0}, {-1, 0}, {0, -1}};

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

    }
}
