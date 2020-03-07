package com.wang.datastructure_algorithm.java.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //创建一个二叉树
//        结构是          1
//                       / \
//                      2   3
//                     / \
//                    4   5
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        root.setLeft(treeNode);
        root.setRight(treeNode1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);

        //测试
        System.out.println("前序遍历~~");
        root.preOrderTraverse();//1->2->4->5->3
        System.out.println("中序遍历~~");
        root.inOrderTraverse();//4->2->5->1->3
        System.out.println("后序遍历~~");
        root.postOrderTraverse();//4->5->2->3->1
    }
}

//定义二叉树
class BinaryTree{
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrderTraverse(){
        if (this==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.preOrderTraverse();
    }
    //中序遍历
    public void inOrderTraverse(){
        if (this==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.inOrderTraverse();
    }
    //后序遍历
    public void postOrderTraverse(){
        if (this==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.postOrderTraverse();
    }
}

//树节点
class TreeNode{
    private int no;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }

    //前序遍历的方法(父节点->左子树->右子树)
    public void preOrderTraverse(){
        System.out.println(this);//输出当前节点
        if (this.left!=null)
            //左子树不空，向左子树递归遍历
            this.left.preOrderTraverse();
        if (this.right!=null)
            //右子树不空，向右子树递归遍历
            this.right.preOrderTraverse();
    }

    //中序遍历的方法(左子树->父节点->右子树)
    public void inOrderTraverse(){
        //左子树不空，向左子树递归遍历
        if (this.left!=null)
            this.left.inOrderTraverse();
        System.out.println(this);//输出当前节点
        //右子树不空，向右子树递归遍历
        if (this.right!=null)
            this.right.inOrderTraverse();
    }

    //后序遍历的方法(左子树->右子树->父节点)
    public void postOrderTraverse(){
        //左子树不空，向左子树递归遍历
        if (this.left!=null)
            this.left.postOrderTraverse();
        //右子树不空，向右子树递归遍历
        if (this.right!=null)
            this.right.postOrderTraverse();
        System.out.println(this);//输出当前节点
    }

}