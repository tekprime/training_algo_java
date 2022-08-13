package com.company;



import javax.swing.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortListDemo {


    public static void main(String[] args) {

        List<String> mylist = Arrays.asList("string1", "string2");

        for (String word : mylist) {
            System.out.println("word " + word);
        }

        mylist.stream().forEach(System.out::println);

        Map<Integer, String> mymap = new HashMap<>();

        mymap.entrySet().stream().forEach(obj -> System.out.println(obj.getKey()));

        List<Employee> employees = Database.getEmployees();

        employees.stream().sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        Map<Integer, Employee> empmap = new TreeMap<>();

        empmap.put(100, new Employee(100, "iskandar", 1000));
        empmap.put(100, new Employee(100, "milia", 5000));
        empmap.put(100, new Employee(100, "louie", 10000));

//        empmap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.comparing()).forEach(System.out::println);

        List<String> list3 = Stream.of(new Employee(100, "iskandar", 1000),
                             new Employee(101, "milia", 5000)).map(e -> e.getName()).collect(Collectors.toList());
        Set<String> uniqueNames = new HashSet<>();
        Set<String> duplicateNames = list3.stream().filter(empname -> !uniqueNames.add(empname)).collect(Collectors.toSet());
        Map<String, Long> countingmap = list3.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Set<String> dset = countingmap.entrySet().stream().filter(entry -> entry.getValue() > 1).map(entry -> entry.getKey()).collect(Collectors.toSet());
        list3.stream().filter(name -> Collections.frequency(list3, name) > 1).collect(Collectors.toSet());

    }
}


    /*static <Target, ExpObj extends Exception> Consumer<Target> handleGenericException(Consumer<Target> targetConsumer, Class<ExpObj> expObjClass) {
        return obj -> {
            try {
                targetConsumer.accept(obj);
            } catch(Exception exp){
                try {
                    ExpObj expObj = expObjClass.cast(exp);
                    System.out.println("exception: " + exp.getMessage());
                } catch (ClassCastException excp) {
                    throw excp;
                }
            }
        }*/
