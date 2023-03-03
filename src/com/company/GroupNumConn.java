package com.company;

import java.util.HashMap;
import java.util.Map;

public class GroupNumConn {
    public static void main(String[] args) {

        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        String[][] events = {
                {"CONNECT","Alice","Bob"},
                {"DISCONNECT","Bob","Alice"},
                {"CONNECT","Alice","Charlie"},
                {"CONNECT","Dennis","Bob"},
                {"CONNECT","Pam","Dennis"},
                {"DISCONNECT","Pam","Dennis"},
                {"CONNECT","Pam","Dennis"},
                {"CONNECT","Edward","Bob"},
                {"CONNECT","Dennis","Charlie"},
                {"CONNECT","Alice","Nicole"},
                {"CONNECT","Pam","Edward"},
                {"DISCONNECT","Dennis","Charlie"},
                {"CONNECT","Dennis","Edward"},
                {"CONNECT","Charlie","Bob"}
        };

        int connRange = 3;

        Map<String, Integer> connCountMap = new HashMap<>();

        for (String[] event : events) {
            String action = event[0];
            String first_user = event[1];
            String second_user = event[2];

            if(action.equals("CONNECT")) {
                int count = connCountMap.containsKey(first_user) ? connCountMap.get(first_user) + 1: 1;
                connCountMap.put(first_user, count);
                int count2 = connCountMap.containsKey(event[2]) ? connCountMap.get(event[2]) + 1: 1;
                connCountMap.put(event[2], count2);}
            else {
                int count = connCountMap.containsKey(event[1]) ? connCountMap.get(event[1]) - 1: 0;
                connCountMap.put(event[1], count);
                int count2 = connCountMap.containsKey(event[2]) ? connCountMap.get(event[2]) -1 : 0;
                connCountMap.put(event[2], count2);
            }

        }
        System.out.println(connCountMap);


    }

}
