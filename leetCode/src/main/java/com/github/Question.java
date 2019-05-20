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

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        String sub;
        int start = 0;
        int end = 0;
        int length = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i + length; j < s.length(); j++) {
                sub = s.substring(i, j + 1);
                if (check(sub)) {
                    length = j - i + 1;
                    start = i;
                    end = j + 1;
                }
            }
        }
        if (length == 1) {
            return String.valueOf(s.charAt(0));
        }
        return s.substring(start, end);
    }

    public boolean check(String sub) {
        String reverse = new StringBuilder(sub).reverse().toString();
        return reverse.equals(sub);
    }

    public String longestPalindrome1(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public String longestPalindrome2(String s) {
        if (s == null) {
            return "";
        }
        int size = s.length();
        int i = 0;
        int j = size - 1;
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                if (check(s.substring(i, j + 1))) {
                    return s.substring(i, j + 1);
                }
            }

            i++;
            j--;
        }
        if (i == j) {
            return String.valueOf(s.charAt(0));
        }
        return s.substring(i, j + 1);
    }

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            // 取现存最后一位
            int pop = x % 10;
            // 取现存除最后一位
            x /= 10;
            // 2147483647
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            // -2147483648
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

}
