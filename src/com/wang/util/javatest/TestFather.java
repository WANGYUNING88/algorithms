package com.wang.util.javatest;

public abstract class TestFather {
    private static int a = 3;
    abstract int getA();
    abstract int getB();
    abstract int getC();
    private static int getAA(){
        return a;
    }
}
