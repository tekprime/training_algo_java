package com.company;

import java.util.HashSet;
import java.util.Set;

public class SubSoduku {
    public static void main(String[] args) {
        int[][] board = {{1, 2, 3},
                {3, 2, 2},
                {2, 3, 1}};

        int n = board.length;

        Set<Integer> refSet = new HashSet<>();

        boolean isValid = true;

        for (int index = 1; index <= n; index++) {
            refSet.add(index);
        }


        outer: for (int row = 0; row < n; row++) {
            Set<Integer> currSet = new HashSet<>();
            for (int col = 0; col < n; col++) {
                currSet.add(board[row][col]);
            }
            if(!currSet.equals(refSet)) {
                isValid = false;
                break outer;
            }

        }
        if (isValid) System.out.println("true");
        else System.out.println("false");


    }
    }

