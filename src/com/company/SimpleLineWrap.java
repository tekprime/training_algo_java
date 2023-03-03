package com.company;

import java.util.ArrayList;
import java.util.List;

public class SimpleLineWrap {
    public static void main(String[] args) {
        String[] words1 = { "The", "day", "began", "as", "still", "as", "the",
                "night", "abruptly", "lighted", "with", "brilliant",
                "flame" };
        int maxLen = 13;
        List<String> result =new ArrayList<>();
        int i = 0, n = words1.length;


        while (i < n) {
            int j = i + 1;
            int lineLength = words1[i].length();
            while (j < n && (lineLength + words1[j].length() + (j-i-1)) < maxLen) {
                lineLength += words1[j].length();
                j++;
            }
            int diff = maxLen - lineLength;

            result.add(middleJustify(words1, diff, i, j));

            i = j;

        }


        System.out.println(result);


    }

    private static String middleJustify(String[] words1, int diff, int i, int j) {
        StringBuilder sb = new StringBuilder(words1[i]);
        for (int k = i + 1; k < j ; k++) {
            sb.append("_" + words1[k]);
        }
        return sb.toString();
    }
}
