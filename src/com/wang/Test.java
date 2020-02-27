package com.wang;

import com.wang.util.OperationUtils;

public class Test {
    public static void main(String[] args) {

/*        char ch1 = '1';
        char ch2 = '+';
        char ch3 = '3';
        int i = 43;
      System.out.println(ch1+ch2+ch3+"");
       System.out.println(""+ch1+ch3);
        //System.out.println((char)i);
        String s = "2";
        System.out.println(s.substring(0,1).toString());*/

        String [] s = new String[4];
        s[0] = "+";
        s[1] = "-";
        s[2] = "*";
        s[3] = "/";

        for (int i =0;i<4;i++){
            System.out.printf("[%s]的等级是*%d*\n",s[i],OperationUtils.getLevel(s[i]));
        }



    }
}
