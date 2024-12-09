package org.example.algs.original;

import java.util.Arrays;
/// найти второй самый маленький элемент
public class SecondMin {

    public static void main(String[] args) {

        int [] array = new int[] {65, 45, 73, 41, 32, 53, 16, 23, 57, 42, 74, 55, 36};
        mergeSort(array);

        System.out.println(array[1]);
        System.out.println(Arrays.toString(array));

    }

    public static void mergeSort(int[] arr){

        int n = arr.length;
        if (n == 1) return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = arr[i];
        }

        for (int i = 0; i < n - mid; i++) {
            r[i] = arr[i + mid];
        }

        mergeSort(r);
        mergeSort(l);
        merge(arr, l, r);

    }

    private static void merge(int[] arr, int[] left, int[] right){
        int l = left.length;
        int r = right.length;
        int i = 0;
        int j = 0;
        int idx = 0;


        while (i < l && j < r){
            if(left[i] < right[j]){
                arr[idx] = left[i];
                i++;
            }else{
                arr[idx] = right[j];
                j++;
            }
            idx++;
        }

        for (int ll = i; ll < l; ll++) {
            arr[idx++] = left[ll];
        }
        for (int rr = j; rr < r; rr++) {
            arr[idx++] = right[rr];
        }
    }
}
