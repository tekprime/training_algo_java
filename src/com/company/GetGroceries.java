package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class GetGroceries {

    public static void main(String[] args) {
        String[][] products = {
                {"Cheese",          "Dairy"},
                {"Carrots",         "Produce"},
                {"Potatoes",        "Produce"},
                {"Canned Tuna",     "Pantry"},
                {"Romaine Lettuce", "Produce"},
                {"Chocolate Milk",  "Dairy"},
                {"Flour",           "Pantry"},
                {"Iceberg Lettuce", "Produce"},
                {"Coffee",          "Pantry"},
                {"Pasta",           "Pantry"},
                {"Milk",            "Dairy"},
                {"Blueberries",     "Produce"},
                {"Pasta Sauce",     "Pantry"}};
      String[]  list1 = {"Blueberries", "Milk", "Coffee", "Flour", "Cheese", "Carrots"};
      Map<String, String> prodMap = parseMap(products);

     //  int numRegVisit = list1.length;
      int impCount = getOptCount(prodMap, list1);
       // System.out.println("number of reg visit: " + numRegVisit);
       // System.out.println("number of opt visit: " + numOptVisit);
     // int impCount = (numRegVisit - numOptVisit);

        System.out.println(impCount);

    }

    private static int getOptCount(Map<String, String> prodMap, String[] list1) {

        HashSet<String> deptVisited = new HashSet<>();
        int deptChanges = 0;
        String dept = "";
        String prev_dept = "";
        for (String prod: list1
             ) {
            dept = prodMap.get(prod);
            deptVisited.add(dept);
            if (!dept.equals(prev_dept)) deptChanges++;
            prev_dept = dept;
        }
        System.out.println(deptVisited);
        return deptChanges - deptVisited.size();
    }

    private static Map<String, String> parseMap(String[][] products) {

        Map<String, String> prodmap = new HashMap<>();
        for (String[] arr: products
             ) {
            String product = arr[0];
            String dept = arr[1];
            prodmap.put(product, dept);
        }
        System.out.println(prodmap);
        return prodmap;

    }


}
