package com.wang;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        System.out.println("strings:"+strings);
        strings.remove(0&1);
        System.out.println("strings:"+strings);
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
