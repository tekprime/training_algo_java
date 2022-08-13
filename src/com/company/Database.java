package com.company;

import java.util.ArrayList;
import java.util.List;

public class Database {


    public static List<Employee> getEmployees() {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee(100, "iskandar", 10000));
        emps.add(new Employee(200, "Jeff", 4000));
        emps.add(new Employee(300, "Steve", 40000));
        return emps;
    }
}
