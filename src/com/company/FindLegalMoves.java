package com.company;

import java.sql.PseudoColumnUsage;
import java.util.HashSet;
import java.util.Set;

class Coords {
    int x;
    int y;
    Coords(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class FindLegalMoves {

    public static void main(String[] args) {

       int[][] board = {{0,  0,  0, -1, -1},
                        {0,  0, -1,  0,  0},
                        {0, -1,  0, -1,  0},
                        {0,  0, -1,  0,  0},
                        {0,  0,  0,  0,  0},
                        {0,  0,  0,  0,  0},
                        {0,  0,  0,  0,  0}};

       Coords start = new Coords(5,3);

        Set<Coords> setcoords = findLegalMoves(board, start);

        for(Coords co: setcoords){
            System.out.println("("+co.x+","+co.y+")");
        }


    }

    private static Set<Coords> findLegalMoves(int[][] board, Coords start) {
        int x = start.x;
        int y = start.y;
        Set<Coords> resultSet = new HashSet<>();
        if (isValid(board, x + 1, y))  resultSet.add(new Coords(x+1, y));
        if (isValid(board, x -1, y))  resultSet.add(new Coords(x-1, y));
        if (isValid(board, x, y - 1))  resultSet.add(new Coords(x, y - 1));
        if (isValid(board, x, y + 1))  resultSet.add(new Coords(x, y + 1));

       return resultSet;

    }

    private static boolean isValid(int[][] board, int x, int y) {
        int rows = board.length;
        int cols = board[0].length;

        if ( x >= 0 && x < rows  && y >= 0 && y < cols && board[x][y] != -1 ) return true;

        return false;


    }
}

