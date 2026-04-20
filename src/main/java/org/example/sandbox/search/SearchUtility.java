package org.example.sandbox.search;

import java.util.List;

public class SearchUtility {

    public static int linearSearch(int[] array, int targetValue) {

        int found = Integer.MIN_VALUE;
        // O(n)
        for (int i : array) {

            if (i == targetValue) {
                found = targetValue;
                break;
            }
        }
        return found;
    }

    // O(n)
    public static <T> T linearSearch(List<T> objectList, T target) {

        T result = null;
        if (objectList.contains(target)) {
            result = objectList.get(objectList.indexOf(target));
        }
        return result;
    }

    // O(n)
    public static <T extends Comparable<T>> boolean linearSearch(T[] array, T target) {
        boolean found = false;

        // O(n)
        for (T t : array) {
            if (t.compareTo(target) == 0) {
                found = true;
                break;
            }
        }

        return found;
    }

    public static int binarySearchIterative(int[] array, int targetValue) {

        int min = 0;
        int max = array.length - 1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                min = mid + 1;
            } else if (array[mid] > targetValue) {
                max = mid - 1;
            }

        }

        return -1;
    }

    public static int binarySearchRecursive(int[] array, final int targetValue) {
        return binarySearchRecursive(array, 0, (array.length - 1), targetValue);
    }

    private static int binarySearchRecursive(int[] array, int minIndex, int maxIndex, int targetValue) {

        if (maxIndex >= minIndex) {

            int mid = minIndex + (maxIndex - minIndex) / 2;

            if (array[mid] == targetValue) {
                return mid;
            } else if (array[mid] < targetValue) {
                return binarySearchRecursive(array, mid + 1, maxIndex, targetValue);
            } else if (array[mid] > targetValue) {
                return binarySearchRecursive(array, minIndex, mid - 1, targetValue);
            }
        }
        return -1;
    }

}