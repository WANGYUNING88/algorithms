package com.wang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class T17_letterCombinations {
    /**
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
     *
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     *
     *
     *
     * 示例:
     *
     * 输入："23"
     * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
     * 说明:
     * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param digits
     * @return
     */
    public static String[] strings = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public static List<String> list = null;
    public static List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits!=null&&digits.length()!=0){
            add(new StringBuilder(),digits);
        }
        return list;
    }
    public static void add(StringBuilder result,String nextDigs){
        if (nextDigs.length()==0){
            list.add(result.toString());
            return;
        }
        String string = strings[nextDigs.charAt(0)-'0'-2];
        StringBuilder sb = null;
        for (int i = 0; i < string.length(); i++) {
            sb = new StringBuilder(result);
            add(sb.append(string.charAt(i)),nextDigs.substring(1));
        }
    }

    public static void main(String[] args) {
        List<String> list = letterCombinations("23");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
