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
        System.out.println(resultSet);
    }
}
