package com.wang.leetcode;

public class T3_lengthOfLongestSubstring {
    /**
     *给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     * 示例 1:
     *
     * 输入: "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        int max = 0;
        int left = 0;
        int right = 0;
        boolean[] booleans = new boolean[128];
        while (right<s.length()){
            if (!booleans[s.charAt(right)]){
                booleans[s.charAt(right)] = true;
                right++;
            }else {
                max = Math.max(max,right-left);
                while (right>left&&s.charAt(right)!=s.charAt(left)){
                    booleans[s.charAt(left)] = false;
                    left++;
                }
                left++;
                right++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
