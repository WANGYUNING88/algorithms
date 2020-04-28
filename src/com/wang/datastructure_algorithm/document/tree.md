# 树tree
## 二叉树
### 树的常用术语(结合示意图理解):
    节点
    根节点
    父节点
    子节点
    叶子节点 (没有子节点的节点)
    节点的权(节点值)
    路径(从root节点找到该节点的路线)
    层
    子树
    树的高度(最大层数)
    森林 :多颗子树构成森林
 
### 二叉树概念
    1. 树有很多种，每个节点最多只能有两个子节点的一种形式称为二叉树。
    2. 二叉树的子节点分为左节点和右节点。
    3. 如果该二叉树的所有叶子节点都在最后一层，并且结点总数= 2^n -1 , n 为层数，则我们称为满二叉树。
    4. 如果该二叉树的所有叶子节点都在最后一层或者倒数第二层，而且最后一层的叶子节点在左边连续，倒数第二层的叶子节点在右边连续，我们称为完全二叉树。

## 顺序存储二叉树
### 顺序存储二叉树概念
    从数据存储来看，数组存储方式和树的存储方式可以相互转换。
### 顺序存储二叉树的特点
    1. 顺序二叉树通常只考虑完全二叉树
    2. 第n个元素的左子节点为 2 * n + 1;
    3. 第n个元素的右子节点为 2 * n + 2;
    4. 第n个元素的父节点为（n - 1）/ 2;
    5. n：表示二叉树中第几个元素（从 0 开始编号，即需要和数组保持一致）
## 线索化二叉树
### 基本介绍
    1. n个结点的二叉链表中含有n+1  【公式 2n-(n-1)=n+1】 个空指针域。
    利用二叉链表中的空指针域，存放指向该结点在某种遍历次序下的前驱和后继结
    点的指针（这种附加的指针称为"线索"）
    2. 这种加上了线索的二叉链表称为线索链表，相应的二叉树称为
    线索二叉树(Threaded BinaryTree)。根据线索性质的不同，
    线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
    3. 一个结点的前一个结点，称为前驱结点
    4. 一个结点的后一个结点，称为后继结点