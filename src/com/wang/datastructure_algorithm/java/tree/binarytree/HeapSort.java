package com.wang.datastructure_algorithm.java.tree.binarytree;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数据升序
        // int arr[] = {4, 6, 8, 5, 9};
//        int arr[] = {4, 6, 8, 0, 2, 34, 23, 10, 5, 9};
//
//        heapSort(arr);

        int[] array = new int[8000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 8000000);
        }

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println(new StringBuilder().append("排序前的时间 = ").append(format1).toString());

        heapSort(array);

        Date date2 = new Date();

        String format2 = format.format(date2);
        System.out.println(new StringBuilder().append("排序后的时间 = ").append(format2).toString());

    }

    //编写 推排序 的方法
    public static void heapSort(int[] arr) {
        System.out.println("推排序");

        int temp = 0;
//        //分布
//        //1
//        adjustHeap(arr,1,arr.length);
//        System.out.println("第一次:"+ Arrays.toString(arr));//第一次:[4, 9, 8, 5, 6]
//        //2
//        adjustHeap(arr,0,arr.length);
//        System.out.println("第二次:"+ Arrays.toString(arr));//第二次:[9, 6, 8, 5, 4]

        //整合分步
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        for (int j = arr.length - 1; j > 0; j--) {
            //交换
            //此时，堆顶的元素是最大的，将其 与 末尾元素交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }

        //输出
//        System.out.println("排完序的数组：" + Arrays.toString(arr));
    }

    //将一个 数组（二叉树） 调整成一个大（小）顶堆

    /**
     * 完成 将 以 i对应的非叶子节点的树 调整成 大顶堆
     *
     * @param arr    代调整的数组
     * @param i      表示非叶子节点在数组中的索引
     * @param lenght 表示对多少的元素进行调整
     */
    public static void adjustHeap(int arr[], int i, int lenght) {
        int temp = arr[i];//先取出当前元素的值，保存在临时变量
        //开始调整
        //说明 ： k 是 i 节点的左子节点
        for (int k = i * 2 + 1; k < lenght; k = k * 2 + 1) {
            if (k + 1 < lenght && arr[k] < arr[k + 1]) {
                //说明 左子节点 小于 右子节点
                k++;// k 指向 右子节点
            }
            if (arr[k] > temp) {
                //如果 子节点 大于 父节点
                arr[i] = arr[k];//把较大的值赋给当前节点
                i = k;//！！！ i 指向 k，继续循环比较
            } else {
                break;
            }
        }
        //for 循环结束后，最大值 已经将以 i 为父节点树的最大值，放在了最顶上（局部）
        arr[i] = temp;//将temp的值放在调整后的位置
    }
}
