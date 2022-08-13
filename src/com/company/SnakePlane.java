package com.company;

import java.util.*;

public class SnakePlane {

    private static int rows;
    private  static int columns;

    public static void main(String[] args) {
        char[][] board1  = {
                {'+', '+', '+', '0', '+', '0', '0'},
                {'0', '0', '0', '0', '0', '0', '0'},
                {'0', '0', '+', '0', '0', '0', '0'},
                {'0', '0', '0', '0', '+', '0', '0'},
                {'+', '+', '+', '0', '0', '0', '+'}};

        rows = board1.length;
        columns = board1[0].length;

        System.out.println("num of rows " + rows +"num of col " + columns );


        Map<Integer,Set> mymap = findPassableLanes(board1);

        mymap.entrySet().stream().forEach(System.out::println);




        }

    private static Map findPassableLanes(char[][] board1) {

        Map<Integer, Set> allMap = new HashMap();
        Set<Integer> passRows = new HashSet();
        Set<Integer> passCols = new HashSet();

        for (int i = 0; i < rows ; i++) {
            boolean rowValid = true;
            int currentCol = 0;
            while(currentCol != columns) {
                if (board1[i][currentCol] != '0') {
                    rowValid = false;
                    break;
                }
                currentCol++;
            }
            if (rowValid) passRows.add(i);

        }
        allMap.put(0,passRows);


        for (int i = 0; i < columns ; i++) {
            boolean colValid = true;
            int currentRow = 0;
            while(currentRow != rows) {
                if (board1[currentRow][i] != '0') {
                    colValid = false;
                    break;
                }
                currentRow++;
            }
            if (colValid ) passCols.add(i);

        }
        allMap.put(1,passCols);

        return allMap;



    }
}

