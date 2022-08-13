package com.company;

/*package whatever //do not write package name here */
// Java Code implementation for above problem
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// QItem for current location and distance
// from source location
/*class QItem {
    int row;
    int col;
    int dist;
    public QItem{int row, int col, int dist)
    {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}*/

class QItem {
    int row;
    int col;
    int dist;

    public QItem(int row, int col, int dist) {
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class Maze {

    private static int[] minDistance(char[][] grid, int startRow, int startCol)
    {
        // QItem source = new QItem(0, 0, 0);
        QItem source = new QItem(0, 0, 0);
        grid[startRow][startCol] = 's';
        source.row = startRow;
        source.col = startCol;

        // To keep track of visited QItems. Marking
        // blocked cells as visited.
        firstLoop:
       /* for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++)
            {

                // Finding source
                if (grid[i][j] == 's') {
                    source.row = i;
                    source.col = j;
                    break firstLoop;
                }
            }
        }*/
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.printf(grid[row][col] + "");
            }
            System.out.println();
        }

        int numRows = grid.length;
        int numCols = grid[0].length;
        System.out.println("number of rows: "+ numRows + " number of col: " + numCols);

        for (int i = 0; i < numRows ; i++) {
            if (grid[i][0] == '0') grid[i][0] = 'd';

        }
        for (int i = 0; i < numCols ; i++) {
            if (grid[0][i] == '0') grid[0][i] = 'd';

        }

        for (int i = 0; i < numRows ; i++) {
            if (grid[i][numCols-1] == '0') grid[i][numCols-1] = 'd';

        }
        for (int i = 0; i < numCols ; i++) {
            if (grid[numRows-1][i] == '0') grid[numRows-1][i] = 'd';

        }


        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                System.out.printf(grid[row][col] + "");
            }
            System.out.println();
        }

        // applying BFS on matrix cells starting from source
        /*Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(source.row, source.col, 0));

        boolean[][] visited
                = new boolean[grid.length][grid[0].length];
        visited[source.row][source.col] = true;*/

        Queue<QItem> queue = new LinkedList<>();
        queue.add(new QItem(source.row, source.col, 0));

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[source.row][source.col] = true;

        while (!queue.isEmpty()) {
            QItem p = queue.remove();

            // destination found.
            if (grid[p.row][p.col] == 'd') return new int[]{p.row,p.col};
            // move up

            if (isValid(p.row -1, p.col, grid, visited)){
                queue.add(new QItem(p.row - 1, p.col, p.dist + 1));
                visited[p.row-1][p.col] = true;
            }
            if (isValid(p.row +1, p.col, grid, visited)){
                queue.add(new QItem(p.row + 1, p.col, p.dist + 1));
                visited[p.row+1][p.col] = true;
            }
            if (isValid(p.row, p.col -1, grid, visited)){
                queue.add(new QItem(p.row, p.col -1, p.dist + 1));
                visited[p.row][p.col -1] = true;
            }
            if (isValid(p.row, p.col +1, grid, visited)){
                queue.add(new QItem(p.row, p.col +1, p.dist + 1));
                visited[p.row][p.col +1] = true;
            }

       /* while (queue.isEmpty() == false) {
            QItem p = queue.remove();

            // Destination found;
            if (grid[p.row][p.col] == 'd')
                return new int[]{p.row, p.col};

            // moving up
            if (isValid(p.row - 1, p.col, grid, visited)) {
                queue.add(new QItem(p.row - 1, p.col,
                        p.dist + 1));
                visited[p.row - 1][p.col] = true;
            }

            // moving down
            if (isValid(p.row + 1, p.col, grid, visited)) {
                queue.add(new QItem(p.row + 1, p.col,
                        p.dist + 1));
                visited[p.row + 1][p.col] = true;
            }

            // moving left
            if (isValid(p.row, p.col - 1, grid, visited)) {
                queue.add(new QItem(p.row, p.col - 1,
                        p.dist + 1));
                visited[p.row][p.col - 1] = true;
            }

            // moving right
            if (isValid(p.row, p.col + 1, grid,
                    visited)) {
                queue.add(new QItem(p.row, p.col + 1,
                        p.dist + 1));
                visited[p.row][p.col + 1] = true;
            }*/
        }


        return  new int[]{-1, -1};
    }

    private static boolean isValid(int x, int y, char[][] grid, boolean[][] visited) {

        if (x >= 0 && y >= 0 && x < grid.length && y < grid[0].length
                && visited[x][y] == false && grid[x][y] != '0') {
            return true;
        }

        return false;
    }
    // checking where it's valid or not
    /*private static boolean isValid(int x, int y,
                                   char[][] grid,
                                   boolean[][] visited)
    {
        if (x >= 0 && y >= 0 && x < grid.length
                && y < grid[0].length && grid[x][y] != '0'
                && visited[x][y] == false) {
            return true;
        }
        return false;
    }
*/
    // Driver code
    public static void main(String[] args)
    {
        char[][] grid = { { '0', '*', '0', 's' },
                          { '*', '0', '*', '*' },
                          { 'd', '*', '*', '*' },
                          { '*', '*', '*', '*' } };

        char[][] board1 = {{'+', '+', '+', '+', '+', '+', '+', '0', '0'},
                           {'+', '+', '0', '0', '0', '0', '0', '+', '+'},
                           {'0', '0', '0', '0', '0', '+', '+', '0', '+'},
                           {'+', '+', '0', '+', '+', '+', '+', '0', '0'},
                           {'+', '+', '0', '0', '0', '0', '0', '0', '+'},
                           {'+', '+', '0', '+', '+', '0', '+', '0', '+'}};

        int[] result =minDistance(board1, 2,0);
        System.out.println("("+ result[0] + "," +result[1]+")");

        result = minDistance(board1, 0,7);
        System.out.println("("+ result[0] + "," +result[1]+")");
    }
}

// This code is contributed by abhikelge21.

