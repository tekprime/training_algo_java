package com.company;

public class TranspositionCipher {
    public static void main(String[] args) {

        String message1 = "One does not simply walk into Mordor";
        int rows = 6;
        int cols = 6;
        StringBuilder result = new StringBuilder();
        int i = 0;
        while ( i < 6){

            int j = i;
            while( j < message1.length()) {
                result.append(message1.charAt(j));
                j = j + 6;

            }
            i++;
        }
        System.out.println(result.toString());
    }
}
