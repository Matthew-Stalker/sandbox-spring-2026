package org.example.sandbox.sort;

import org.springframework.util.StopWatch;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingDriver {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch("Sorting Algorithms Performance");

        // Generate array of random Integers
        Integer[] arr = IntStream.generate(() -> (int) (Math.random() * 1000))
                //.distinct()
                .boxed()
                .limit(50000)
                .toArray(Integer[]::new);

        // Generate array of random Strings
        /*String[] arr = IntStream.range(0, 50000)
                .mapToObj(i -> {
                    int length = 5 + (int) (Math.random() * 10);
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < length; j++) {
                        char c = (char) ('a' + (int) (Math.random() * 26));
                        sb.append(c);
                    }
                    return sb.toString();
                })
                .toArray(String[]::new);*/

        // List first 10 unsorted elements...
        printFirstTenOfArray(arr);

        Comparable[] copy1 = copyArray(arr);
        Comparable[] copy2 = copyArray(arr);
        Comparable[] copy3 = copyArray(arr);
        Comparable[] copy4 = copyArray(arr);
        Comparable[] copy5 = copyArray(arr);

        System.out.println("\nSelection Sort...");
        stopWatch.start("Selection Sort");
        SortingUtility.selectionSort(copy1);
        stopWatch.stop();
        printFirstTenOfArray(copy1);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nInsertion Sort...");
        stopWatch.start("Insertion Sort");
        SortingUtility.insertionSort(copy2);
        stopWatch.stop();
        printFirstTenOfArray(copy2);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nBubble Sort...");
        stopWatch.start("Bubble Sort");
        SortingUtility.bubbleSort(copy3);
        stopWatch.stop();
        printFirstTenOfArray(copy3);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nQuick Sort...");
        stopWatch.start("Quick Sort");
        SortingUtility.quickSort(copy4);
        stopWatch.stop();
        printFirstTenOfArray(copy4);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nMerge Sort...");
        stopWatch.start("Merge Sort");
        SortingUtility.mergeSort(copy5);
        stopWatch.stop();
        printFirstTenOfArray(copy5);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\n" + stopWatch.prettyPrint());
    }

    private static <T> void printFirstTenOfArray(T[] obj) {

        if (obj != null) {

            int counter = 1;
            System.out.println("\nFirst 10 of Array...");

            for (T i : obj) {
                System.out.println(counter + ": " + i.toString());

                if (counter >= 10) {
                    break;
                }
                counter++;
            }

        } else {
            System.out.println("Array is null.");
        }
    }

    private static <T extends Comparable<T>> T[] copyArray(T[] arr) {

        T[] copy = (T[]) Arrays.copyOf(arr, arr.length);

        return copy;
    }

}