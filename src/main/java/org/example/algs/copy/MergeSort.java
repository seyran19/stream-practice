package org.example.algs.copy;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6, -5, 123, - 3, 0 , 1000};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int [] array){

        int n = array.length;
        if (n == 1) return;

        int mid = array.length / 2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }

        for (int i = 0; i < n - mid; i++) {
            r[i] = array[i + mid];
        }
        mergeSort(l);
        mergeSort(r);
        merge(l, r, array);

    }

    private static void merge(int[] l, int[] r, int[] array){

        int left = l.length;
        int right = r.length;

        int idx = 0;

        int i = 0;
        int j = 0;

        while (i < left && j < right){
            if(l[i] < r[j]){
                array[idx] = l[i];
                i++;
            }else {
                array[idx] = r[j];
                j++;
            }idx++;
        }

        for (int k = i; k < left; k++) {
            array[idx++] = l[k];
        }

        for (int k = j; k < right; k++) {
            array[idx++] = r[k];
        }
    }
}
