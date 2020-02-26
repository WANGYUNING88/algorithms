package com.wang.classic;

public class Josepfu {
    public static void main(String[] args) {
        //测试
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(25);//加入5个boy
        //显示小孩
        circleSingleLinkedList.showBoy();
        //测试出圈的方法
        circleSingleLinkedList.conuntBoy(1,2,25);
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

    /**
     * 根据用户的输出，计算出圈的顺序
     * @param startNo 从第几个开始报数
     * @param countNum 出列的数
     * @param nums 表示多少小孩
     */
    public void conuntBoy (int startNo,int countNum,int nums){
        if(first ==null||startNo<1||startNo>nums){
            //检验数据
            System.out.printf("数据非法~~");
        }
        //创建辅助指针
        Boy helper = first;
        //先让first指向第一个报数的boy
        for (int i =0;i<startNo-1;i++){
            first = first.getNext();
        }
        //让helper指向firstboy前一个
        while (true){
            if (helper.getNext()==first){
                break;
            }
            helper = helper.getNext();
        }
        //当小孩报数时，让first 和 helper 指针同时移动 count-1 次，然后出圈
        //这里时一个循环，知道圈中只有一个节点
        while (true){
            if (helper==first){//说明圈中只有一个节点
                break;
            }
            //让first 和 helper 指针同时移动 countNum-1 次
            for (int i = 0;i<countNum-1;i++){
                first = first.getNext();
                helper = helper.getNext();
            }
            //此时first指向的节点，就是小孩要出圈的节点
            System.out.printf("编号为 %d 的小孩出列了\n",first.getNo());
            //helper->first->first.next  =>  helper->first.next 这样first就出列了
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.printf("编号为 %d 的小孩出列了\n",first.getNo());
        System.out.println("全部出列了");
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
