package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class QuickSort {
    public static void main(String[] args) {
        //测试排序
        /*int[] array = {-9,78,0,0,0,23,-567,70};
        //int[] array = {-9,78,-4,0,-5,23,-567,70};
        print(0, array);
        quickSort(array,0,array.length-1);*/

        //测试速度 80000 个数据
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 100);//生成一个[0,array.length*100)之间的数
        }
        print(0, array);

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println("排序前的时间 = "+format1);

        //测试排序
        quickSort(array,0,array.length-1);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = "+format2);
    }

    /**
     * 快速排序
     * 平均时间复杂度：O(nlogn)
     * 最差情形：O(n²)
     * 不稳定
     * 额外空间：O(nlogn)
     * n大时好
     *
     * @param array
     */
    public static void quickSort(int[] array,int left,int right) {
        int l = left;//左下标游标
        int r = right;//右下标游标
        int pivot = array[(left+right)/2];//中轴数，标数
        int temp = 0;//临时变量，作为交换时的存储
        //while循环的目的时让比pivot小的放左边，大的放右边
        while (l<r){
            //在pivot左边一直找，直到找到大于等于pivot，退出循环
            while (array[l]<pivot){
                l++;
            }
            //在pivot右边一直找，直到找到小于等于pivot，退出循环
            while (array[r]>pivot){
                r--;
            }
            if (l>=r){
                //l大于等于r，说明pivot两边的值已经规范了
                break;
            }
            //交换
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            //交换完后，如果arr[l] = pivot r左移
            if (array[l]==pivot)
                r--;
            //交换完后，如果arr[r] = pivot l右移
            if (array[r]==pivot)
                l++;
        }
        print(404,array);
        //如果l==r，必须l++;r--，否则栈移除
        if (l==r){
            l++;
            r--;
        }
        //向左递归
        if (left<r){
            System.out.printf("%d 到 %d 之间左排序\n",array[left],array[r]);
            quickSort(array,left,r);
        }
        //向右递归
        if (right>l){
            System.out.printf("%d 到 %d 之间右排序\n",array[l],array[right]);
            quickSort(array,l,right);
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
