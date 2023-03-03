package com.company;

import java.util.*;
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

        // Paul enter,

        Set<String> current_in = new HashSet<>();
        Set<String> enter_no_exit = new HashSet<>();
        Set<String> exit_no_enter = new HashSet<>();

        for (String[] entry : badge_records_1
             ) {
            if (entry[1] == "enter"){
                if(current_in.contains(entry[0])) {
                    enter_no_exit.add(entry[0]);
                   // current_in.remove(entry[0]);
                } else current_in.add(entry[0]);
            } else {
                if (current_in.contains(entry[0]))  current_in.remove(entry[0]);
                else exit_no_enter.add(entry[0]);
            }
        }
        System.out.println(current_in);

        enter_no_exit.addAll(current_in);

        System.out.println(enter_no_exit);
        System.out.println(exit_no_enter);

       /* Map<String, Long> exits = Arrays.stream(badge_records_1).filter(ar -> ar[1] == "exit")
                .collect(Collectors.groupingBy(ar -> ar[0], Collectors.counting()));

        System.out.println(exits);
        Map<String, Long> enters = Arrays.stream(badge_records_1).filter(ar -> ar[1] == "enter")
                .collect(Collectors.groupingBy(ar -> ar[0], Collectors.counting()));

        System.out.println(enters);
        List<String> ExitNames = new ArrayList<>();
        List<String> EnterNames = new ArrayList<>();*/









    }
}
