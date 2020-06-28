package com.wang.leetcode31_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T40_combinationSum2 {
    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。 
     * 示例 1:
     * <p>
     * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * 示例 2:
     * <p>
     * 输入: candidates = [2,5,2,1,2], target = 5,
     * 所求解集为:
     * [
     *   [1,2,2],
     *   [5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> lists;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lists = new ArrayList<>();
        if (candidates.length==0)
            return lists;
        Arrays.sort(candidates);
        getNextNums(new ArrayList<>(), candidates,target,0);
        return lists;
    }

    public static void getNextNums(List<Integer> list, int[] candidates, int target, int start) {
        if (target==0){
            lists.add(new ArrayList<>(list));
            return;
        }
        if (start >= candidates.length || target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            ArrayList<Integer> integers = new ArrayList<>(list);
            integers.add(candidates[i]);
            getNextNums(integers,candidates,target-candidates[i],i+1);
            while (i+1<candidates.length&&candidates[i]==candidates[i+1]){
                i++;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{2,5,2,1,2}, 5);
        for (List<Integer> list : lists) {
            StringBuilder sb = new StringBuilder("[");
            for (Integer integer : list) {
                sb.append(integer+" ");
            }
            System.out.println(sb.toString().trim()+"]");
        }
    }
}
