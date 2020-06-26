package com.wang.leetcode31_60;

public class T31_nextPermutation {
    /**
     * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须原地修改，只允许使用额外常数空间。
     * <p>
     * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
     * 1,2,3 → 1,3,2
     * 3,2,1 → 1,2,3
     * 1,1,5 → 1,5,1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length == 0)
            return;
        int lastIndex = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int j = i + 1;
                while (j < nums.length && nums[i] < nums[j]) {
                    j++;
                }

                int temp = nums[i];
                nums[i] = nums[j - 1];
                nums[j - 1] = temp;
                lastIndex = i + 1;
                break;
            }
        }
        int index = 0;
        while (lastIndex+index < nums.length - index - 1) {
            int temp = nums[lastIndex + index];
            nums[lastIndex + index ] = nums[nums.length - index - 1];
            nums[nums.length - index - 1] = temp;
            ++index;
        }
    }

    public static void main(String[] args) {
        int[] ints = new int[]{3,2,1};
        nextPermutation(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
