package com.wang.leetcode1_30;

import java.util.*;

public class T20_isValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     *
     * 示例 1:
     *
     * 输入: "()"
     * 输出: true
     * 示例 2:
     *
     * 输入: "()[]{}"
     * 输出: true
     * 示例 3:
     *
     * 输入: "(]"
     * 输出: false
     * 示例 4:
     *
     * 输入: "([)]"
     * 输出: false
     * 示例 5:
     *
     * 输入: "{[]}"
     * 输出: true
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length()==0){
            return true;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        Map<Character,Integer> left = new HashMap<>();
        left.put('(',1);
        left.put('[',2);
        left.put('{',3);
        Map<Character,Integer> right = new HashMap<>();
        right.put(')',1);
        right.put(']',2);
        right.put('}',3);
        for (char aChar : chars) {
            if (left.containsKey(aChar)){
                stack.push(aChar);
            }else {
                if (stack.isEmpty()||left.get(stack.pop())!=right.get(aChar)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)[]{}"));
    }
}
