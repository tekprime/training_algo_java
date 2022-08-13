package com.company;

import java.util.List;
import java.util.stream.Collectors;

public class TaxService {

    public static List<Employee> evaluateEmpTax () {

        return Database.getEmployees().stream().filter(employee -> employee.getSalary() > 10000).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println(evaluateEmpTax());
    }

}
