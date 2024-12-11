package org.example.algs.copy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr = {2, 9, 5, 4, 8, 1, 6, -5, 123,  - 3, 0 , 1000};
        mSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mSort(int[] array){

        int n = array.length;

        if (n == 1) return;

        int mid = n / 2;

        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++){
            l[i] = array[i];
        }

        for (int i = 0; i < n - mid; i++){
            r[i] = array[i + mid];
        }


        mSort(l);
        mSort(r);
        merrge(array, l, r);
    }

    private static void merrge(int[] array, int[] l, int[] r){

        int left = l.length;
        int right = r.length;

        int i = 0;
        int j = 0;
        int idx = 0;

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
