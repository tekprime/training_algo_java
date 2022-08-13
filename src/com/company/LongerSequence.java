package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongerSequence {

    public static void main(String[] args) {
        String[] user0 = {"/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two"};
        String[] user1 = {"/start", "/pink", "/register", "/orange", "/red", "a"};

        /*Map<Integer, String> firstUserMap = new HashMap<>();

        for (int i = 0; i < user0.length; i++) firstUserMap.put(i, user0[i]);

        int index = 0;
        List<String> matchingSeq = new ArrayList<>();
        int previousCount = 0;
        int matchCount = 0;

        matchingSeq = getMatches(firstUserMap, 0, user1);
        previousCount = matchingSeq.size();

        while (index < user1.length) {
            index++;
            List<String> matchSeq = new ArrayList<>();
            matchSeq = getMatches(firstUserMap, index, user1);
            matchCount = matchSeq.size();
            if (previousCount > matchCount) matchSeq.clear();
            previousCount = matchCount;
        }*/

        List result = longestCommonSubarray(user0, user1);

        result.stream().forEach(System.out::println);

        }
    private static List longestCommonSubarray(String[] s1, String[] s2) {

        List result = new ArrayList();
        int n = s1.length, m = s2.length, max = 0, maxi = 0;
        int[][] dp = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            for(int j =1; j <= m; j++ ) {
                if(s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i-1][j -1] + 1;
                    if(dp[i][j] > max) {
                        max = dp[i][j];
                        maxi = i;
                    }
                }
            }
        }
        for(int k = maxi - max; k < maxi; k++) {
            result.add(s1[k]);
        }
        return result;
    }

    


    /*private static int getKey(Map<Integer, String> map, String value) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return 0;
    }

    private static List<String> getMatches(Map<Integer, String> firstUMap, int index,String[] secondUserAr) {
        List<String> resultlist = new ArrayList<>();
        if (firstUMap.containsValue(secondUserAr[index])) {
            int matchKey = getKey(firstUMap, secondUserAr[index]);
            boolean matchfound = true;
            resultlist.add(secondUserAr[index]);
            int offset = index;
            while (matchfound && offset < secondUserAr.length && matchKey < firstUMap.size()) {
                offset++;
                matchKey++;
                if (firstUMap.get(matchKey) == secondUserAr[offset]) {
                    resultlist.add(secondUserAr[offset]);
                    matchfound = true;
                } else {
                    matchfound = false;
                }


            }
        }
        return resultlist;
    }*/
}
