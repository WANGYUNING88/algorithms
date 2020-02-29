package com.wang.datastructure_algorithm.java.recursion;

public class Queue8 {
    private static int max = 8;//多少个皇后
    private static int count = 0;//储存答案个数
    private static int[] arr = new int[max];//存储答案

    public static void main(String[] args) {
        //测试 8皇后是否正确
        check(0);
    }

    //放置第n个皇后
    public static void check (int n){
        if (n==max){//n=8时，说明8个皇后就放好了
            count++;
            print();
            return;
        }
        //依次放入皇后，并判断是否冲突
        //先把当前的皇后放在这行的第一列
        for (int i = 0;i<max;i++){
            //这是第n行第i列的位置放皇后
            arr[n] = i;
            if (judge(n)){
                //不冲突
                check(n+1);
            }
            //如果冲突继续执行for循环到本行的下一列；
        }
    }

    //将皇后摆放的位置输出
    public static void print() {
        System.out.printf("第%d种答案: ",count);
        for (int i =0;i<max;i++){
            System.out.printf("【 %d 】",arr[i]);
        }
        System.out.println();
    }

    /**
     *     //判断第n个是否前面已经摆放好的冲突
     * @param n
     * @return true不冲突 false冲突
     */

    public static boolean judge(int n) {
        for (int i = 0;i<n;i++){
            //arr[i] == arr[n] 第n个和第i是同一列
            //Math.abs(n-1)==Math.abs(arr[n]-arr[i]) 第n个和第i是同一斜线
            //n就是代表行，不可能在同一行
            if (arr[i] == arr[n] || Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }
}
