package com.wang.util.javatest;

public class ClassFather {
    public static Integer a = 7;
    {
        System.out.println("父类普通代码块 a = "+a++);
    }
    static {
        System.out.println("父类静态代码块 a = "+a++);
    }
    public ClassFather() {
        System.out.println("父类构造方法");
    }
}
