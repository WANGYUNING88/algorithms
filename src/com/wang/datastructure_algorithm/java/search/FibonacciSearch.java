package com.wang.datastructure_algorithm.java.search;

import java.util.Arrays;

public class FibonacciSearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
//        int index = fibonacciSearch(arr,1234);//返回5
//        int index = fibonacciSearch(arr,1);//返回5
        int index = fibonacciSearch(arr,3);//返回-1
        System.out.printf("返回的结果是 %d", index);
    }

    public static int[] fib(int maxSize) {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    /**
     * 斐波那契查找
     * (该数组必须是有序数组)
     * (查找到一个符合要求的就可以返回)
     * 该方便和二分查找和插值查找类似，只是mid的规则改变了
     *
     * @param arr
     * @param value
     * @return
     */
    public static int fibonacciSearch(int[] arr, int value) {
        int low = 0;
        int high = arr.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid = 0;
        int f[] = fib(10);
        //获取斐波那契分割数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k] 可能大于 arr 的长度，因此我们可能需要使用Arrays类
        //构建一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(arr, f[k]);
        //实际上需要使用arr 的最大的值填充
        for (int i = high + 1; i < f[k]; i++) {
            temp[i] = arr[high];
        }
        //使用while 来循环处理，找到我们的数 key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (value < temp[mid]) {
                //向数组的左查找
                high = mid - 1;
                k--;
            } else if (value > temp[mid]) {
                //向数组的右查找
                low = mid + 1;
                k -= 2;
            } else {
                //找到了
                //需要确定返回的下标
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
