package com.wang.datastructure_algorithm.java.search;

import java.util.ArrayList;
import java.util.List;

public class InsertValueSearch {
    public static void main(String[] args) {
        int arr[] = new int[100];
        for (int i =0;i<100;i++){
            arr[i] = i+1;
        }
        int index = insertValueSearch(arr,0,arr.length-1,1234);//返回-1
//        int index = insertValueSearch(arr,0,arr.length-1,4);//返回3
        System.out.printf("返回的结果是 %d",index);
    }

    /**
     * 插值查找
     * (该数组必须是有序数组)
     * (查找到一个符合要求的就可以返回)
     * 该方便和二分查找类似，只是mid的规则改变了
     * @param arr
     * @param left
     * @param right
     * @param value
     * @return
     */
    public static int insertValueSearch(int[] arr,int left,int right,int value) {
        //left>right时，说明递归了整个数组，但没有找到
        if (left>right||arr[left]>value||arr[right]<value)
            return -1;
        int mid = left + (right-left)*(value-arr[left])/(arr[right]-arr[left]);
        int midval = arr[mid];
        if (value>midval){
            //向右递归
            mid = insertValueSearch(arr, mid+1, right, value);
        }else if (value<midval){
            //向左递归
            mid = insertValueSearch(arr, left, mid-1, value);
        }
            return mid;
    }
}
