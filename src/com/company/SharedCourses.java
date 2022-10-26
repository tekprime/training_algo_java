package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
        Map<String, List<String>> resultSet = Arrays.stream(student_course).collect(groupingBy(ar -> ar[0], mapping(ar -> ar[1], toList())));

        /*for (Map.Entry me: resultSet.entrySet()
             ) {
            String currentStudent = (String) me.getKey();
            List<String> currentList = (List<String>) me.getValue();
            for (Map.Entry oe: resultSet.entrySet()) {
                String otherStudent = (String) oe.getKey();
                if (!otherStudent.equals(currentStudent)) {
                List<String> otherList = (List<String>) oe.getValue();*/

                /*    Set<String> result = list.stream()
                            .distinct()
                            .filter(otherList::contains)
                            .collect(Collectors.toSet());

                    Set<String> commonElements = new HashSet(Arrays.asList("red", "green"));

                    Assert.assertEquals(commonElements, result); */

                    // set1.retainAll(set2);
                    // set1.addAll(set2);





        System.out.println(resultSet);
    }
}
