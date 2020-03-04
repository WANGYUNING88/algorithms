package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MergetSort {
    public static void main(String[] args) {
        //测试排序
        int[] array = {8,4,5,7,1,3,6,2};
        //int[] array = {-9,78,-4,0,-5,23,-567,70};
        print(0, array);
        int[] temp = new int[array.length];//归并排序需要额外的空间开销
        mergetSort(array,0,array.length-1,temp);
        print(-1, array);
/*        //测试速度 80000 个数据
        int[] array = new int[80000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 100);//生成一个[0,array.length*100)之间的数
        }
        //print(0, array);
        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println("排序前的时间 = "+format1);

        int[] temp = new int[array.length];
        //测试排序
        mergetSort(array,0,array.length-1,temp);

        Date date2 = new Date();
        //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format2 = format.format(date2);
        System.out.println("排序后的时间 = "+format2);

        //print(-1,array);*/
    }

    /**
     *归并排序
     * 平均时间复杂度：O(nlogn)
     * 最差情形：O(nlogn)
     * 稳定
     * 额外空间：O(1)
     * n大时好
     *
     * @param array
     */
    public static void mergetSort(int[] array,int left,int right,int[] temp) {
        if (left < right){
            int mid = (left+right)/2;
            //向左递归分解
            mergetSort(array,left,mid,temp);
            //向右递归分解
            mergetSort(array,mid+1,right,temp);
            //合并
            merget(array,left,mid,right,temp);
        }
    }

    /**
     * 合并的方法
     * @param array 排序的原始数列
     * @param left 初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 中转临时数组
     */
    public static void merget(int[] array,int left,int mid,int right,int[] temp){
        int i = left;//左边有序序列的初始索引游标
        int j = mid+1;//右边有序序列的初始索引游标
        int t= 0;//指向temp数组的当前索引
        //先把左右两边的数据按照填充规则充到temp数组中
        //直至有一边处理完
        while (i<=mid && j<=right){
            if (array[i]<array[j]){
                //如果左边数组的当前元素小于等于右边的当前元素
                // 就将左边的元素写到temp，
                temp[t++] = array[i++];
            }else {
                //反之，就将右边的元素加入到temp数组中
                temp[t++] = array[j++];
            }
        }
        //把剩余的一组数据填充到temp
        while (i<=mid){
            //左边还有剩余数，
            temp[t++] = array[i++];
        }
        while (j<=right){
            //右边还有剩余数，
            temp[t++] = array[j++];
        }
        //将temp数组拷贝到array数组中
        t = 0;
        int tempLeft = left;
        System.out.printf("【%d - %d】\n",tempLeft,right);
        while (tempLeft<=right){
            array[tempLeft++] = temp[t++];
        }
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
