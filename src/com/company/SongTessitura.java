package com.company;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class SongTessitura {

    public static void main(String[] argv) {
        System.out.println("Hello, world!");
        System.out.println("This is a fully functioning Java environment.");

        char[] pitch = new char[]{'C', 'D', 'E', 'F', 'G', 'A', 'B'};
        int[] octave = new int[] {0,1,2,3,4,5,6,7};

        String[] song1= {"F4", "B4", "C5"};


        // C0, D0, E0, ... C1, D1,.... C2, C3, C4, ... C7...B7

        // A4,

        Map<String, Integer> notes_map = buildNotesMap(pitch, octave);

        System.out.println(notes_map);


     /*   String lowest_note = "F4";

        String highest_note = "C5";

        if (isInRange(notes_map, song1, lowest_note, highest_note)) System.out.println("true");
        else System.out.println("false");*/

    }

    private static boolean isInRange( Map<String, Integer> notes_map, String[] song1, String lowest_note, String highest_note) {

        int lower_num = notes_map.get(lowest_note);
        int higher_num = notes_map.get(highest_note);

        boolean canPerform = true;

        for (String note : song1) {
            int current_num =  notes_map.get(note);

            if (lower_num > current_num || current_num > higher_num) canPerform = false;
        }
        return canPerform;
    }

    private static Map<String, Integer> buildNotesMap(char[] pitch, int[] octave) {

        Map<String, Integer> notes_map = new HashMap<>();



        int index = 1;

        for (int i = 0; i < octave.length; i++) {
            for (int j = 0; j < pitch.length; j++) {
                String current_note = new StringBuilder().append(pitch[j]).append(String.valueOf(octave[i])).toString();
                notes_map.put(current_note, index);
                index++;

            }

        }
        LinkedHashMap<String, Integer> new_map = notes_map.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));
        return new_map;
    }


}
