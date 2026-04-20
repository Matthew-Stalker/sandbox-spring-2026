package org.example.sandbox.sort;
import org.springframework.util.StopWatch;
import java.util.Arrays;
import java.util.stream.IntStream;

public class SortingDriver {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch("Sorting Algorithms Performance");

        // Generate array of random Integers
        Integer[] arr = IntStream.generate(() -> (int) (Math.random() * 5000))
                .distinct()
                .boxed()
                .limit(5000)
                .toArray(Integer[]::new);

        // List first 10 unsorted elements...
        printFirstTenOfArray(arr);

        Integer[] copy1 = copyArray(arr);
        Integer[] copy2 = copyArray(arr);
        Integer[] copy3 = copyArray(arr);
        Integer[] copy4 = copyArray(arr);
        Integer[] copy5 = copyArray(arr);

        System.out.println("\nSelection Sort...");
        stopWatch.start("Selection Sort");
        SortUtility.selectionSort(copy1);
        stopWatch.stop();
        printFirstTenOfArray(copy1);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nInsertion Sort...");
        stopWatch.start("Insertion Sort");
        SortUtility.insertionSort(copy2);
        stopWatch.stop();
        printFirstTenOfArray(copy2);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nBubble Sort...");
        stopWatch.start("Bubble Sort");
        SortUtility.bubbleSort(copy3);
        stopWatch.stop();
        printFirstTenOfArray(copy3);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nQuick Sort...");
        stopWatch.start("Quick Sort");
        SortUtility.quickSort(copy4);
        stopWatch.stop();
        printFirstTenOfArray(copy4);
        System.out.println("Time: " + stopWatch.getLastTaskTimeMillis() + "ms");

        System.out.println("\nMerge Sort...");
        stopWatch.start("Merge Sort");
        SortUtility.mergeSort(copy5);
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

    private static <T> T[] copyArray(T[] obj) {

        T[] copy = (T[]) Arrays.copyOf(obj, obj.length);

        return copy;
    }

}
