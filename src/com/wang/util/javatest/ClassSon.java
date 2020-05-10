package com.wang.util.javatest;

public class ClassSon extends ClassFather {
    public static Integer a = 2;
    {
        System.out.println("子类普通代码块 a = "+a++);
    }
    static {
        System.out.println("子类静态代码块 a = "+a++);
    }
    public ClassSon() {
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        ClassSon classSon = new ClassSon();
//        父类静态代码块 a = 7
//        子类静态代码块 a = 2
//        父类普通代码块 a = 8
//        父类构造方法
//        子类普通代码块 a = 3
//        子类构造方法
    }
}
