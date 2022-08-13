package com.company;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<T> {

    private final int capacity;
    private Map<String, Node> lookupMap;
    private dlcache internalQ;
    private int size;


    LRUCache(final int capacity) {
        this.capacity = capacity;
        lookupMap = new HashMap<>();
        internalQ = new dlcache();
        size = 0;
    }

    public T get(final String key) {
        
        Node node = lookupMap.get(key);
        if (node == null) return null;
        internalQ.moveNodeToFront(node);
        return lookupMap.get(key).value;

    }

   

    public void put(final String key, final T value) {
       Node currnode = this.lookupMap.get(key);
       if (currnode != null) {
           currnode.value = value;
           internalQ.moveNodeToFront(currnode);
       } else {
           if(size == capacity) {
               String rearKey = internalQ.getRearKey();
               internalQ.removeNodeFromRear();
               this.lookupMap.remove(rearKey);
               size--;
           }
            Node newnode = new Node(key, value);
            internalQ.addToFront(newnode);
            this.lookupMap.put(key, newnode);
            size++;
           
       }

    }

    private class Node {
        String key;
        T value;
        Node next, prev;
        Node(final String key, final T value ){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }
    private class dlcache {
        private Node front, rear;
        dlcache() {
            front = rear = null;
        }

        public void moveNodeToFront(Node node) {
           if (node == front) return;

           if (node == rear) {
               node.prev = rear;
               rear.next = null;
           } else {
               node.prev.next = node.next;
               node.next.prev = node.prev;
           }
           node.prev = null;
           node.next = front;
           front.prev = node;
           front = node;
        }

        public String getRearKey() {
            return "";
        }

        public void removeNodeFromRear() {
            ;
        }

        public void addToFront(Node newnode) {
            if(rear == null) {
                rear = front = newnode;
                return;
            }
            newnode.next = front;
            front.prev = newnode;
            newnode = front;
        }
    }


}
