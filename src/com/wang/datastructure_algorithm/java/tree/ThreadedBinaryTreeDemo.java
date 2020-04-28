package com.wang.datastructure_algorithm.java.tree;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试中序线索二叉树
        //               1
        //            /     \
        //           3       6
        //         /   \   /   \
        //        8    10 14
        TreeNode2 root = new TreeNode2(1);
        TreeNode2 root1 = new TreeNode2(3);
        TreeNode2 root2= new TreeNode2(6);
        TreeNode2 root3 = new TreeNode2(8);
        TreeNode2 root4 = new TreeNode2(10);
        TreeNode2 root5 = new TreeNode2(14);

        root.setLeft(root1);
        root.setRight(root2);
        root1.setLeft(root3);
        root1.setRight(root4);
        root2.setLeft(root5);

        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(root);
        threadedBinaryTree.threadedNodes();

        //测试：以10号节点 测试
        TreeNode2 left = root4.getLeft();
        TreeNode2 right = root4.getRight();
        System.out.printf("%s号的前驱节点的值是：%s，后继节点的值是：%s",10,left,right);//前驱是3，后继是1

        //测试遍历
//        threadedBinaryTree.preOrderTraverse();//使用原来的遍历方式，会死循环
        System.out.println("使用线索化的方式遍历(中序) --");
        threadedBinaryTree.threadedList();//8 3 10 1 14 6
    }
}

//实现了线索化功能的二叉树
class ThreadedBinaryTree {
    private TreeNode2 root;//根节点
    private TreeNode2 pre = null;//保存当前节点的前驱节点（可以理解为指针）

    public ThreadedBinaryTree(TreeNode2 root) {
        this.root = root;
    }

    //重载
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //遍历线索化二叉树的方法
    public void threadedList(){
        //定义一个变量，存储当前遍历的节点，从root开始
        TreeNode2 node2 = root;
        while (node2!=null){
            //循环的找到leftType == 1 的节点，第一个找到就是这个节点
            //后面随着遍历而变化，因为当leftType==1时，说明该节点是按照线索化
            //处理后的有效节点
            while (node2.getLeftType()==0){
                node2 = node2.getLeft();
            }
            //打印当前节点
            System.out.println(node2);
            //如果当前节点的右指针指向的是后继节点，就一直输出
            while (node2.getRightType()==1){
                //获取到当前节点的后继节点
                node2 = node2.getRight();
                System.out.println(node2);
            }
            //替换这个遍历的节点
            node2 = node2.getRight();
        }
    }

    /**
     * //编写对二叉树进行中序线索化的方法
     *
     * @param root 就是当前需要线索化的节点
     */
    public void threadedNodes(TreeNode2 root) {
        //如果 root == null ,不能线索化
        if (root == null) {
            return;
        }
        //(一)先线索化左子树
        threadedNodes(root.getLeft());
        //(二)先线索化当前节点
        //    处理root节点的前驱节点
        if (root.getLeft() == null) {
            //当前节点的左指针指向前驱节点
            root.setLeft(pre);
            //修改当前左指针类型
            root.setLeftType(1);
        }
        //    处理root节点（下一个节点的前驱节点）的后继节点（下一个节点本身）
        // 难点就在当前结点的后继结点是父节点的，而父节点无法直接通过当前结点获得，
        // 所以只能返回上层递归把它作为上层结点的前驱结点或者左子节点
        if (pre != null && pre.getRight() == null) {
            //前驱节点的右指针指向当前节点
            pre.setRight(root);
            ////修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        // 每处理一个节点，让当前节点是下一个节点的前驱节点
        pre = root;
        // (三)先线索化右子树
        threadedNodes(root.getRight());

    }

    //前序遍历
    public void preOrderTraverse() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.preOrderTraverse();
    }

