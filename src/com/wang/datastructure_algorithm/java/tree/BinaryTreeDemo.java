package com.wang.datastructure_algorithm.java.tree;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        //创建一个二叉树
//        结构是            1
//                        /   \
//                      2      3
//                     / \    / \
//                    4   5  6   7
        BinaryTree binaryTree = new BinaryTree(root);
        TreeNode treeNode = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(5);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(7);
        root.setLeft(treeNode);
        root.setRight(treeNode1);
        treeNode.setLeft(treeNode2);
        treeNode.setRight(treeNode3);
        treeNode1.setLeft(treeNode4);
        treeNode1.setRight(treeNode5);

        /*//测试遍历
        System.out.println("前序遍历~~");
        binaryTree.preOrderTraverse();//1->2->4->5->3
        System.out.println("中序遍历~~");
        binaryTree.inOrderTraverse();//4->2->5->1->3
        System.out.println("后序遍历~~");
        binaryTree.postOrderTraverse();//4->5->2->3->1*/

/*        //测试查找
        System.out.println("前序查找~~");
        TreeNode node = binaryTree.preOrderSearch(5);
        if (node!=null)
            System.out.printf("【前序】找到了No.%d的节点\n",5);
        else
            System.out.printf("【前序】没有找到No.%d的节点\n",5);
        System.out.println("中序查找~~");
        node = binaryTree.inOrderSearch(5);
        if (node!=null)
            System.out.printf("【中序】找到了No.%d的节点\n",5);
        else
            System.out.printf("【中序】没有找到No.%d的节点\n",5);
        System.out.println("后序查找~~");
        node = binaryTree.postOrderSearch(5);
        if (node!=null)
            System.out.printf("【后序】找到了No.%d的节点\n",5);
        else
            System.out.printf("【后序】没有找到No.%d的节点\n",5);*/

        //测试删除
        binaryTree.delNode(4);
        binaryTree.preOrderTraverse();
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
        if (this.root==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.preOrderTraverse();
    }
    //中序遍历
    public void inOrderTraverse(){
        if (this.root==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.inOrderTraverse();
    }
    //后序遍历
    public void postOrderTraverse(){
        if (this.root==null){
            System.out.println("二叉树为空");
            return;
        }
        this.root.postOrderTraverse();
    }

    //前序遍历查找
    public TreeNode preOrderSearch(int no){
        if (this.root!=null)
            return this.root.preOrderSearch(no);
        return null;
    }
    //中遍历查找
    public TreeNode inOrderSearch(int no){
        if (this.root!=null)
            return this.root.inOrderSearch(no);
        return null;
    }
    //后序遍历查找
    public TreeNode postOrderSearch(int no){
        if (this.root!=null)
            return this.root.postOrderSearch(no);
        return null;
    }

    //删除节点
    public void delNode(int no){
        if (this.root != null){
            //判断root是否是要删除的节点
            if (this.root.getNo()==no){
                this.root = null;
            }else {
                //递归delNode
                this.root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除节点~~");
        }

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

    //前序遍历查找
    public TreeNode preOrderSearch(int no){
        //比较当前节点
        if (this.no==no)
            return this;
        TreeNode treeNode = null;
        //向左递归查找
        if (this.left!=null){
            treeNode  = this.left.preOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //向右递归查找
        if (this.right!=null)
            treeNode = this.right.preOrderSearch(no);
        return treeNode;
    }

    //前序遍历查找
    public TreeNode inOrderSearch(int no){
        TreeNode treeNode = null;
        //向左递归查找
        if (this.left!=null){
            treeNode  = this.left.inOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //比较当前节点
        if (this.no==no)
            return this;
        //向右递归查找
        if (this.right!=null)
            treeNode = this.right.inOrderSearch(no);
        return treeNode;
    }

    //后序遍历查找
    public TreeNode postOrderSearch(int no){
        TreeNode treeNode = null;
        //向左递归查找
        if (this.left!=null){
            treeNode  = this.left.postOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //向右递归查找
        if (this.right!=null)
            treeNode = this.right.postOrderSearch(no);
        if (treeNode != null)
            return treeNode;
        //比较当前节点
        if (this.no==no)
            return this;
        return treeNode;
    }

    //删除节点
    public void delNode(int no){
        if (this.left!=null && this.left.no==no){
            this.left = null;
            return;
        }
        if (this.right!=null && this.right.no == no){
            this.right = null;
            return;
        }
        //左右节点都不相等，向下递归
        if (this.left!=null){
            this.left.delNode(no);
        }
        if (this.right!=null){
            this.right.delNode(no);
        }
    }

}