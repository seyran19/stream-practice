package org.example.algs.original;

import java.util.Arrays;

public class Move_Zero {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 1, 0, 3, 12};
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }

        while (index < nums.length){
            nums[index] = 0;
        }

        System.out.println(Arrays.toString(nums));


    }
}

