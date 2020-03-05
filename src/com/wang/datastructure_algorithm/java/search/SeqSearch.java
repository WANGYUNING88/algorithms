package com.wang.datastructure_algorithm.java.search;

public class SeqSearch {
    public static void main(String[] args) {
        int arr[] = {1,9,11,-1,34,89};
//        int index = seqSearch(arr, 11);//返回2
        int index = seqSearch(arr, 114);//返回-1
        System.out.printf("返回的结果是 %d",index);
    }

    /**
     * 线性查找(目前默认查找一个满足条件就返回)
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr,int value) {
        //逐一比对。发现相同就返回下标
        for (int i = 0; i<arr.length;i++){
            if (arr[i]==value)
                return i;
        }
        return -1;
    }
}
