package com.company;

public class ScheduleAnAppt {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");


        int[][] meetings = {
                {1230, 1300},
                {845, 900},
                {1300, 1500}};

        int begin_time = 850;
        int end_time = 1240;

        boolean isAvailabe = true;

        for (int[] meeting : meetings) {
            if ((begin_time >= meeting[0] && begin_time <= meeting[1]) || (end_time >= meeting[0] && end_time <= meeting[1])) {
                isAvailabe = false;
                break;
            }


        }
        System.out.println(isAvailabe ? "TRUE" : "FALSE");
    }
}





