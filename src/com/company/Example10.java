package com.company;


import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Example10 {
    public static void main(String[] args) {

        List<String> listString = Arrays.asList("David", "Sam", "Mona");

        List<String> resp = listString.stream().collect(Collectors.toList());

        Set<String> resp1 = listString.stream().collect(Collectors.toSet());

        System.out.println("test");


    }
}



