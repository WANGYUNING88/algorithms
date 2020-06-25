package com.wang.leetcode1_30;

public class T4_findMedianSortedArrays {
    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
     * <p>
     * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
     * <p>
     * 你可以假设 nums1 和 nums2 不会同时为空。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * nums1 = [1, 3]
     * nums2 = [2]
     * <p>
     * 则中位数是 2.0
     * 示例 2:
     * <p>
     * nums1 = [1, 2]
     * nums2 = [3, 4]
     * <p>
     * 则中位数是 (2 + 3)/2 = 2.5
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     */

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k =  (n+m+1)/2;
        if ((n+m)%2==1){
            return getKthElement(nums1,0,m-1,nums2,0,n-1,k);
        }else {

            return (double) (getKthElement(nums1,0,m-1,nums2,0,n-1,k+1)+getKthElement(nums1,0,m-1,nums2,0,n-1,k))/2;
        }
    }

    public static int getKthElement(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int l1 = end1-start1+1;
        int l2 = end2-start2+1;
        if (l1>l2)
            return getKthElement(nums2,start2,end2,nums1,start1,end1,k);
        if (l1==0){
            return nums2[start2+k-1];
        }
        if (k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        int i = start1+Math.min(l1,k/2)-1;
        int j = start2+Math.min(l2,k/2)-1;
        if (nums1[i] > nums2[j]) {
            return getKthElement(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKthElement(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] i = {1,3};
        int[] j = {2};
        System.out.println(findMedianSortedArrays(i,j));
    }
}
