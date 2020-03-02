package com.wang.datastructure_algorithm.java.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[8];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * array.length * 100.0D);
        }

        Date date1 = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format1 = format.format(date1);
        System.out.println(new StringBuilder().append("排序前的时间 = ").append(format1).toString());

        shellSort2(array);

        Date date2 = new Date();

        String format2 = format.format(date2);
        System.out.println(new StringBuilder().append("排序后的时间 = ").append(format2).toString());
    }

    public static void shellSort1(int[] array) {
        int temp = 0;
        int count = 1;

        for (int gap = array.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < array.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (array[j] <= array[(j + gap)])
                        continue;
                    temp = array[j];
                    array[j] = array[(j + gap)];
                    array[(j + gap)] = temp;
                }
            }
    }

    public static void shellSort2(int[] array) {
        int count = 1;

        for (int gap = array.length / 2; gap > 0; gap /= 2)
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[(j - gap)]) {
                    while ((j - gap >= 0) && (temp < array[(j - gap)])) {
                        array[j] = array[(j - gap)];
                        j -= gap;
                    }

                    array[j] = temp;
                }
            }
    }

    public static void print(int k, int[] array) {
        if (k == 0)
            System.out.printf("数组原顺序是【", new Object[]{Integer.valueOf(k)});
        else {
            System.out.printf("第%d次排序的顺序是【", new Object[]{Integer.valueOf(k)});
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(new StringBuilder().append(array[i]).append(i == array.length - 1 ? "" : " ").toString());
        }
        System.out.println("】");
    }
}