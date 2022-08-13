package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFlow {
    public static void main(String[] args) {

        String[] lines = {"The day began as still as the",
                "night abruptly lighted with",
                "brilliant flame"};

        String[] words = Arrays.stream(lines).map(s -> s.split(" ")).flatMap(Stream::of).toArray(String[]::new);

        List<String> result = new ArrayList<>();

        // Arrays.stream(words).forEach(System.out::println);

        int maxWidth = 24;

        int i = 0, n = words.length;

        while (i < n) {
            int j = i + 1;
            int linelength = words[i].length();

            while (j < n && (linelength + words[j].length() + (j - i - 1)) < maxWidth) {
                linelength += words[j].length();
                ++j;
            }
            int diff = maxWidth - linelength;
            int numOfWords = j - i;

            if (numOfWords == 1 || j >= n) result.add(leftJustify(words, diff, i, j));
            else result.add(middleJustify(words, diff, i, j));
            i = j;

        }
        result.stream().forEach(System.out::println);
    }

    private static String leftJustify(String[] words, int diff, int i, int j) {
        int spacesONRight = diff - (j - i - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            sb.append("-".repeat(spacesONRight));

        }
        return sb.toString();
    }

    private static String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraspaces = diff % spacesNeeded;
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i +1; k < j ; ++k) {
           int spacesToApply = spaces + (extraspaces-- > 0 ? 1: 0);
           sb.append("-".repeat(spacesToApply)).append(words[k]);
        }
        return sb.toString();
    }
    }
