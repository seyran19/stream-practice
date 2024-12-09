package org.example.algs.original;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6, -5, 123,  - 3, 0 , 1000};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr) {

        int n = arr.length;
        if(n == 1) return;

        int mid = n / 2;

        int [] l = new int[mid];
        int [] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = 0; i < n - mid; i++) {
            r[i] = arr[i + mid];
        }

        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r);
    }

    private static void merge(int[] arr, int[] l, int[] r){
        int left = l.length;
        int right = r.length;

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < left && j < right){
            if(l[i] < r[j]){
                arr[idx] = l[i];
                i++;
            }else{
                arr[idx] = r[j];
                j++;
            }
            idx++;

        }

        for (int ll = i; ll < left; ll++){
            arr[idx++] = l[ll];
        }

        for (int rr = j; rr < right; rr++){
            arr[idx++] = r[rr];
        }
    }
}
