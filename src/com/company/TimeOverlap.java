package com.company;

import java.time.temporal.ValueRange;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeOverlap {

    public static void main(String[] args) {
        /*final int[][] meetings =  { {1230, 1300}, // 12:30 PM to 1:00 PM
                                    {845, 900},   //  8:45 AM to 9:00 AM
                                    {1300, 1500}}; //  1:00 PM to 3:00 PM

        int startTime = 1501;
        int endTime = 1800;
        ValueRange range = ValueRange.of(startTime, endTime);
         boolean validRange = true;
        for (int row = 0; row < meetings.length; row++) {
            if(range.isValidIntValue(meetings[row][0]) ||
                    range.isValidIntValue(meetings[row][1])) validRange = false;

        }
        System.out.println(validRange};*/
        int[][] p1_meetings = {
                {1230, 1300},
                {845, 900},
                {1300, 1500},
        };

        int[][] p2_meetings = {
                {0, 844},
                {930, 1200},
                {1515, 1546},
                {1600, 2400},
        };

        int[][] p3_meetings = {
                {845, 915},
                {1515, 1545},
                {1235, 1245},
        };

        int[][] p4_meetings = {
                {1, 5},
                {844, 900},
                {1515, 1600}
        };

    List<int[][]> schedule = new ArrayList<>();
    schedule.add(p1_meetings);
    findAvailableTimes(schedule);

    }

    public static void findAvailableTimes(List<int[][]> schedules) {
        int start = 0;
        int end = 2400;
        List<Map.Entry<Integer, Integer>> list = schedules.stream().flatMap(Stream::of)
                .map(x -> new AbstractMap.SimpleEntry<Integer, Integer>(x[0], x[1]))
                .sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList());

        for (Map.Entry<Integer, Integer> entry : list) {
            Integer key = entry.getKey();
            Integer val = entry.getValue();
            if (start < key) {
                System.out.println("Free time [" + start + "," + key + "]");
            }
            if (start < val) {
                start = val;
            }
        }
        if (start < end) {
            System.out.println("Free time [" + start + "," + end + "]");
        }
    }
}
