package com.company;

public class SingeBox {
    public static void main(String[] args) {
        int[][] image1 = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1}
        };

        int top_left_x = -1;
        int top_left_y = -1;
        int bottom_right_x = -1;
        int bottom_right_y = -1;

        int rows = image1.length;
        int cols = image1[0].length;

        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                if (image1[i][j] == 0) {
                    if (top_left_x == -1) {
                        top_left_x = i;
                        top_left_y = j;
                    }
                    bottom_right_x = i;
                    bottom_right_y = j;
                }
            }

        }
        System.out.println("top left x: " + top_left_x);
        System.out.println("top left y: " + top_left_y);
        System.out.println(" top right x: " + bottom_right_x);
        System.out.println("top left y: " + bottom_right_y);

        String result = "(" + top_left_x +")";
        System.out.println(result);



    }
}
