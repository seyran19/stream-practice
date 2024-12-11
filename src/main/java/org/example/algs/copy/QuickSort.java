package org.example.algs.copy;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6, -5, 123,  - 3, 0 , 1000};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] array, int from, int to){
        if (from < to){

            int index = partition(array, from, to);
            quickSort(array, from, index - 1);
            quickSort(array, index, to);
        }
    }

    public static int partition(int[] array, int from, int to){

        int leftIndex = from;
        int rightIndex = to;
        int pivot = array[from];

        while (leftIndex <= rightIndex){


            while (array[leftIndex] < pivot){
                leftIndex++;
            }

            while (array[rightIndex] > pivot){
                rightIndex--;
            }

            if(leftIndex <= rightIndex){
                int temp = array[leftIndex];
                array[leftIndex] = array[rightIndex];
                array[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }

        }
        return leftIndex;
    }
}
