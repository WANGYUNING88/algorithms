package com.wang.datastructure.java.listedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode songjiang1 = new HeroNode(1, "宋江", "及时雨（呼保义）");
        HeroNode lujunyi2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode wuyong3 = new HeroNode(3, "吴用", "智多星");
        HeroNode gongsunsheng4 = new HeroNode(4, "公孙胜", "入云龙");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(songjiang1);
//        singleLinkedList.add(lujunyi2);
//        singleLinkedList.add(wuyong3);
//        singleLinkedList.add(gongsunsheng4);
        //加入按照编号
        singleLinkedList.addByOrder(songjiang1);
        singleLinkedList.addByOrder(wuyong3);
        singleLinkedList.addByOrder(lujunyi2);
        singleLinkedList.addByOrder(gongsunsheng4);
        singleLinkedList.addByOrder(gongsunsheng4);//测试插入重复号码
        //显示
        singleLinkedList.list();
    }
}

/**
 * 定义一个SingleLinkedList管理我们的英雄
 */
class SingleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    //添加节点到单向链表
    //思路：当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量来遍历temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null){
                break;
            }
            //如果没有找到.将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //思路：考虑排名的方式（如果有这个排名，则添加失败，并提示信息）
    public void addByOrder(HeroNode heroNode){
        //因为头节点不能动，因此我们通过一个辅助变量来遍历，找到指定的位置
        //因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在。默认不存在false
        while(true){
            if (temp.next == null){//说明temp已经在链表的最后
                break;
            }
            if(temp.next.no>heroNode.no){//位置找到就在temp的后边
                break;
            }else if(temp.next.no == heroNode.no){//说明期望添加的heroNode的编号也存在
                flag = true;//改变标记的状态，已存在
                break;
            }
            temp = temp.next;//后移，遍历当前链表
        }
        //判断flag的值
        if(flag){
            //不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在，插入失败\n",heroNode.no);
        }else {
            //插入到链表中,temp后边
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //显示链表[遍历]
    public void list(){
        //判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历temp
        HeroNode temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //如果没有找到.将temp后移
            temp = temp.next;
        }
    }
}

/**
 * 定义一个HeroNode，每个对象都是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    //构造器
    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}