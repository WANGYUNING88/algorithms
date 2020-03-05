package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
 /*       //测试排序
        int[] array = {53,3,542,748,14,214};
        //int[] array = {-9,78,-4,0,-5,23,-567,70};
        print(0, array);
        radixSort(array);*/
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

        //int[] temp = new int[array.length];
        //测试排序
        radixSort(array);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = "+format2);

        //print(-1,array);
    }

    /**
     * 基数排序(桶排序)
     * 空间换时间
     * 平均时间复杂度：O(logRB)
     * 最差情形：O(logRB)
     * 稳定
     * 额外空间：O(n)
     * R是基数个十百 B是真数0-9
     *
     * @param array
     */
    public static void radixSort(int[] array) {

        int index = 0;//原来数组的下标，方便重新写入
        //定义一个二维数组模拟10个桶
        int[][] bucket = new int[10][array.length];
        //记录每个桶中存放了多少的数据，定义一维数组记录
        int[] bucketElementCounts = new int[10];
        int maxDigit = getMaxDigit(array);
        for (int i = 0,n = 1;i<maxDigit;i++,n*=10) {
            //i表示第几轮排序 n表示对应位级的值
            //i=0 按个位排序 i=1 按十位排序 i=2 按百位排序 。。。
            //n=1 个位 n=10 十位 n=100 百位
            for (int j = 0; j < array.length; j++) {
                //取出每个元素的个位数
                int digitOfElement = array[j] /n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]++] = array[j];
            }
            index = 0;
            //遍历每一个桶，将桶中的数据放到原数组
            for (int j = 0; j < bucketElementCounts.length; j++) {
                //如果桶存放数据，就遍历这个桶
                if (bucketElementCounts[j] != 0) {
                    for (int k = 0; k < bucketElementCounts[j]; k++) {
                        //取出数，放到原数组中
                        array[index++] = bucket[j][k];
                    }
                    bucketElementCounts[j] = 0;//重置方便下一轮计数
                }
            }
            //print(i+1, array);
        }
    }

    //获取最大值的位数
    public static int getMaxDigit(int[] array) {
        int max = array[0];
        for (int i = 1;i<array.length;i++){
            if (array[i]>max){
                max= array[i];
            }
        }
        return (max+"").length();
    }

    /**
     * 打印数组
     *
     * @param k     第k趟排序
     * @param array 此时数组的顺序
     */
    public static void print(int k, int[] array) {
        if (k < 0) {
            System.out.printf("数组排序后顺序是【");
        } else if (k == 0) {
            System.out.printf("数组原顺序是【");
        } else {
            System.out.printf("第%d次排序的顺序是【", k);
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ((i == array.length - 1) ? "" : " "));
        }
        System.out.println("】");
    }

}
