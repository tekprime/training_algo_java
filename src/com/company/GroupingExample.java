package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class GroupingExample {

    public static void main(String[] args) {
        String[][] events = {
                {"CONNECT", "Alice", "Bob"},
                {"DISCONNECT", "Bob", "Alice"},
                {"CONNECT", "Alice", "Charlie"},
                {"CONNECT", "Dennis", "Bob"},
                {"CONNECT", "Pam", "Dennis"},
                {"DISCONNECT", "Pam", "Dennis"},
                {"CONNECT", "Pam", "Dennis"},
                {"CONNECT", "Edward", "Bob"},
                {"CONNECT", "Dennis", "Charlie"},
                {"CONNECT", "Alice", "Nicole"},
                {"CONNECT", "Pam", "Edward"},
                {"DISCONNECT", "Dennis", "Charlie"},
                {"CONNECT", "Dennis", "Edward"},
                {"CONNECT", "Charlie", "Bob"}};
//        Map<String, Long> fromMap = Arrays.stream(events).filter(arr -> arr[0] == "CONNECT").collect(Collectors.groupingBy(arr -> arr[1], Collectors.counting()));
//        Map<String, Long> toMap = Arrays.stream(events).filter(arr -> arr[0] == "CONNECT").collect(Collectors.groupingBy(arr -> arr[2], Collectors.counting()));
//        fromMap.entrySet().stream().forEach(System.out::println);
//        toMap.entrySet().stream().forEach(System.out::println);
/*
        Map<String, Long> countMap = new HashMap<>();
        for (int i = 0; i < events.length ; i++) {
            if (events[i][0] == "CONNECT") {
                if (countMap.containsKey(events[i][1])) {
                    countMap.put(events[i][1], countMap.get(events[i][1]) + 1);
                } else countMap.put(events[i][1], 1L);
                if (countMap.containsKey(events[i][2])) {
                    countMap.put(events[i][2], countMap.get(events[i][2]) + 1);
                } else countMap.put(events[i][2], 1L);
            } else {
                if (countMap.containsKey(events[i][1])) {
                    countMap.put(events[i][1], countMap.get(events[i][1]) -1);
                } else countMap.put(events[i][1], 0L);
                if (countMap.containsKey(events[i][2])) {
                    countMap.put(events[i][2], countMap.get(events[i][2]) - 1);
                } else countMap.put(events[i][2], 0L);
            }


        }

        Map<Boolean, List<Map.Entry<String, Long>>> result = countMap.entrySet().stream().collect(Collectors.partitioningBy(e -> e.getValue() >= 3));
*/

//        result.entrySet().stream().forEach(System.out::println);

        //   Arrays.stream(events).flatMap(Arrays{m).forEach(System.out::println)
        String[][] ratings = {
                {"Alice", "Frozen", "5"},
                {"Bob", "Mad Max", "5"},
                {"Charlie", "Lost In Translation", "4"},
                {"Charlie", "Inception", "4"},
                {"Bob", "All About Eve", "3"},
                {"Bob", "Lost In Translation", "5"},
                {"Dennis", "All About Eve", "5"},
                {"Dennis", "Mad Max", "4"},
                {"Charlie", "Topsy-Turvy", "2"},
                {"Dennis", "Topsy-Turvy", "4"},
                {"Alice", "Lost In Translation", "1"}
        };
        String user = "Charlie";
        List<String> userTopRated = new ArrayList<>();
        List<String> userMovies = new ArrayList<>();



        for (int row = 0; row < ratings.length  ; row++) {
            if (ratings[row][0] == user) {
                userMovies.add(ratings[row][1]);
                if (Integer.parseInt(ratings[row][2]) >= 4) {
                    userTopRated.add(ratings[row][1]);
                }
            }
        }

       // userTopRated.stream().forEach(System.out::println);
       // userMovies.stream().forEach(System.out::println);

        Set<String> sharedUsers = new HashSet<>();

        for (int row = 0; row < ratings.length  ; row++) {
            if (Integer.parseInt(ratings[row][2]) >= 4 &&
                userTopRated.contains(ratings[row][1]) &&
                    ratings[row][0] != user) {
                sharedUsers.add(ratings[row][0]);
            }
        }
        Map<String, Set<String>> moviesToSuggest = new HashMap<>();
        for (String m: sharedUsers) {
            Set<String> userShares = new HashSet<>();
            for (int row = 0; row < ratings.length  ; row++) {
                if (ratings[row][0] == m && Integer.parseInt(ratings[row][2]) >= 4
                    && !userMovies.contains(ratings[row][1])) {
                    userShares.add(ratings[row][1]);
                }
            }
            moviesToSuggest.put(m, userShares);
        }
        moviesToSuggest.entrySet().stream().forEach(System.out::println);
       // sharedUsers.stream().forEach(System.out::println);



    }
}
