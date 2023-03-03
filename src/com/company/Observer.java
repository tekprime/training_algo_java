package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Observer {

    public static void main(String[] argv) throws ParseException {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        int[] sightings1 = {2130, 1855, 1902, 2001, 2200};

        int[][] flights1 = { {1850, 15},
                {2130, 1},
                {2218, 10},
                {1959, 3}
        };

        Set<Integer> sightSet = new HashSet(Arrays.asList(sightings1));

        Set<Integer> flightsSet = buildFlightsSeeing(flights1);

        Set<Integer> sightsSet = Arrays.stream(sightings1).boxed().collect(Collectors.toSet());


        //sightsSet.removeAll(flightsSet);

        System.out.println(sightsSet);


    }

    private static  Set<Integer> buildFlightsSeeing(int[][] flights1) throws ParseException {
        Set<Integer> flightsSet = new LinkedHashSet();
        for (int[] elm : flights1) {
            int time = elm[0];
            int minutes = elm[1];
            getTimes(flightsSet, time, minutes);

        }
        return flightsSet;

    }

    private static void getTimes(Set<Integer> flights, int time, int minutes) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");

        Date date = sdf.parse(String.valueOf(time));
        int i = 0;
        while(i < minutes) {
            long new_time = date.getTime() + (i*60*1000);
            Date new_date = new Date(new_time);
            String dateStr = sdf.format(new_date);
            flights.add(Integer.parseInt(dateStr));
            i++;
        }




    }


}
