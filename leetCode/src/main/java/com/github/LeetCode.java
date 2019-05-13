package com.github;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
     * <p>
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     */
    @Test
    public void code1() {
        int[] nums = {2, 7, 11, 15};
        int target = 17;
        System.out.println(Arrays.toString(twoSum0(nums, target)));
    }

    public int[] twoSum0(int[] nums, int target) {
        int[] numsIndex = new int[2];
        int refence;
        int num;
        for (int i = 0; i < nums.length - 1; i++) {
            refence = nums[i];
            num = target - refence;
            for (int j = i + 1; j < nums.length; j++) {
                if (num == nums[j]) {
                    numsIndex[0] = i;
                    numsIndex[1] = j;
                    return numsIndex;
                }
            }
        }
        return numsIndex;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] result = new int[2];
        boolean over = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int tmp = nums[i] + nums[j];
                if (target == tmp) {
                    result[0] = i;
                    result[1] = j;
                    over = true;
                    break;
                }
            }
            if (over) {
                break;
            }
        }
        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if (maps.containsKey(result)) {
                return new int[]{maps.get(result), i};
            }
            maps.put(nums[i], i);
        }
        return null;
    }
}
