package com.wang.util;

public class ArrayUtils {
    /**
     * 打印二位数组
     * @param paraArr
     */
    public static void printArray(int[][] paraArr){
        for(int[] row : paraArr){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
