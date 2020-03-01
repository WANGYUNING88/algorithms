package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        //测试排序
 /*       int[] array = {101,2,23,34,119,1,-1};
        print(0, array);
        selectSort(array);*/

        //测试速度 80000 个数据
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 100);//生成一个[0,array.length*100)之间的数
        }
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println("排序前的时间 = " + format1);

        //测试排序
        selectSort(array);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = " + format2);
    }

    /**
     * 选择排序
     * 平均时间复杂度：O(n²)
     * 最差情形：O(n²)
     * 不稳定
     * 额外空间：O(1)
     * 当n越小时越好
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        int min = 0;//最小值
        int minIndex = 0;//最小值的下标
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            min = array[minIndex];
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    //假定最小的值不是最小的,重置数据
                    min = array[j];
                    minIndex = j;
                }
            }
            //此时min就是最小值，min和array[i]交换
            //可以加一判断，是否需要交换（优化）
            if (minIndex != i) {
                array[minIndex] = array[i];   //array[i](下标是i) 和 array[minIndex](下标是minIndex)
                array[i] = min;
            }
            //print(i+1,array);
        }
    }

    /**
     * 打印数组
     *
     * @param k     第k趟排序
     * @param array 此时数组的顺序
     */
    public static void print(int k, int[] array) {
        if (k == 0) {
            System.out.printf("数组原顺序是【", k);
        } else {
            System.out.printf("第%d次排序的顺序是【", k);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((i == array.length - 1) ? "" : " "));
        }
        System.out.println("】");
    }

}