    //中序遍历
    public void inOrderTraverse() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.inOrderTraverse();
    }

    //后序遍历
    public void postOrderTraverse() {
        if (this.root == null) {
            System.out.println("二叉树为空");
            return;
        }
        this.root.postOrderTraverse();
    }

    //前序遍历查找
    public TreeNode2 preOrderSearch(int no) {
        if (this.root != null)
            return this.root.preOrderSearch(no);
        return null;
    }

    //中遍历查找
    public TreeNode2 inOrderSearch(int no) {
        if (this.root != null)
            return this.root.inOrderSearch(no);
        return null;
    }

    //后序遍历查找
    public TreeNode2 postOrderSearch(int no) {
        if (this.root != null)
            return this.root.postOrderSearch(no);
        return null;
    }

    //删除节点
    public void delNode(int no) {
        if (this.root != null) {
            //判断root是否是要删除的节点
            if (this.root.getNo() == no) {
                this.root = null;
            } else {
                //递归delNode
                this.root.delNode(no);
            }
        } else {
            System.out.println("空树，不能删除节点~~");
        }

    }

}

//二叉树的树节点
class TreeNode2 {
    private int no;
    private TreeNode2 left;
    private TreeNode2 right;

    //规定：type = 0 表明指向的左（右）子树，
    //type = 1 表明指向的是前驱（后继）节点；
    private int leftType;
    private int rightType;

    public TreeNode2(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode2 getLeft() {
        return left;
    }

    public void setLeft(TreeNode2 left) {
        this.left = left;
    }

    public TreeNode2 getRight() {
        return right;
    }

    public void setRight(TreeNode2 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode2{" +
                "no=" + no +
                '}';
    }

    //前序遍历的方法(父节点->左子树->右子树)
    public void preOrderTraverse() {
        System.out.println(this);//输出当前节点
        if (this.left != null)
            //左子树不空，向左子树递归遍历
            this.left.preOrderTraverse();
        if (this.right != null)
            //右子树不空，向右子树递归遍历
            this.right.preOrderTraverse();
    }

    //中序遍历的方法(左子树->父节点->右子树)
    public void inOrderTraverse() {
        //左子树不空，向左子树递归遍历
        if (this.left != null)
            this.left.inOrderTraverse();
        System.out.println(this);//输出当前节点
        //右子树不空，向右子树递归遍历
        if (this.right != null)
            this.right.inOrderTraverse();
    }

    //后序遍历的方法(左子树->右子树->父节点)
    public void postOrderTraverse() {
        //左子树不空，向左子树递归遍历
        if (this.left != null)
            this.left.postOrderTraverse();
        //右子树不空，向右子树递归遍历
        if (this.right != null)
            this.right.postOrderTraverse();
        System.out.println(this);//输出当前节点
    }

    //前序遍历查找
    public TreeNode2 preOrderSearch(int no) {
        //比较当前节点
        if (this.no == no)
            return this;
        TreeNode2 treeNode = null;
        //向左递归查找
        if (this.left != null) {
            treeNode = this.left.preOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //向右递归查找
        if (this.right != null)
            treeNode = this.right.preOrderSearch(no);
        return treeNode;
    }

    //前序遍历查找
    public TreeNode2 inOrderSearch(int no) {
        TreeNode2 treeNode = null;
        //向左递归查找
        if (this.left != null) {
            treeNode = this.left.inOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //比较当前节点
        if (this.no == no)
            return this;
        //向右递归查找
        if (this.right != null)
            treeNode = this.right.inOrderSearch(no);
        return treeNode;
    }

    //后序遍历查找
    public TreeNode2 postOrderSearch(int no) {
        TreeNode2 treeNode = null;
        //向左递归查找
        if (this.left != null) {
            treeNode = this.left.postOrderSearch(no);
        }
        if (treeNode != null)
            return treeNode;
        //向右递归查找
        if (this.right != null)
            treeNode = this.right.postOrderSearch(no);
        if (treeNode != null)
            return treeNode;
        //比较当前节点
        if (this.no == no)
            return this;
        return treeNode;
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //左右节点都不相等，向下递归
        if (this.left != null) {
            this.left.delNode(no);
        }
        if (this.right != null) {
            this.right.delNode(no);
        }
    }

}
