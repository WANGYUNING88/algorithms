package com.wang.datastructure.java.listedlist;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试~~");
        HeroNode2 songjiang1 = new HeroNode2(1, "宋江", "及时雨（呼保义）");
        HeroNode2 lujunyi2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 wuyong3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 gongsunsheng4 = new HeroNode2(4, "公孙胜", "入云龙");
        HeroNode2 wangyuning = new HeroNode2(5, "王余柠", "测试");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //添加测试
        doubleLinkedList.add(songjiang1);
        doubleLinkedList.add(lujunyi2);
       // doubleLinkedList.add(wuyong3);
        doubleLinkedList.add(gongsunsheng4);

        //修改
        //doubleLinkedList.add(wangyuning);
       // doubleLinkedList.list();
       // HeroNode2 wangyuning1 = new HeroNode2(1, "王余柠", "测试");
       // doubleLinkedList.update(wangyuning1);

        //删除
       // doubleLinkedList.delete(105);

        //按编号添加
        //doubleLinkedList.addByOrder(wangyuning);

        //显示打印
        doubleLinkedList.list();

        doubleLinkedList.addByOrder(wuyong3);
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //先初始化一个头节点，头节点不要动，不存放具体的数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回的头节点
    public HeroNode2 getHead() {
        return head;
    }

    //添加一个节点到双向链表
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助变量来遍历temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {
                break;
            }
            //如果没有找到.将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后的这个节点的next 指向 新的节点,新的节点的pre 指向 这个节点
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void addByOrder(HeroNode2 heroNode){
        //因为头节点不能动，因此我们通过一个辅助变量来遍历，找到指定的位置
        //因为单链表，因此我们找的temp，是位于添加位置的前一个节点，否则插入不了
        HeroNode2 temp = head;
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
            if(temp.next!=null)
                temp.next.pre = heroNode;
            temp.next = heroNode;
            heroNode.pre = temp;
        }
    }

    //修改节点信息，根据编号来修改
    //和单链表修改的过程一样
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//已经遍历完了
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号为 %d 为的节点，无法修改\n", newHeroNode.no);
        }
    }

    //删除一个节点
    //思路：对于双向链表直接删除这个节点
    public void delete(int no) {
        //判断是否为空
        if (head.next == null) {
            //为空链表
            System.out.println("链表为空，删除失败~~");
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;//是否找到待删除的节点
        while (true) {
            if (temp == null) {
                break;//到最后了
            }
            if (temp.no == no) {//找到了待删除的节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //判断结果
        if (flag) {
            //temp.next = temp.next.next;单项链表的删除思路
            temp.pre.next = temp.next;
            if (temp.next != null)
                temp.next.pre = temp;//如果是最后一个会空指针异常，可以不执行这句话
        } else {
            System.out.printf("没有找到编号为 %d 为的节点，无法删除\n", no);
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，因此我们需要一个辅助变量来遍历temp
        HeroNode2 temp = head.next;
        while (true) {
            //判断是否到链表的最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //如果没有找到.将temp后移
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每个对象都是一个节点
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;//指向下一个
    public HeroNode2 pre;//指向上一个

    //构造器
    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
