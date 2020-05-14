package com.wang.util.javatest;

public class Test implements TestInterface {
    @Override
    public int getA() {
        return a+1;
    }

    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println(Test.a);
//        System.out.println(new Test().getA());
//
//        Integer a= new Integer(1);
//        Integer b= new Integer(1);
//        int c = 1;
//        System.out.println(a == b);
//        System.out.println(a == c);

        Class c = Class.forName("com.wang.util.test.Test");
//        Te  = c.getClass();
        c.getCanonicalName();
    }
}
