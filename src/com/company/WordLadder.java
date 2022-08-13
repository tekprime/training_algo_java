package com.company;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
    String beginWord = "be", endWord = "ko";
    int numberOfSteps;
    List<String> wordList = new ArrayList<>(Arrays.asList("ce","mo","ko","me","co"));
    numberOfSteps = ladderLength(beginWord, endWord, wordList);
        System.out.println(numberOfSteps);
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> namesSet = new HashSet<>(wordList);
        if (!namesSet.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int changes = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size ; i++) {
              String word = queue.poll();
              if (word.equals(endWord)) return changes;

                for (int j = 0; j < word.length() ; j++) {
                    for (int k = 'a'; k < 'z' ; k++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) k;
                        String matchString = new String(arr);
                        if (namesSet.contains(matchString) && !visited.contains(matchString)) {
                            queue.add(matchString);
                            visited.add(matchString);
                        }


                    }
                }
            }
            ++changes;

        }

     return 0;

    }

}
