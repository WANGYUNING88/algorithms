package com.wang.leetcode1_30;

import java.util.Arrays;

public class T16_threeSumClosest {
    /**
     * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     *
     *  
     *
     * 示例：
     *
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     *  
     *
     * 提示：
     *
     * 3 <= nums.length <= 10^3
     * -10^3 <= nums[i] <= 10^3
     * -10^4 <= target <= 10^4
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        if (nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int threeSumClosest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length-2; i++) {
            int twoNum = getTwoNum(nums, i + 1, nums.length - 1, target - nums[i]);
            if (twoNum==target - nums[i])
                return target;
            if (threeSumClosest==Integer.MIN_VALUE){
                threeSumClosest = twoNum+nums[i];
            }else if (Math.abs(threeSumClosest-target)>Math.abs(twoNum+nums[i]-target)){
                threeSumClosest = twoNum+nums[i];
            }
            while (i<nums.length-2&&nums[i]==nums[i+1]){
                i++;
            }
        }
        return threeSumClosest;
    }

    public static int getTwoNum(int[] nums ,int start,int end,int k){
        int closest = Integer.MAX_VALUE;
        int temp = 0;
        while (start<end){
            int sum = nums[start]+nums[end];
            if (sum==k){
                return k;
            }else if (sum>k){
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
            if(Math.abs(k-sum)<closest){
                closest = Math.abs(k-sum);
                temp = sum;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int i = threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        System.out.println(i);

    }
}
