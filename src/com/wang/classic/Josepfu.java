package com.wang.classic;

public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(50);//加入5个boy
        //显示小孩
        circleSingleLinkedList.showBoy();
    }
}

//创建一个环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点，没有编号
    private Boy first = null;
    //添加小孩，构建成一个环形的链表
    //@nums 加几个小孩
    public void addBoy(int nums){
        //nums 做一个数据校验
        if(nums<1){
            System.out.println("数据不合法");
            return;
        }
        //辅助变量（指针)
        Boy curBoy = null;
        //使用for循环创建环形链表
        for(int i = 1;i<=nums;i++){
            Boy boy = new Boy(i);
            //如何是第一个小孩
            if(i==1){
                first = boy;
                first.setNext(first);//构建环
                curBoy = first;//让curBoy指向第一个小孩
            }else {
                curBoy.setNext(boy);//将新的boy加入到游标后边
                boy.setNext(first);//新的boy的next 指向first
                curBoy = boy; //将游标后移到boy
            }
        }
    }

    //遍历环形链表
    public void showBoy(){
        if (first==null){
            //判断是否空
            System.out.println("没有小孩~~");
            return;
        }
        //辅助变量（指针)
        Boy curBoy = first;
        while (true){
            System.out.printf("小孩的编号 %d \n",curBoy.getNo());
            if(curBoy.getNext()==first){//说明遍历到最后一个节点了
                break;
            }
            curBoy = curBoy.getNext();
        }
    }
}

//创建一个boy类
class Boy {
    private int no;//编号
    private Boy next;//下一个小孩

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
