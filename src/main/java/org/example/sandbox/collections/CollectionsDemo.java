package org.example.sandbox.collections;

import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {

        // Sets
        Set<String> set = new LinkedHashSet<>();
        Set<String> set2 = new HashSet<>();
        Set<String> set3 = new TreeSet<>();

        // Lists
        List<String> list = new Vector<>();
        List<String> list2 = new ArrayList<>(); // Most common
        List<String> list3 = new LinkedList<>();

        // Priority Queue
        Queue<String> queue = new PriorityQueue<>();
        Deque<String> queue2 = new LinkedList<>();

        // Maps uses <K,V>
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new LinkedHashMap<>();
        Map<String, String> map3 = new TreeMap<>();


    }

}
