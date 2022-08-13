package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FrequentGroups {
    public static void main(String[] args) {
        String[][] badge_records2 = {
                {"Paul", "1545", "exit"},
                {"Curtis", "1410", "enter"},
                {"Curtis", "222", "enter"},
                {"Curtis", "1630", "exit"},
                {"Paul", "10", "enter"},
                {"Paul", "1410", "enter"},
                {"John", "330", "enter"},
                {"Jennifer", "330", "enter"},
                {"Jennifer", "1410", "exit"},
                {"John", "1410", "exit"},
                {"Curtis", "330", "exit"},
                {"Paul", "330", "exit"},
        };

        System.out.println("2 dimentional array before sorting: " + Arrays.deepToString(badge_records2));

      Arrays.sort(badge_records2, Comparator.comparingInt(o -> Integer.parseInt(o[1])));
    //    List<String[]> result = Arrays.stream(badge_records2).sorted(Comparator.comparingInt(o -> Integer.parseInt(o[1]))).collect(Collectors.toList());

        System.out.println("2 dimentional array after sorting: " + Arrays.deepToString(badge_records2));

        // result.stream().flatMap(Stream::of).forEach(System.out::print);

    }
}


