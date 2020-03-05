package com.wang;


import java.util.ArrayList;
import java.util.List;

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

//        String [] s = new String[4];
//        s[0] = "+";
//        s[1] = "-";
//        s[2] = "*";
//        s[3] = "/";
//
//        for (int i =0;i<4;i++){
//            System.out.printf("[%s]的等级是*%d*\n",s[i],OperationUtils.getLevel(s[i]));
//        }

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);

        System.out.println("改变前的："+list.toString());
        reverse(list);
        System.out.println("改变后的"+list.toString());
    }

    private static void reverse(List<Integer> list) {
        int size = list.size();
        System.out.println(size);
        if (size>1){
            int temp = 0;
            int l = 0;
            for (int i = 0;i<(size/2);i++){
                l = size-1-i;
                temp = list.get(i);

                list.add(i,list.get(l));
                list.remove(i+1);
                list.remove(l);
                list.add(l,temp);
            }
            System.out.println(list.toString());
        }
    }
}
