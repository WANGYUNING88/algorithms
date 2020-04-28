package com.wang.datastructure_algorithm.java.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);

        //测试
        preOrder(huffmanTree);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node node) {
        if (node == null)
            return;
        node.preOrder();
    }

    //创建哈夫曼树的方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步为了操作方便
        // 1、遍历数组
        // 2、将arr的元素构建成Node
        // 3、将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int v : arr) {
            nodes.add(new Node(v));
        }

        while (nodes.size() > 1) {

            //排序
            Collections.sort(nodes);

//            System.out.println("nodes:" + nodes);

            //取出根节点权值最小的二叉树
            // 1、取出权值最小的节点（二叉树）
            Node left = nodes.get(0);
            // 2、取出权值次小的节点（二叉树）
            Node right = nodes.get(1);
            // 3、构建一个新的二叉树
            Node parent = new Node(left.value + right.value);
            parent.left = left;
            parent.right = right;
            // 4、从 nodes 中删除处理过的 二叉树
            nodes.remove(0);
            nodes.remove(0);
            // 5、将 parent 加入到 nodes
            nodes.add(parent);
        }

        //返回哈夫曼树的root节点即可
        return nodes.get(0);
    }
}

//创建节点类
//为了让 Node 对象支持排序 Collections 集合
//让 Node 类 实现 Comparable 接口
class Node implements Comparable<Node> {

    int value;//节点 权值
    Node left;//指向左子节点
    Node right;//指向右子节点

    public Node(int value) {
        this.value = value;
    }

    //遍历（前序）
    public void preOrder() {
        System.out.println(this);
        if (this.left != null)
            this.left.preOrder();
        if (this.right != null)
            this.right.preOrder();
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大排列
        //若想表示从大到小，则加个 - 即可
        return this.value - o.value;
    }
}
