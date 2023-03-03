package com.company;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class GetTheWordList {

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
                "A,45916054218" };

       int maxNum =  15;
       int maxLen = 5;

       Map<Long, String> countMap = new TreeMap<>(Collections.reverseOrder());

        for (String elm: counts
             ) {
            String[] elmArr = elm.split(",");
            long count = Long.valueOf(elmArr[1]);
            String word = elmArr[0];
            if ( word.length() <= 5 && word.length() >=2) {
                if(countMap.size() == 15) {
                    Long lastkey = ((TreeMap<Long, String>) countMap).lastKey();
                    if( lastkey < count) {
                        ((TreeMap<Long, String>) countMap).pollLastEntry();
                        countMap.put(count, word);
                    }

                } else countMap.put(count, word);
            }

        }
        Long lastkey = ((TreeMap<Long, String>) countMap).lastKey();
        System.out.println(lastkey);
        System.out.println(countMap);



        //
       // Map<Long, String> filteredMap = countMap.entrySet().stream().limit(15).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1,v2) ->v1, TreeMap::new));
       /* int i = 0;
        for (Map.Entry ent: countMap.entrySet()
             ) {
            System.out.println(ent.getValue()+ " : " + ent.getKey());
            i++;
            if (i == 15) break;
        }*/
        // System.out.println(filteredMap);
    }
}
