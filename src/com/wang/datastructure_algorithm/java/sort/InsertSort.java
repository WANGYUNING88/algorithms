package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertSort {
    public static void main(String[] args) {
        //测试排序
/*        int[] array = {101, 2, 23, 34, 119, 1, -1};
        print(0, array);
        insertSort(array);*/

        //测试速度 80000 个数据
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 100);//生成一个[0,array.length*100)之间的数
        }
        //print(0, array);

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println("排序前的时间 = "+format1);

        //测试排序
        insertSort(array);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = "+format2);
    }

    /**
     * 插入排序
     * 平均时间复杂度：O(n²)
     * 最差情形：O(n²)
     * 稳定
     * 额外空间：O(1)
     * 当大部分已经排好时
     *
     * @param array
     */
    public static void insertSort(int[] array) {
        int insertVal = 0;//定义一个变量，表示待插入的数
        int insertIndex = 0;//定义一个变量，表示待插入的数的前一个数的下标
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];//定义一个变量，表示待插入的数
            insertIndex = i - 1;//定义一个变量，表示待插入的数的前一个数的下标
            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                //insertIndex >= 0保证下标不越界
                //insertVal < array[insertIndex]说明待插入的数没有找插入的位置
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }
            array[insertIndex + 1] = insertVal;
            //print(i, array);
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
