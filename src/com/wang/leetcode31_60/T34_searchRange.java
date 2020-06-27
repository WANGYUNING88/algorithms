package com.wang.leetcode31_60;

public class T34_searchRange {
    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 8
     * 输出: [3,4]
     * 示例 2:
     * <p>
     * 输入: nums = [5,7,7,8,8,10], target = 6
     * 输出: [-1,-1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int[] ints = {-1, -1};
        if (nums.length == 0)
            return ints;
        int i = halfSearch(nums, 0, nums.length - 1, target);
        if (i==-1)
            return ints;
        int mid = i;
        while (i-1>-1&&nums[i-1]==nums[i]){
            i--;
        }
        ints[0] = i;
        i=mid;
        while (i+1<nums.length&&nums[i+1]==nums[i]){
            i++;
        }
        ints[1] = i;
        return ints;
    }

    public static int halfSearch(int[] nums, int start, int end, int target) {
        if (end == start) {
            return nums[end] == target ? end : -1;
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
        int[] ints = searchRange(new int[]{0,0,0,1,2,3}, 0);
        System.out.println(ints[0]+" - "+ints[1]);
    }
}
