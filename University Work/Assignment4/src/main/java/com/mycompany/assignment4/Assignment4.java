
package com.mycompany.assignment4;

import java.util.Arrays;

public class Assignment4 {

    public static void main(String[] args) {
        int[] originalArray = {64, 25, 12, 22, 11};

        int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
        SortingAlgorithms.bubbleSort(bubbleArray);
        System.out.println("Bubble Sort:    " + Arrays.toString(bubbleArray));

        int[] selectionArray = Arrays.copyOf(originalArray, originalArray.length);
        SortingAlgorithms.selectionSort(selectionArray);
        System.out.println("Selection Sort: " + Arrays.toString(selectionArray));

        int[] mergeArray = Arrays.copyOf(originalArray, originalArray.length);
        SortingAlgorithms.mergeSort(mergeArray, 0, mergeArray.length - 1);
        System.out.println("Merge Sort:     " + Arrays.toString(mergeArray));
    }
}
