package com.wang.util.test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {

    }

    //保留小数点后10位
    public static void chufa() {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("输入一个被除数");
            int num1 = scanner.nextInt();
            System.out.println("输入一个除数");
            int num2 = scanner.nextInt();
            StringBuilder s = new StringBuilder();
            int index = 0;
            if (num1==0){
                System.out.println(0);
                return;
            }else if (num2==0) {
                System.out.println("除数不能是0");
                return;
            }
            if (num1%num2==0){
                System.out.println(num1/num2);
                return;
            }else {
                s.append(num1/num2+".");
                num1 = num1%num2;
                while (num1 != 0 && index < 10) {
                    num1*=10;
                    s.append(num1 / num2);
                    num1 = num1%num2;
                    index++;
                }
                System.out.println(s.toString());
            }
        }
    }
}
