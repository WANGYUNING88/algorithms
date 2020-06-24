package com.wang.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class T22_generateParenthesis {
    /**
     *数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     *
     *  
     *
     * 示例：
     *
     * 输入：n = 3
     * 输出：[
     *        "((()))",
     *        "(()())",
     *        "(())()",
     *        "()(())",
     *        "()()()"
     *      ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/generate-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public static HashSet<String> set = null;
    public static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        set = new HashSet<>();
        if (n<1){
            return list;
        }else {
            add("",n);
        }
        for (String s : set) {
            list.add(s);
        }
        return list;
    }
    public static void add(String s,int n){
        if (n==0){
            set.add(s);
            return;
        }
        if (s.length()==0) {
            add("()",n-1);
        }else {
            char[] chars = s.toCharArray();
            int index = 0;
            while (index<chars.length){
                add(s.substring(0,index)+"()"+s.substring(index),n-1);
                index++;
            }
            add(s+"()",n-1);
        }
    }

    /**
     * 动态规划
     * （ + dp[i] +）+ dp[j]
     * i+j=n-1
     * @param n
     * @return
     */
    public List<String> generateParenthesis1(int n) {
        LinkedList<LinkedList<String>> result = new LinkedList<LinkedList<String>>();
        if (n == 0)
            return result.get(0);
        LinkedList<String> list0 = new LinkedList<String>();
        list0.add("");
        result.add(list0);
        LinkedList<String> list1 = new LinkedList<String>();
        list1.add("()");
        result.add(list1);
        for (int i = 2; i <= n; i++) {
            LinkedList<String> temp = new LinkedList<String>();
            for (int j = 0; j < i; j++) {
                List<String> str1 = result.get(j);
                List<String> str2 = result.get(i - 1 - j);
                for (String s1 : str1) {
                    for (String s2 : str2) {
                        String el = "(" + s1 + ")" + s2;
                        temp.add(el);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }

    public static void main(String[] args) {
        generateParenthesis(3);
        for (String s : set) {
            System.out.println(s);
        }
    }
}
