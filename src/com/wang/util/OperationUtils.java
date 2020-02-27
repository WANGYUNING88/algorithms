package com.wang.util;

/**
 * 运算工具包
 */
public class OperationUtils {
    private static int ERR = -1;//非定义的运算符
    private static int ADD = 1;//+
    private static int SUB = 1;//-
    private static int MUL = 2;//*
    private static int DIV = 2;///

    //返回优先级数字
    public static int getLevel(String operation){
        switch (operation){
            case "+":
                return ADD;
            case "-":
                return SUB;
            case "*":
                return MUL;
            case "/":
                return DIV;
            default:
                return ERR;
        }

    }
}
