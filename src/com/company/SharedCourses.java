package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;


public class SharedCourses {
    public static void main(String[] args) {
        String[][] student_course = {
                 {"58", "Linear Algebra"},
                 {"94", "Art History"},
                 {"94", "Operating Systems"},
                 {"17", "Software Design"},
                 {"58", "Mechanics"},
                 {"58", "Economics"},
                 {"17", "Linear Algebra"},
                 {"17", "Political Science"},
                 {"94", "Economics"},
                 {"25", "Economics"},
                 {"58", "Software Design"},
};
        // Map<String, List<String>> groupingSet = Arrays.stream(student_course).collect(groupingBy(ar -> ar[0], mapping(ar -> ar[1], toList())));
        Map<String, Set<String>>  resultMap = new HashMap<>();
        Map<String, Set<String>> groupMap =
                Arrays.stream(student_course).
                        collect(groupingBy(ar -> ar[0], mapping(ar->ar[1], toSet())));
        List<String> ListofKeys = groupMap.keySet().
                stream().collect(Collectors.toCollection(ArrayList::new));

        List<String> Listof = new ArrayList(groupMap.keySet());

        System.out.println(groupMap);

        for (int i = 0; i < ListofKeys.size() ; i++) {
            String firstStudent = ListofKeys.get(i);
            Set<String> firstCourses = groupMap.get(firstStudent);
            for (int j = i+1; j < ListofKeys.size() ; j++) {
                String secondStudent = ListofKeys.get(j);
                Set<String> secondCourses = groupMap.get(secondStudent);
                String pair = firstStudent + "," + secondStudent;
                Set<String> intersection = new HashSet<>(secondCourses);
                intersection.retainAll(firstCourses);
                resultMap.put(pair, intersection);

            }

        }

         /* for (Map.Entry me: groupMap.entrySet()
             ) {
              String currentStudent = (String) me.getKey();
              Set<String> currentCourseSet = (Set<String>) me.getValue();
              for (Map.Entry oe : groupMap.entrySet()) {
                  String otherStudent = (String) oe.getKey();
                  if (!otherStudent.equals(currentStudent)) {
                      Set<String> otherList = (Set<String>) oe.getValue();
                      int[] pairKey = new int[2];
                      pairKey[0] = Integer.parseInt(currentStudent);
                      pairKey[1] = Integer.parseInt(otherStudent);
                      Set<String> intersection = new HashSet<>(otherList);
                      intersection.retainAll(currentCourseSet);
                      if (!resultMap.containsKey(pairKey)) resultMap.put(pairKey, intersection);

                  }

              }
          }*/



        System.out.println(resultMap);
    }
}
