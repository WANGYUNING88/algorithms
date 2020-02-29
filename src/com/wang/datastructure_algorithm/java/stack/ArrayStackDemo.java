package com.wang.datastructure_algorithm.java.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        //测试数组模拟栈
        //创建
        ArrayStack stack = new ArrayStack(4);
        String key = "";
        boolean loop = true;//是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while (loop){
            System.out.println("show[s]:显示栈");
            System.out.println("exit[e]:退出");
            System.out.println("push[+]:入栈");
            System.out.println("pop[-]:出栈");
            System.out.println("请出入选择");
            key = scanner.next();
            switch (key){
                case "s":
                    stack.list();
                    break;
                case "w":
                    scanner.close();
                    loop=false;
                    break;
                case "+":
                    System.out.println("请输入要给数~~");
                    int i = scanner.nextInt();
                    stack.push(i);
                    break;
                case "-":
                    try {
                        int result = stack.pop();
                        System.out.printf("出栈的数据是 %d ",result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出了~~");
    }
}
//数组模拟栈的类
class ArrayStack{
    private int maxSize;//容量
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶的指针，默认是-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }
    //栈满
    public boolean isFull(){
        return top==maxSize-1;
    }
    //栈空
    public boolean isEmpty(){
        return top==-1;
    }
    //入栈
    public void push(int value){
        //判断栈是否满
        if (isFull()){
            System.out.println("栈满~~");
            return;
        }
        stack[++top] = value;
    }
    //出栈
    public int pop(){
        //判断是否空
        if (isEmpty()){
            //抛出异常
            throw new RuntimeException("栈空，无数据~~");
        }
        return stack[top--];
    }
    //遍历
    public void list(){
        //是否为空
        if (isEmpty()) {
            System.out.println("栈空，无数据~~");
        }
        for (int i=top;i>=0;i--){
            System.out.printf("stack[%d]=%d\n",i,stack[i]);
        }
    }
}
