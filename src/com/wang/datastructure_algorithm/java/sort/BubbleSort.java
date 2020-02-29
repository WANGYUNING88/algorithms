package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
        //测试冒泡排序
        // int[] array = {3,9,-1,10,0};
        //测试优化过冒泡排序
        //int[] array = {1, 2, 3, 4, 5, 6};
//        print(0, array);
//        bubbleSort(array);

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

        //测试冒泡排序
        bubbleSort(array);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = "+format2);
    }

    /**
     * 冒泡排序
     * 平均时间复杂度：O(n²)
     * 最差情形：O(n²)
     * 稳定
     * 额外空间：O(1)
     * 当n越小时越好
     * @param array
     */
    public static void bubbleSort(int[] array) {
        int temp = 0;//临时变量
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                //如果前数大于后数，则交换
                if (array[j] > array[j + 1]) {
                    flag = true;
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            //print(i + 1, array);//输出每一趟的顺序
            if (!flag) {//在本趟排序中，没有交换过
                System.out.println("提前退出");
                break;
            }
        }
    }

    /**
     * 打印数组
     *
     * @param k     第k趟排序
     * @param array 此时数组的顺序
     */
    public static void print(int k, int[] array) {
        System.out.printf("第%d次排序的顺序是【", k);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((i == array.length - 1) ? "" : " "));
        }
        System.out.println("】");
    }

}
