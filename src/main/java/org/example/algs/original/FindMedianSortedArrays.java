package org.example.algs.original;

import java.util.ArrayList;
import java.util.List;


public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[] {1, 2};
        int[] nums2 = new int[] {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

        ArrayList<Integer> list = new ArrayList<>();

        for (int k : nums1) {
            list.add(k);
        }

        for (int j : nums2) {
            list.add(j);
        }

        List<Integer> list1 = list.stream()
                .sorted()
                .toList();


       if (list1.size() % 2 == 0){
           return (double) (list1.get(list1.size() / 2 - 1) + list1.get(list1.size() / 2)) / 2;
       }
       else{
           return list1.get(list1.size() / 2);
       }

    }
}
