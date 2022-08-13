package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EntriesWExits {

    public static void main(String[] args) {

        String[][] badge_records_1 = {
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Martha", "enter"},
                {"Steve", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "enter"},
                {"Paul", "enter"},
                {"Curtis", "exit"},
                {"Curtis", "enter"},
                {"Paul", "exit"},
                {"Martha", "enter"},
                {"Martha", "exit"},
                {"Jennifer", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Martha", "exit"},
                {"Paul", "enter"},
                {"Paul", "enter"},
                {"Paul", "exit"},
                {"Paul", "exit"}
        };

        Map<String, Long> exits = Arrays.stream(badge_records_1).filter(ar -> ar[1] == "exit")
                .collect(Collectors.groupingBy(ar -> ar[0], Collectors.counting()));

        System.out.println(exits);
        Map<String, Long> enters = Arrays.stream(badge_records_1).filter(ar -> ar[1] == "enter")
                .collect(Collectors.groupingBy(ar -> ar[0], Collectors.counting()));

        System.out.println(enters);
        List<String> ExitNames = new ArrayList<>();
        List<String> EnterNames = new ArrayList<>();









    }
}
