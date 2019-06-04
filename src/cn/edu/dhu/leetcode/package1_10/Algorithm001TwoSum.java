package cn.edu.dhu.leetcode.package1_10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *   给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     示例:
     给定 nums = [2, 7, 11, 15], target = 9
     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]
 */
public class Algorithm001TwoSum {
    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
    public static int[] twoSum(int[] nums, int target) {
        /*if (nums.length == 0 || nums == null) return null;
        for (int i = 0; i < nums.length; i++) {
            int res = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (res == nums[j]) {
                    return new int[]{i,j};
                }
            }

        }
        return null;*/

        Map<Integer, Integer> map = new HashMap<>();
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            tmp = target - nums[i];
            if (map.containsKey(tmp)){
                return new int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
