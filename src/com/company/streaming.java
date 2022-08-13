package com.company;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;


public class streaming {


    public static void main(String[] args) {

        // Stream.of("ava","james","trudo").sorted().findFirst().ifPresent(System.out::println);
       /* String[] names = {"Al", "boss", "jay"};
        Arrays.stream(names).filter(x -> x.startsWith("b")).sorted().forEach(System.out::println);
        Arrays.stream(new int[] {1,2,4}).map(x -> x * x).average().ifPresent(System.out::println);
        List<String> people = Arrays.asList("Alex","Sam","Steve");
        people.stream().map(String::toLowerCase).filter(x->x.startsWith("a")).forEach(System.out::println);

        try {
            Stream<String> bands = Files.lines(Paths.get("sample.txt"));
            bands.sorted().filter(x->x.length() > 12).forEach(System.out::println);

            List<String> bands2 = Files.lines(Paths.get("sample.txt")).filter(x->x.contains("Alex")).collect(Collectors.toList());
            bands2.forEach(System.out::println);

            Stream<String> rows1 = Files.lines(Paths.get("data.txt"));

            int rowCount = (int) rows1.map(x->x.split(",")).filter(x->x.length ==3).count();
            System.out.println(rowCount +  "rows." );
            rows1.close();

        } catch (IOException e)

    } */

        // int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
      /*  int[][] arr = {{1,2,3}, {4,5,6}};

        final IntStream intStream = range(0,arr.length).flatMap(row -> range(0,arr[row].length).map(col-> {
            final int element = arr[row][col];
        }))
        final IntStream intStream = range(0, arr.length).flatMap(row -> range(0, arr[row].length).map(col -> {
            final int element = arr[row][col];
            // E.g. multiply elements in odd numbered rows and columns by two.
            return row % 2 == 1 || col % 2 == 1 ? element * 2 : element;
        }));
        // Prints "1 4 3 8 10 12 7 16 9 ".
        intStream.forEachOrdered(n -> System.out.print(n + " "));
        System.out.println("test");




        String[][] scores = { { "Amit,", "70" } { "Arthit", "60" }, { "Peter", "60" }, { "Arthit", "100" } };
        Map<String, Double> collect = Arrays.stream(scores)
                .collect(Collectors.groupingBy(ar -> ar[0],
                        Collectors.averagingDouble(ar -> Integer.parseInt(ar[1])))
                );


        Map.Entry<String, Double> entry = collect.entrySet().stream()
                .max(Map.Entry.comparingByValue(Comparator.comparingDouble(e -> e.doubleValue())))
                .get();*/

        String[][] scores = {{"Amit,", "70"}, {"Arthit", "60"}, {"Peter", "60"}, {"Arthit", "100"}};
        Map<String, Double> collect = Arrays.stream(scores)
                .collect(Collectors.groupingBy(ar -> ar[0], Collectors.averagingDouble(ar -> Integer.parseInt(ar[1]))
                ));

        System.out.println("scores: " + collect);

        /* Map.Entry<String, Double> entry = collect.entrySet().stream()
                .max(Map.Entry.comparingByValue(Comparator.comparingDouble(e -> e.doubleValue())))
                .get();*/

        Map.Entry<String, Double> entry = collect.entrySet().stream().max(Map.Entry.comparingByValue(Comparator.comparingDouble(e -> e.doubleValue()))).get();

        System.out.println("key:"+ entry.getKey() + "value" + entry.getValue());

    }
}