package com.company;

public class DuplicateNumbers {
    public static void main(String[] args) {
     int arr[] = new int[]{0,2,3,2,4};
        System.out.println("The duplicate Number is: " + findDuplicate(arr) );
    }

    private static int findDuplicate(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            System.out.println("index: " + index);
            System.out.println(" arr index " + arr[index]);
            if(arr[index] < 0) {
                return Math.abs(arr[i]);
            }
            arr[index] = -arr[index];
        }
        return -1;
    }

}
