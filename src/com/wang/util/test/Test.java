package com.wang.util.test;


import java.util.List;
import java.util.Scanner;

class Node implements Comparable<Node>{
    int value;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        return this.value - 0;
    }
}

public class Test {

    public static char getKey(int i) {
        char[] chars = {'1', '3', '9', '5', '4', '6', '2', '8', '7'};
        return chars[i];
    }

    public static void jiamijiemi() {
        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("输入【0】加密");
            System.out.println("输入【1】加密");
            System.out.println("其他输入 退出");
            String i = scanner.nextLine();
            switch (i) {
                case "0":
                    int random = (int) (Math.random() * 9);
                    String s = scanner.nextLine();
                    char[] chars = s.toCharArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(random);
                    for (char c : chars) {
                        stringBuilder.append((char) (c ^ getKey(random)));
                    }
                    System.out.println("加密 = " + stringBuilder.toString());
                    break;
                case "1":
                    String s1 = scanner.nextLine();
                    char[] chars1 = s1.toCharArray();
                    int ii = 0;
                    if (48 <= chars1[0] || chars1[0] <= 57) {
                        ii = chars1[0] - 48;
//                        System.out.println(ii);
                    }
                    StringBuilder stringBuilder1 = new StringBuilder();
                    for (int k = 1; k < chars1.length; k++) {
                        stringBuilder1.append((char) (chars1[k] ^ getKey(ii)));
                    }
                    System.out.println("解密 = " + stringBuilder1.toString());
                    break;
                default:
                    scanner.close();
                    return;
            }

        }
    }

    public static void main(String[] args) {
        jiamijiemi();
//        double d = 1000.00;
//        System.out.println(1000.00*25.00);
    }


//        int arr[] = {13, 7, 8, 3, 29, 6, 1};
//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        List<String> strings = new ArrayList<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
//        System.out.println("strings:"+strings);
//        strings.remove(0&1);
//        System.out.println("strings:"+strings);

//        Map<String,Integer> map = new HashMap<>();
//        map.put("1",1);
//        map.put("1",map.get("1")+1);
//        map.put("2",map.get("2")+1);
//
//        System.out.println(map);

//        String str = "1010000";
////        System.out.println((byte)Integer.parseInt(str,2));
//        int i = 5;
////        System.out.println((i+8)>str.length()?str.length():i+8);
//        System.out.println(str.substring(1,8));


//        int temp =-5;
//        temp |= 256;//按位或运算 256 => 1 0000 0000 | 0 0000 0001 = 1 0000 0001

//        String string = Integer.toBinaryString(temp);//返回的是 temp 对应的 二进制补码
//        System.out.println(string);

//        StringBuilder stringBuilder = new StringBuilder("10101000101111");
//        Map<String,String > map = new HashMap<>();
//        map.put("101010","1");
//        map.put("00101111","2");
//        StringBuilder key = null;
//        for (int i =0;i<stringBuilder.length();){
//            String b = null;
//            key = new StringBuilder();
//            while (b==null&&i<stringBuilder.length()){
//                key.append(stringBuilder.substring(i++,i));
//                b = map.get(key.toString());
//            }
//            System.out.println(b);
//        }

//        final StringBuilder s = new StringBuilder("2222");
//        s.append("c");
//        System.out.printf("[s=] %s\n",s);
//        final String s1 = s.toString();
//        s1. = "333";


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
