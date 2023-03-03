package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class BuildABot {
    public static void main(String[] args) {
     String[]   all_parts = {
                "Rocket_claw",
                "Rocket_sensors",
                "Dustie_case",
                "Rust_sensors", //
                "Bolt_sensors", //
                "Rocket_case",
                "Rust_case",
                "Bolt_speaker",
                "Rocket_wheels",
                "Rocket_speaker",
                "Dustie_case",
                "Dustie_arms",
                "Rust_claw",
                "Dustie_case",
                "Dustie_speaker",
                "Bolt_case",
                "Bolt_wheels",
                "Rust_legs",
                "Bolt_sensors"};

        String required_parts_1 = "sensors,case,speaker,wheels";

        Set<String> required_parts = buildRequired(required_parts_1);

        System.out.println(required_parts);

        Map<String, Set> robots_map = buildRobotMap(all_parts, required_parts );

        List<String> result = robots_map.entrySet().stream().filter( e-> e.getValue().size() == required_parts.size()).map(e -> e.getKey()).collect(Collectors.toList());

        System.out.println(robots_map);

        System.out.println(result);


    }

    private static Map<String, Set> buildRobotMap(String[] all_parts, Set<String> required_parts) {

        Map<String, Set> robotMap = new HashMap<>();
        for (String elm: all_parts
             ) {
            String[] elArr = elm.split("_");
            String robot = elArr[0];
            String part = elArr[1];
            if (required_parts.contains(part)) {

                if (robotMap.containsKey(robot)) {
                    Set<String> robot_parts = robotMap.get(robot);
                    robot_parts.add(part);
                    robotMap.put(robot, robot_parts);
                } else {
                    Set<String> robot_parts = new HashSet<>();
                    robot_parts.add(part);
                    robotMap.put(robot, robot_parts);
                }
            }

            }

        return robotMap;
    }

    private static Set<String> buildRequired(String required_parts_1) {


        String[] arr = required_parts_1.split(",");
        Set<String> requiredSet = new HashSet<>(Arrays.asList(arr));
        return requiredSet;

    }
}
