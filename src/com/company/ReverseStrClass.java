package com.company;



import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ReverseStrClass {
    public static void main(String[] args) {
        String revString = "Reverse This String";

        System.out.println("rev string " + revString);

        String[] revStringArr = revString.split(" ");

        // String reversedString = "";

    String reversedString = Arrays.stream(revStringArr).map(word -> new StringBuffer(word).reverse().toString()).collect(Collectors.joining(" "));
//        String reversedString = Arrays.stream(revStringArr).map(word -> new StringBuffer(word).reverse().toString()).collect(Collectors);
//        String finalstring = "";
//        StringBuilder strbld = new StringBuilder();
////        reversedList.stream().map(word -> strbld.append(word)).collect();
//
////        System.out.println(finalstring);
//        for (String word:revStringArr) {
//
//            String revWord = "";
//
//            for (int i = word.length() -1; i >= 0 ; i--) {
//              revWord = revWord + word.charAt(i);
//
//            }
//            reversedString = reversedString + revWord + " ";
//
//        }
        System.out.println("reversed string " + reversedString);

//        Set<Character> myset = findDuplicateChar(reversedString);

    }


}
