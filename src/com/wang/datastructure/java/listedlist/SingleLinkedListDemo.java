package com.wang.datastructure.java.listedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode songjiang1 = new HeroNode(1, "宋江", "及时雨（呼保义）");
        HeroNode lujunyi2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode wuyong3 = new HeroNode(3, "吴用", "智多星");
        HeroNode gongsunsheng4 = new HeroNode(4, "公孙胜", "入云龙");
        HeroNode wangyuning = new HeroNode(109, "王余柠", "测试");

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
//        singleLinkedList.addByOrder(gongsunsheng4);//测试插入重复号码
        singleLinkedList.addByOrder(wangyuning);//测试修改的数据
//        //显示
//        singleLinkedList.list();
//        System.out.println("***************");
//        HeroNode newwangyuning1 = new HeroNode(109, "wangyuning", "ceshi");//修改成功的案例
//        HeroNode newwangyuning2 = new HeroNode(109, "wangyuning", "ceshi");//修改失败的案例
//        singleLinkedList.update(newwangyuning1);

        //删除
        singleLinkedList.delete(109);
        singleLinkedList.delete(108);

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

    //修改节点信息，根据编号来修改
    public void update(HeroNode newHeroNode){
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head.next;
        boolean flag = false;
        while(true){
            if(temp == null){
                break;//已经遍历完了
            }
            if (temp.no == newHeroNode.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到
        if (flag){
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        }else {
            System.out.printf("没有找到编号为 %d 为的节点，无法修改\n",newHeroNode.no);
        }
    }

    //删除节点
    //思路：我们需要找出要删除的节点的前一个节点，
    public void delete(int no){
        HeroNode temp = head;
        boolean flag = false;//是否找到待删除的节点
        while (true){
            if (temp.next == null) {
                break;//到最后了
            }
            if (temp.next.no == no) {//找到了待删除的节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断结果
        if (flag){
            temp.next = temp.next.next;
        }else {
            System.out.printf("没有找到编号为 %d 为的节点，无法删除\n",no);
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