package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Observer {
    public static void main(String[] args) throws ParseException {
        int time = 1850;
        int min = 15;
        Set<Integer> sightSet = new HashSet<>(Arrays.asList(1858, 1903, 1300));
        Set<Integer> flightsSet = new LinkedHashSet<>();

        DateFormat dateFormat = new SimpleDateFormat("HHmm");
        Date date = dateFormat.parse(String.valueOf(1850));
        int i = 0;
        while(i < 15) {
            long newtime = date.getTime() + (i * 60 * 1000);
            Date newDate = new Date(newtime);
            String dateToString = dateFormat.format(newDate);
            flightsSet.add(Integer.parseInt(dateToString));
            i++;
        }
        sightSet.removeAll(flightsSet);

        System.out.println(sightSet);
        }



}
