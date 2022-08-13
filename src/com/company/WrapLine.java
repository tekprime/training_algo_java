package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WrapLine {
    public static void main(String[] args) {
        List<String> words1 = Arrays.asList("The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant",
                "flame");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder("");

        for (String word : words1) {

            if (sb.length() + word.length() <= 13) sb.append(word).append('-');
            else {
                sb.deleteCharAt(sb.length() - 1);
                result.add(sb.toString());
                sb = new StringBuilder(word);
                sb.append("-");
            }
            if (words1.get(words1.size()-1).equals(word)) result.add(word);
        }
        result.stream().forEach(System.out::println);
    }
}
