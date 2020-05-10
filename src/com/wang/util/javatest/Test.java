package com.wang.util.javatest;

public class Test implements TestInterface {
    @Override
    public int getA() {
        return a+1;
    }

    public static void main(String[] args) {
        System.out.println(Test.a);
        System.out.println(new Test().getA());
    }
}
