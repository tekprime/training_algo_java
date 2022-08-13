package com.company;

import java.lang.reflect.Array;
import java.util.*;

class Node {
    int key;
    String name;
    boolean visited;

    public Node(int key, String name) {
        this.key = key;
        this.name = name;
        this.visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key && name.equals(node.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}

public class SiteSeeing {

    private HashMap<Node, LinkedList<Node>> siteAdjMap;
    private boolean directed;

    public SiteSeeing(boolean directed) {
        this.directed = directed;
        siteAdjMap = new HashMap<>();
    }

    public void addEdge(Node source, Node destination) {
        if (!siteAdjMap.keySet().contains(source))
            siteAdjMap.put(source, null);
        if (!siteAdjMap.keySet().contains(destination))
            siteAdjMap.put(destination, null);
        addEdgeHelper(source, destination);
        if (!directed) addEdgeHelper(destination, source);


    }

    private void addEdgeHelper(Node source, Node destination) {
        LinkedList<Node> tmp = siteAdjMap.get(source);
        if (tmp != null) {
            tmp.remove();
        } else tmp = new LinkedList<>();
        tmp.add(destination);
        siteAdjMap.put(source, tmp);
    }

    public void printEdges() {
        for (Node node : siteAdjMap.keySet()) {
            System.out.println("The " + node.name + " has and edge towards: " );
            for (Node neighbor: siteAdjMap.get(node)) {
                System.out.println(neighbor.name + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(Node source, Node destination){
        return siteAdjMap.keySet().contains(source) &&
           siteAdjMap.get(source).contains(destination);
    }
    public void resetNodesVisited() {
        for (Node node: siteAdjMap.keySet()) {
            node.setVisited(false);
        }
    }
    public static void main(String[] args) {

        SiteSeeing graph = new SiteSeeing(false);
        Node parking = new Node(0, "parking");
        Node liberty = new Node(1, "liberty");
        Node beaver1 = new Node(2, "beaver");
        Node beaver2 = new Node(3, "beaver");
        Node frozen1 = new Node(4, "frozen");
        Node frozen2 = new Node(5, "frozen");
        Node camping1 = new Node(6, "camping");
        Node camping2 = new Node(7, "camping");
        Node eil1 = new Node(8, "eil");
        Node eil2 = new Node(9, "eil");

        /*graph.addEdge(parking,liberty);
        graph.addEdge(parking, beaver1);
        graph.addEdge(beaver1, frozen1);
        graph.addEdge(beaver2, frozen2);
        graph.addEdge(beaver1, beaver2);
        graph.addEdge(frozen1,frozen2);
        graph.addEdge(beaver2 ,camping1);
        graph.addEdge(camping1,eil1);
        graph.addEdge(camping1, camping2);
        graph.addEdge(camping,eil2);*/

      //  graph.printEdges();
        // graph.depthFirstSearch(parking);
        ArrayList<String> path = new ArrayList<>();
      //  ArrayList<String>[] paths = new ArrayList[10];
        path.add(parking.name);
        //graph.printAllPaths(parking, camping, path);

    }
    public void depthFirstSearch(Node node) {
        node.setVisited(true);
        System.out.print(node.name + " ");

        LinkedList<Node> allNeighbors = siteAdjMap.get(node);
        if (allNeighbors == null)
            return;

        for (Node neighbor : allNeighbors) {
            if (!neighbor.isVisited())
                depthFirstSearch(neighbor);
        }
    }

    public void printAllPaths(Node source, Node destination, List<String> path) {

        if ( source.equals(destination)) {
            ArrayList<String> temp = new ArrayList<>(path);
            temp.stream().forEach(System.out::println);
        }

        source.setVisited(true);

        for(Node neighbor: siteAdjMap.get(source)) {

            if (!neighbor.isVisited()) {
                path.add(neighbor.name);
                printAllPaths(neighbor, destination, path);
                path.remove(neighbor);

            }
        }
        source.setVisited(false);

    }
}
