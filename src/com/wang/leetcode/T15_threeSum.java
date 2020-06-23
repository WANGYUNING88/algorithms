package com.wang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T15_threeSum {
    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     *
     * 注意：答案中不可以包含重复的三元组。
     *
     *  
     *
     * 示例：
     *
     * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
     *
     * 满足要求的三元组集合为：
     * [
     *   [-1, 0, 1],
     *   [-1, -1, 2]
     * ]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length<3){
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            List<List<Integer>> twoNum = getTwoNum(nums, i + 1, nums.length - 1, nums[i]);
            lists.addAll(twoNum);
            while (i<nums.length-2&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return lists;
    }

    public static List<List<Integer>> getTwoNum(int[] nums ,int start,int end,int k){
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = null;
        while (start<end){
            if (nums[start]+nums[end]==-k){
                list = new ArrayList<>();
                list.add(k);
                list.add(nums[start]);
                list.add(nums[end]);
                lists.add(list);
                while (start<end&&nums[start]==nums[start+1]){
                    start++;
                }
                start++;
                while (start<end&&nums[end]==nums[end-1]){
                    end--;
                }
                end--;
            }else if (nums[start]+nums[end]>-k){
                while (start<end&&nums[end]==nums[end-1]){
                    end--;
                }
                end--;
            }else {
                while (start<end&&nums[start]==nums[start+1]){
                    start++;
                }
                start++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> list:lists) {
            System.out.println("*****");
            for (int i:list
                 ) {
                System.out.print(i+" ");
            }
        }
    }
}
