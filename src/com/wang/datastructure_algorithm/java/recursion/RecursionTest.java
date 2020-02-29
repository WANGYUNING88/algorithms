package com.wang.datastructure_algorithm.java.recursion;

public class RecursionTest {
    public static void main(String[] args) {
        //test(6);
        int i = 3;
        System.out.printf("%d 的阶乘是 %d",i,factorial(i));
    }

    //打印问题
    public static void test(int n) {
        if(n>2){
            test(n-1);
        }
        System.out.printf("n=%d\n",n);
    }
    //阶乘问题
    public static int factorial(int n) {
        if (n<=2){
            return n;
        }else {
            return factorial(n-1)*n;
        }

    }
}
