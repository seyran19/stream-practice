package org.example.algs.original;

public class TwoArrays {
    public static void main(String[] args) {
        int []  array1 = {1, 2, 3};
        int []  array2 = {1, 2, 3};
        System.out.println(check(array1, array2));
    }


    public static boolean check(int[] array1, int[] array2){

        for (int i = 0; i < array1.length; i++) {
            if(array1[i] != array2[i]){
                return false;
            }
        }


        return true;
    }
}
