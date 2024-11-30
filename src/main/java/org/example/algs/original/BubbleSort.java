package org.example.algs.original;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{12, 32, 43, 4, 54, 41, 98, 123, 76, 6, 43, 13, 14, 27, 20};
        boolean isSorted = false;

        while (!isSorted) {

            isSorted = true;

            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int temp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = temp;
                    isSorted = false;
                }

            }
        }
        System.out.println(Arrays.toString(array));
    }
}
