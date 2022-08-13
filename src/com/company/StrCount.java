package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StrCount {
    public static void main(String[] args) {
         List<String> words = Arrays.asList("George", "Sandy", "James");

        /* thing you need to know is that flatMap is the function that you can use to convert
         the strings into individual characters. While regular map function just converts each stream
         element into a different element, flatMap converts each element into a stream of elements,
         then concatenates those streams together.
        The function that converts a String into a stream of characters is String.chars.

         When you want to build a new collection from a stream, you usually use a collector.
         Using the function Collectors.groupingBy you can produce a collector that will create a Map,
         given two functions, one to produce the key for each stream value, and the other to produce the value.
         There's a variant of this that will let you pass another collector in as the second parameter instead of
         a function; try Collectors.counting.
         */

        Map<Character, Long> myMap = words.stream().flatMapToInt(String::chars) //IntStream
                .mapToObj(c -> (char) c)     //Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        myMap.entrySet().stream().forEach(System.out::println);



    }
}
