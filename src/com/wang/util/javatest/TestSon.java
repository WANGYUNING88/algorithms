package com.wang.util.javatest;

public class TestSon extends TestFather implements TestInterface{
    @Override
    public int getA() {
        return a;
    }

    @Override
    int getB() {
        return a^a;
    }

    @Override
    int getC() {
        return 0;
    }

    @Override
    int getAA() {
        return 0;
    }

    @Override
    int getBB() {
        return 0;
    }


}
