package com.wang.leetcode31_60;

public class T35_searchInsert {
    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 你可以假设数组中无重复元素。
     *
     * 示例 1:
     *
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     *
     * 输入: [1,3,5,6], 0
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if (nums.length==0||nums[0]>target)
            return 0;
        else if (nums[nums.length-1]<target)
            return nums.length;
        return halfSearch(nums,0,nums.length-1,target);
    }
    public static int halfSearch(int[] nums, int start, int end, int target) {
        if (end == start + 1) {
            return nums[end] == target||nums[start]<target ? end : start;
        }else if (end==start){
            return end;
        }
        int mid = start + (end - start) / 2;
        if (target == nums[mid])
            return mid;
        else if (target > nums[mid]) {
            return halfSearch(nums, mid + 1, end, target);
        } else {
            return halfSearch(nums, start, mid, target);
        }
    }

    public static void main(String[] args) {
        System.out.print(searchInsert(new int[]{1,3,5},4));
    }

}
