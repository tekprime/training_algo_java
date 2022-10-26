package com.company;

import java.util.ArrayList;
import java.util.List;

class Coordinate {

    int row;
    int col;

    public Coordinate(int row, int col) {
      this.row = row;
      this.col = col;
    }

}
public class TreasureMap {
    public static void main(String[] args) {
        int[][] board = {
                                  {0,  0,  0, -1, -1},
                                  {0,  0, -1,  0,  0},
                                  {0, -1,  0, -1,  0},
                                  {0,  0, -1,  0,  0},
                                  {0,  0,  0,  0,  0},
                                  {0,  0,  0,  0,  0},
                                  {0,  0,  0,  0,  0},
                                };
        List<Coordinate> colist = new ArrayList<>();
        int rows = board.length;
        int cols = board.length;
        int x = 1;
        int y = 1;
      //  colist.add(new Coordinate(x,y));

        if (isValid(board, x+1, y, rows, cols)) colist.add(new Coordinate(x + 1,y));
        if (isValid(board, x-1, y, rows, cols)) colist.add(new Coordinate(x -1 ,y));
        if (isValid(board, x, y + 1, rows, cols)) colist.add(new Coordinate(x  ,y + 1));
        if (isValid(board, x, y - 1, rows, cols)) colist.add(new Coordinate(x  ,y - 1));

        colist.stream().map(o -> "(" + o.row + ","+ o.col + ")" ).forEach(System.out::println);

    }

    private static boolean isValid(int[][] board, int i, int y, int rows, int cols) {

        if (i >=0 && i < rows && y >=0 && y < cols && board[i][y] != -1 ) return true;
        return false;
    }
}
