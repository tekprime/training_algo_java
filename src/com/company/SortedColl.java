package com.company;



import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class SortedColl {

    private static int NUMBER_OF_LETTERS = 26;

    public static void main(String[] args) {
        String[] counts = {
                "POINT,333858038",
                "NOT,4522732626",
                "INTO,1144226142",
                "ON,4594521081",
                "FOR,6545282031",
                "NOW,679337516",
                "ONE,2148983086",
                "BEHAVIOR,104177552",
                "WAITS,2911079",
                "PEOPLE,658716166",
                "HI,15453893",
                "FORM,352032932",
                "OF,30966074232",
                "THROUGH,647091198",
                "BETWEEN,744064796",
                "FOUR,262968583",
                "LEFT,306802162",
                "OFF,302535533",
                "FROM,3469207674",
                "NO,1400645478",
                "FORMS,136468034",
                "A,45916054218"};

        int maxlength = 5;

       String[][] wordlist = {
        {"OF",    "30966074232"},
        {"FOR",   "6545282031"},
        {"ON",    "4594521081"},
        {"NOT",   "4522732626"},
        {"FROM",  "3469207674"},
        {"ONE",   "2148983086"},
        {"NO",    "1400645478"},
        {"INTO",  "1144226142"},
        {"NOW",   "679337516"},
        {"FORM",  "352032932"},
        {"POINT", "333858038"},
        {"LEFT",  "306802162"},
        {"OFF",   "302535533"},
        {"FOUR",  "262968583"},
        {"FORMS", "136468034"} };

/*
         List < String[]> result = Arrays.stream(counts).map(x -> x.split(",")).filter(arr -> arr[0].length() <= maxlength).
                sorted(Comparator.comparingLong(arr -> Long.parseLong(arr[1]))).collect(Collectors.toList());
        Collections.reverse(result);
        List<String[]> finalresult = result.stream().limit(5).collect(Collectors.toList());
*/
        List<String> uselist = Arrays.stream(wordlist).map(arr -> arr[0]).collect(Collectors.toList());
/*        Map<String, List<String>> anagramsMap = findAnagrams(uselist);

        System.out.println(anagramsMap);
        Map<String, List<String>> resultmap = new HashMap<>();

        for (Map.Entry<String, List<String>> entry: anagramsMap.entrySet()){
            String anagramkey = entry.getKey(); // anagram
            List<String> anaglist = entry.getValue(); // words belongs together

            List<String> resultList = new ArrayList<>();
            List<String> eachwordlist = new ArrayList<>();

            for (String word: anaglist){
                eachwordlist.add(word);
                for (int k = 'A'; k < 'Z'; k++) {
                    StringBuilder possibleword = new StringBuilder();
                    possibleword.append(word);
                    possibleword.append((char) k);
                    String possibleString = possibleword.toString();
                    if (uselist.contains(possibleString)) resultList.add(possibleString);

                }

                for (String e:eachwordlist){
                    resultmap.put(word, resultList);
                }

            }
        }
        System.out.println(resultmap);*/

        Map<String, List<String>> stepsMap = new HashMap<>();

        for (String word : uselist) {

            if (!stepsMap.containsKey(word)){
                List<String> listofwords = new ArrayList();
                for (String inputword : uselist) {
                    if (inputword.equals(word)) continue;
                    int[] chrarr1 = getCharCounts(inputword);
                    int[] chrarr2 = getCharCounts(word);
                    int delta = deltaDiff(chrarr1, chrarr2);
                    //if((delta == 1) && (inputword.length() > word.length())) listofwords.add(inputword);
                    if(delta == 1)  listofwords.add(inputword);
                }
                stepsMap.put(word,listofwords);
            }

        }
        System.out.println(stepsMap);


        String s1 = "NO";
        String s2 = "NOT";
        int[] chrarr1 = getCharCounts(s1);
        int[] chrarr2 = getCharCounts(s2);

        int delta = deltaDiff(chrarr1, chrarr2);

        System.out.println("done: " + delta);
    }
    private static Map<String, List<String>> findAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        if(words.isEmpty() || words == null) return anagrams;

        for (String word: words) {
            char[] wordCharArr = word.trim().toCharArray();
            Arrays.sort(wordCharArr);
            String sortedWord = new String(wordCharArr);

            if (anagrams.containsKey(sortedWord)) {
                List<String> listofwords = anagrams.get(sortedWord);
                listofwords.add(word);
                anagrams.put(sortedWord,listofwords);

            } else{
                List<String> newlist = new ArrayList<>();
                newlist.add(word);
                anagrams.put(sortedWord, newlist);
            }
        }
     return anagrams;
    }

    public static int[] getCharCounts(String s) {
       int[] characterCount = new int[NUMBER_OF_LETTERS];
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            int offset = c - (int) 'A';
            characterCount[offset]++;

        }
      return characterCount;
    }

    public static int deltaDiff(int[] charArr1, int[] charArr2){
        int delta = 0;
        for (int i = 0; i < charArr1.length ; i++) {
            int difference = charArr2[i] - charArr1[i];
            delta += difference;


        }
        return delta;
    }
}
