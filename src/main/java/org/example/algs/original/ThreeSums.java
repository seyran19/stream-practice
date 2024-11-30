package org.example.algs.original;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public static void main(String[] args) {
        Integer[] nums = new Integer[] { -1, 0, 1, 2, -1, 4};
        System.out.println(threeSum(nums));

    }


    public static List<List<Integer>> threeSum(Integer[] nums) {

        var result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right){

                int threeSum = nums[i] + nums[left] + nums[right];

                if (threeSum < 0){
                    left++;
                }else if (threeSum > 0){
                    right--;
                }else {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    while (nums[left] == nums[left - 1] && left < right){
                        left++;
                    }
                }
            }

        }




        return result;
    }
}
