package com.wang.leetcode1_30;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T18_fourSum {
    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：
     * <p>
     * 答案中不可以包含重复的四元组。
     * <p>
     * 示例：
     * <p>
     * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
     * <p>
     * 满足要求的四元组集合为：
     * [
     * [-1,  0, 0, 1],
     * [-2, -1, 1, 2],
     * [-2,  0, 0, 2]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 4)
            return lists;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int rest = target - nums[i] - nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int temp = nums[left] + nums[right];
                    if (rest > temp) {
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                    } else if (rest < temp) {
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        while (left < right && nums[right - 1] == nums[right]) {
                            right--;
                        }
                        right--;
                        while (left < right && nums[left + 1] == nums[left]) {
                            left++;
                        }
                        left++;
                    }
                }
                while (j < nums.length - 2 && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            while (i < nums.length - 2 && nums[i + 1] == nums[i]) {
                i++;
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : lists) {
            System.out.print(" | ");
            for (Integer integer : list) {
                System.out.print(integer + " | ");
            }
            System.out.println();
        }
    }
}
