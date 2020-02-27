package com.wang.datastructure.java.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotationt {
    public static void main(String[] args) {
        String key = "4 5 * 8 - 60 + 8 2 / +";
        //思路
        //1.先将suffixExpression放入到ArrayList中
        List<String> listString = getListString(key);
        //将list传入到一个计算方法中
        int calculator = calculator(listString);
        System.out.printf("%s = %d\n", key, calculator);
    }

    public static List<String> getListString(String suffixExpression) {
        //分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //逆波兰表达书计算方法
    public static int calculator(List<String> listString) {
        //创建一个栈
        Stack<String> stack = new Stack<>();
        //遍历 listString
        for (String item : listString) {
            //判断数（正则）
            if (item.matches("\\d+")) {//匹配多位数
                //直接入栈
                stack.push(item);
            } else {
                //运算符 出栈两个数和当前符号运算，结果入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符非法~~");
                }
                stack.push("" + res);
            }
        }
        //栈中只有一个数据就是结果了
        return Integer.parseInt(stack.pop());
    }
}
