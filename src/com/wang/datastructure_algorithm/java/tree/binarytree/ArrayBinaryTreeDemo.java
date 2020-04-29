package com.wang.datastructure_algorithm.java.tree.binarytree;

public class ArrayBinaryTreeDemo {
    /**
     * 需求: 给你一个数组 {1,2,3,4,5,6,7}，要求以二叉树前序遍历的方式进行遍历。
     * 前序遍历的结果应当为 1,2,4,5,3,6,7
     * @param args
     */
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.perOrder();//1 2 4 5 3 6 7;
    }

}
//编写一个 ArrayBinaryTree ,实现顺序存储二叉树遍历
class ArrayBinaryTree{
    private int[] arr;//存储数据节点的数组

    public ArrayBinaryTree(int[] arr){
        this.arr = arr;
    }

    //重载这个方法
    public void perOrder(){
        this.perOrder(0);
    }

    /**
     *  编写一个方法，完成顺序存储二叉树的前序遍历
     * @param index 数组下标
     */
    public void perOrder(int index){
        //如果数组为空，或者arr.lenth = 0;
        if (arr==null||arr.length==0){
            System.out.println("数组为空，不能操作~~~");
            return;
        }else if (index<0||index>=arr.length)
            return;
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归
        perOrder(2*index+1);
        //向右递归
        perOrder(2*index+2);
    }

}
