package com.wang.leetcode31_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class T39_combinationSum {
    /**
     * @param candidates
     * @param target
     * @return
     */

    public static List<List<Integer>> lists = null;
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        if (candidates.length==0)
            return lists;
        nextNums(new ArrayList<Integer>(),candidates,0,target);
        return lists;
    }

    public static void nextNums(List<Integer> list,int[] candidates,int start, int target) {

        if (target<0){
            if (list.size()!=0)
                list.remove(list.size()-1);
            return;
        }else if (target==0){
            lists.add(new ArrayList<>(list));
            if (list.size()!=0)
                list.remove(list.size()-1);
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            List<Integer> list1 = new ArrayList<>(list);
            list1.add(candidates[i]);
            nextNums(list1,candidates,i,target-candidates[i]);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer+" ");
            }
            System.out.println("]");
        }
    }
}
