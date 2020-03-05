package com.wang.datastructure_algorithm.java.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
/*        int arr[] = {1,8,10,89,1000,1234};
//        int index = binarySearch(arr,0,arr.length-1,1234);//返回5
        int index = binarySearch(arr,0,arr.length-1,4);//返回-1
        System.out.printf("返回的结果是 %d",index);*/

    //如果有多个符合条件的值
        int arr[] = {1,8,10,89,1000,1001,1004,1004,1004,1234};
        List<Integer> list = new ArrayList<>();
        binarySearchAll(arr,0,arr.length-1,1004,list);//返回678
//        binarySearchAll(arr,0,arr.length-1,4,list);//返回[]空串
        System.out.printf("返回的结果是 %s",list.toString());
    }

    /**
     * 二分查找(该数组必须是有序数组)(查找到一个符合要求的就可以返回)
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int binarySearch(int[] arr,int left,int right,int value) {
        //left>right时，说明递归了整个数组，但没有找到
        if (left>right)
            return -1;
        int mid = (left+right)/2;
        int midval = arr[mid];
        if (value>midval){
            //向右递归
            mid = binarySearch(arr, mid+1, right, value);
        }else if (value<midval){
            //向左递归
            mid = binarySearch(arr, left, mid-1, value);
        }
            return mid;
    }

    /**
     * 二分查找(该数组必须是有序数组)(查找到一个符合要求的就可以返回)
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static void binarySearchAll(int[] arr, int left, int right, int value, List<Integer> result) {
        //left>right时，说明递归了整个数组，但没有找到
        if (left>right)
            return;
        int mid = (left+right)/2;
        int midval = arr[mid];
        if (value>midval){
            //向右递归
            binarySearchAll(arr, mid+1, right, value,result);
        }else if (value<midval){
            //向左递归
            binarySearchAll(arr, left, mid-1, value,result);
        }else {
            //向mid左边索引
            int temp = mid-1;
            while (temp>=0&&arr[temp]==value){
                result.add(temp--);
            }
            //将mid加入result
            result.add(mid);
            //向mid右边索引
            temp = mid+1;
            while (temp<arr.length&&arr[temp]==value){
                result.add(temp++);
            }
        }
    }
}
