package com.github;

import org.junit.Test;

import java.util.Arrays;

public class LeetCode {
    Question question = new Question();

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
        System.out.println(Arrays.toString(question.twoSum0(nums, target)));
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    @Test
    public void code2() {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        System.out.println(question.addTwoNumbers(l1, l2));
    }

    /**
     * 无重复字符的最长子串
     * <p>
     * 给定一个字符串，请你找出其中不含有重复字符的最长子串长度。
     */
    @Test
    public void code3() {
        String str = "abcba";
        long s = System.currentTimeMillis();
        System.out.println(question.lengthOfLongestSubstring1(str));
        System.out.println(System.currentTimeMillis() - s);
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */
    @Test
    public void code4() {

        String s = "rgczcpratwyqxaszbuwwcadruayhasynuxnakpmsyhxzlnxmdtsqqlmwnbxvmgvllafrpmlfuqpbhjddmhmbcgmlyeypkfpreddyencsdmgxysctpubvgeedhurvizgqxclhpfrvxggrowaynrtuwvvvwnqlowdihtrdzjffrgoeqivnprdnpvfjuhycpfydjcpfcnkpyujljiesmuxhtizzvwhvpqylvcirwqsmpptyhcqybstsfgjadicwzycswwmpluvzqdvnhkcofptqrzgjqtbvbdxylrylinspncrkxclykccbwridpqckstxdjawvziucrswpsfmisqiozworibeycuarcidbljslwbalcemgymnsxfziattdylrulwrybzztoxhevsdnvvljfzzrgcmagshucoalfiuapgzpqgjjgqsmcvtdsvehewrvtkeqwgmatqdpwlayjcxcavjmgpdyklrjcqvxjqbjucfubgmgpkfdxznkhcejscymuildfnuxwmuklntnyycdcscioimenaeohgpbcpogyifcsatfxeslstkjclauqmywacizyapxlgtcchlxkvygzeucwalhvhbwkvbceqajstxzzppcxoanhyfkgwaelsfdeeviqogjpresnoacegfeejyychabkhszcokdxpaqrprwfdahjqkfptwpeykgumyemgkccynxuvbdpjlrbgqtcqulxodurugofuwzudnhgxdrbbxtrvdnlodyhsifvyspejenpdckevzqrexplpcqtwtxlimfrsjumiygqeemhihcxyngsemcolrnlyhqlbqbcestadoxtrdvcgucntjnfavylip";
        long ss = System.nanoTime();
        System.out.println(longestPalindrome1(s));
        long ss2 = System.nanoTime();
        System.out.println(ss2 - ss);
        String result = longestPalindrome(s);
        System.out.println(result);
        long ss3 = System.nanoTime();
        System.out.println(ss3 - ss2);
        System.out.println(longestPalindrome2(s));
        System.out.println(System.nanoTime() - ss3);

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

    private int expandAroundCenter(String s, int left, int right) {
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

}
