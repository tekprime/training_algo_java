package com.company;

import java.util.HashMap;
import java.util.Map;

public class DomainCount {
    public static void main(String[] args) {

        Map<String, Integer> countMap = new HashMap<>();

        String[] counts = {"900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"};

        for (String entry : counts) {
            String[] earr = entry.split(",");
            int entryCount = Integer.parseInt(earr[0]);
            String currDomains = earr[1];
            String[] darr = currDomains.split("\\.");
            int i = darr.length;
            StringBuilder sb = new StringBuilder("");
            while ( i != 0) {
                String domain = darr[i -1];
                sb.insert(0,domain);
                String keyString = sb.toString();
                if(countMap.containsKey(keyString)) {
                    int oldCount = countMap.get(keyString);
                    oldCount += entryCount;
                    countMap.put(keyString, oldCount);

                } else {
                    countMap.put(keyString, entryCount);
                }
                sb.insert(0,".");
                i--;

            }



        }
        System.out.println(countMap);


    }
}
