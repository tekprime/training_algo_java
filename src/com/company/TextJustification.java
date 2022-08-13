package com.company;

import java.util.ArrayList;
import java.util.List;


public class TextJustification {
    public static void main(String[] args) {
        String[] words = {"This", "is", "a", "justification", "problem"};
        List<String> result = new ArrayList<>();
        int i = 0, n = words.length;
        int maxWidth = 15;

        while (i < n) {
            int j = i + 1;
            int lineLength = words[i].length();
            while (j < n && (lineLength + words[j].length() + (j - i - 1) < maxWidth)) {
                lineLength +=  words[j].length();
                ++j;
            }
            int diff = maxWidth - lineLength;
            int numOfWords = j - i;

            if (numOfWords == 1 || j >= n) result.add(leftJustify(words, diff, i, j));
            else result.add(middleJustify(words, diff, i, j));

            i = j;
        }
        result.stream().forEach(System.out::println);
    }

    private static String middleJustify(String[] words, int diff, int i, int j) {
        int spacesNeeded = j - i - 1;
        int spaces = diff / spacesNeeded;
        int extraSpaces = diff % spacesNeeded;
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            int spacesToApply = spaces + (extraSpaces-- > 0 ? 1 : 0);
            sb.append(" ".repeat(spacesToApply) + words[k]);
        }
        return sb.toString();
    }


    private static String leftJustify(String[] words, int diff, int i, int j) {
        int spacesONRight = diff - (j - i - 1);
        StringBuilder sb = new StringBuilder(words[i]);
        for (int k = i + 1; k < j; ++k) {
            sb.append(" ".repeat(spacesONRight));

        }
        return sb.toString();
    }
}
