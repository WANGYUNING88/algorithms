package com.wang.leetcode31_60;

public class T33_search {
    /**
     * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
     * <p>
     * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
     * <p>
     * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
     * <p>
     * 你可以假设数组中不存在重复的元素。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 示例 1:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 0
     * 输出: 4
     * 示例 2:
     * <p>
     * 输入: nums = [4,5,6,7,0,1,2], target = 3
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        if (nums.length == 0)
            return -1;
        return halfSerch(nums, 0, nums.length - 1, target);
    }

    public static int halfSerch(int[] nums, int left, int right, int target) {
        if (left > right)
            return -1;
        if (right == left && nums[right] == target) {
            return left;
        }
        int mid = (right - left) / 2 + left;
        int result = -1;
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && nums[mid] >= target)
                result = halfSerch(nums, left, mid, target);
            else
                result = halfSerch(nums, mid + 1, right, target);
        } else if (nums[right] >= nums[mid + 1]) {
            if (nums[mid + 1] <= target && nums[right] >= target)
                result = halfSerch(nums, mid + 1, right, target);
            else
                result = halfSerch(nums, left, mid, target);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] ints = {4, 5, 6, 7, 0, 1, 2};
        int search = search(ints, -7);
        System.out.println(search);
    }
}
