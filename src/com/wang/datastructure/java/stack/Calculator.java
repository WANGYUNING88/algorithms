package com.wang.datastructure.java.stack;

import java.util.Scanner;

public class Calculator {
    public static int calculator(String expression) {
        //创建数栈和符号栈
        ArrayStack2 numStack = new ArrayStack2(expression.length());
        ArrayStack2 operStack = new ArrayStack2(expression.length());
        //定义相关变量
        int index = 0;//用于扫描
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;//结果
        char ch = ' ';//保存扫描的char
        String keepNum = "";//用于拼接多位数的
        //开始扫描
        while (true){
            //依次得到expression的每一个字符
            ch = expression.substring(index,index+1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (operStack.isOper(ch)){
                //如果是一个运算符
                if (!operStack.isEmpty()){
                    //如果符合栈有操作符就进行比较，如果当前操作符优先级小于或等于栈顶，
                    //就需要从从数栈中pop两个数，从符号栈中pop一个符号，进行运算得到结果，
                    //入数栈，然后当前符号入符号栈
                    if (operStack.proprity(ch)<=operStack.proprity(operStack.peek())){
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1,num2,oper);
                        //结果入数栈
                        numStack.push(res);
                        //符号入符号栈
                        operStack.push(ch);
                    }else {
                        //如果当前操作符优先级大于栈顶，就直接入符号栈
                        operStack.push(ch);
                    }
                }else {
                    //空：直接入栈
                    operStack.push(ch);
                }
            }else {
                //如果是数，直接入数栈
                //numStack.push(ch - 48);//是char字符的1，不是真正的1；
                //当处理多位数时，不能发现一个数就入栈
                //需要向expression的表达式向后看几位，
                //定义一个字符串变量用于拼接
                //处理多位数

                keepNum+=ch;

                //ch是最后一个直接入栈
                //判断下一个字符是不是数，如果时数，继续扫描，如是运算符，就入栈
                if (index==expression.length()-1||operStack.isOper(expression.substring(index+1,index+2).charAt(0))){
                    //是运算符，入栈
                    numStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            }
            //让index+1，并判断是否扫描到expression最后
            index++;
            if (index == expression.length())
                break;
        }
        if (operStack.isEmpty()) {
            //将数栈的最后一个出栈就是结果
            return numStack.pop();
        } else if (operStack.size() == 1) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            return numStack.cal(num1, num2, oper);
        } else {
            String newexpression = "";
            while (!operStack.isEmpty()) {
                newexpression = "" + (char) operStack.pop() + numStack.pop() + newexpression;
            }
            newexpression = "" + numStack.pop() + newexpression;
            //System.out.println(newexpression);
            return calculator(newexpression);
        }

    }
    public static void main(String[] args) {
        //根据前面的思路，完成表达式的运算
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;//是否退出菜单
        String key = "";
        while(loop){
            System.out.println("请输入要计算的表达式或者exit/退出");
            key = scanner.next();
            switch (key){
                case "退出":
                    scanner.close();
                    loop=false;
                    break;
                case "exit":
                    scanner.close();
                    loop=false;
                    break;
                default:
                    System.out.printf("表达式【%s】的结果是【%d】\n", key, calculator(key));
                    break;
            }
        }
        System.out.println("退出系统~~");
    }
}

/**
 * 创建一个数组模拟栈，可以使用前面的需要扩展功能
 */
class ArrayStack2 {
    private int maxSize;//容量
    private int[] stack;//数组模拟栈
    private int top = -1;//栈顶的指针，默认是-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    //栈的size
    public int size() {
        return top + 1;
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈
    public void push(int value) {
        //判断栈是否满
        if (isFull()) {
            System.out.println("栈满~~");
            return;
        }
        stack[++top] = value;
    }

    //出栈
    public int pop() {
        //判断是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，无数据~~");
        }
        return stack[top--];
    }

    //返回栈顶的值，不是出栈pop
    public int peek() {
        //判断是否空
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，无数据~~");
        }
        return stack[top];
    }

    //遍历
    public void list() {
        //是否为空
        if (isEmpty()) {
            System.out.println("栈空，无数据~~");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，数字越大，优先级越大
    public int proprity(int oper) {
        //目前只有+-*/
        if (oper == '*' || oper == '/')
            return 1;
        else if (oper == '+' || oper == '-')
            return 0;
        else
            return -1;
    }
    //判断是不是一个运算符
    public boolean isOper(char val){
        return val=='+'||val=='-'||val=='*'||val=='/';
    }
    /**
     *     计算方法
     * @param num1 先弹出的数
     * @param num2 后弹出的数
     * @param oper 运算符
     */
    public int cal(int num1,int num2,int oper){
        int res = 0;
        switch (oper){
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
        }
        return res;
    }
}