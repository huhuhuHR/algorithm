package com.github;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    // 最快
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        // key char value index
        Map<Character, Integer> map = new HashMap<>();
        // current index of character
        // try to extend the range [i, j]
        int leftIndex = 0;
        char key;
        for (int j = 0; j < n; j++) {
            key = s.charAt(j);
            if (map.containsKey(key)) {
                // 更新左边界
                leftIndex = Math.max(map.get(key) + 1, leftIndex);
            }
            ans = Math.max(ans, j - leftIndex + 1);
            map.put(key, j);
        }
        return ans;
    }

    // 超时
    public int lengthOfLongestSubstring2(String s) {
        List<Character> list = new ArrayList<>();
        int ans = 0;
        char c;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            int index = list.indexOf(c);
            if (index == -1) {
                list.add(c);
                ans = Math.max(ans, list.size());
            } else {
                list = list.subList(index + 1, list.size());
                list.add(c);
                ans = Math.max(ans, list.size());
            }
        }
        return ans;
    }
}
