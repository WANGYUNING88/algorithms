package com.wang.leetcode1_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T30_findSubstring {
    /**
     * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
     *
     * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：
     *   s = "barfoothefoobarman",
     *   words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     *
     * 输入：
     *   s = "wordgoodgoodgoodbestword",
     *   words = ["word","good","best","word"]
     * 输出：[]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (s.length()==0||words.length==0||s.length()<words[0].length()*words.length)
            return list;
        int oneLen = words[0].length(),wordsLen = words[0].length()*words.length;
        Map<String,Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for (int i = 0; i < oneLen; i++) {
            int left = i,right = i,count = 0;
            Map<String,Integer> curr = new HashMap<>();
            while (right+oneLen<=s.length()){
                String sWord = s.substring(right,right+oneLen);
                right+=oneLen;
                if (!map.containsKey(sWord)){
                    left = right;
                    curr.clear();
                    count=0;
                }else {
                    curr.put(sWord,curr.getOrDefault(sWord,0)+1);
                    count++;
                    while (curr.getOrDefault(sWord,0)>map.getOrDefault(sWord,0)){
                        String lWord = s.substring(left,left+oneLen);
                        curr.put(lWord,curr.getOrDefault(lWord,0)-1);
                        left = left+oneLen;
                        count--;
                    }
                    if (count == words.length) list.add(left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        /**
         * "wordgoodgoodgoodbestword"
         * ["word","good","best","word"]
         */
        List<Integer> barfo = findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"});
        for (Integer integer : barfo) {
            System.out.print(integer +" ");
        }
    }
}
