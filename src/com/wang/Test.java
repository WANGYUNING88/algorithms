package com.wang;


import java.util.*;

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
    public static void main(String[] args) {
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


        StringBuilder stringBuilder = new StringBuilder("10101000101111");
        Map<String,String > map = new HashMap<>();
        map.put("101010","1");
        map.put("00101111","2");
        StringBuilder key = null;
        for (int i =0;i<stringBuilder.length();){
            String b = null;
            key = new StringBuilder();
            while (b==null&&i<stringBuilder.length()){
                key.append(stringBuilder.substring(i++,i));
                b = map.get(key.toString());
            }
            System.out.println(b);
        }
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
