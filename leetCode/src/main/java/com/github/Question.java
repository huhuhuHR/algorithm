package com.github;

import java.util.HashMap;
import java.util.Map;

public class Question {
    public int[] twoSum0(int[] nums, int target) {
        int[] numsIndex = new int[2];
        int reference;
        int num;
        for (int i = 0; i < nums.length - 1; i++) {
            reference = nums[i];
            num = target - reference;
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n = l1;
        ListNode m = l2;
        ListNode dummyHead = new ListNode(0);
        ListNode cursor = dummyHead;
        int carry = 0;
        while (n != null || m != null) {
            int x = n != null ? n.val : 0;
            int y = m != null ? m.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            int num = sum % 10;
            cursor.next = new ListNode(num);

            n = n != null ? n.next : null;
            m = m != null ? m.next : null;
            cursor = cursor.next;
        }
        if (carry != 0) {
            cursor.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}
