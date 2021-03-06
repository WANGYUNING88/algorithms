package com.wang.leetcode1_30;

public class T5_longestPalindrome {
    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     *
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        int maxLen = 1;
        int startIndex = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < length-1; i++) {
            int expandAroundCenter1 = expandAroundCenter(chars,i,i);
            int expandAroundCenter2 = expandAroundCenter(chars,i,i+1);
            int currmaxLen = Math.max(expandAroundCenter1,expandAroundCenter2);
            if (currmaxLen>maxLen){
                maxLen = currmaxLen;
                startIndex = i-(currmaxLen-1)/2;
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }
    public static int expandAroundCenter(char[] chars,int left,int right){
        int l = left;
        int r = right;
        int len = chars.length;
        while (l>=0 && r<len && chars[l]==chars[r]){
            l--;
            r++;
        }
        return r-l-1;
    }
}
