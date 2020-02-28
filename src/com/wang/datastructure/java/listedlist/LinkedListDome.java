package com.wang.datastructure.java.listedlist;

import java.util.Stack;

/**
 *
 */
public class LinkedListDome {

    public static void main(String[] args) {
        //初始化链表0->1->2->3->4->5  0是头节点；
        int[] ints = new int[3];
        ints[0] = 1;
        ints[1] = 2;
        ints[2] = 3;
        LinkedList linkedList = LinkedList.init(ints);
        LinkedList linkedList1 = new LinkedList(0);
        LinkedList linkedList2 = new LinkedList(1);
        LinkedList linkedList3 = new LinkedList(3);
        LinkedList linkedList4 = new LinkedList(4);
        linkedList1.next = linkedList2;
        linkedList2.next = linkedList3;
        linkedList3.next = linkedList4;
        //获取有效的节点个数
//        System.out.printf("有效的节点个数是 %d \n",LinkedList.getlength(linkedList));
        //获取倒数第k个节点
//        int k = 5;
//        System.out.printf("倒数第 %d 个节点的data值是 %d \n",k,LinkedList.getTheLastKNode(linkedList,k).data);
        //反转链表
//        LinkedList.reverseList(linkedList);
        //逆序打印
//        LinkedList.reversePrint(linkedList);
        //合并链表
        LinkedList linkedList0 = LinkedList.mergeListNodes(linkedList, linkedList1);
        //输出
        System.out.println("linkedList2的顺序打印");
        LinkedList.list(linkedList0);
    }

}

class LinkedList{
    public int data;
    public LinkedList next;

    public LinkedList(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "data=" + data +
                '}';
    }

    /**
     * 创建一个链表
     * @return
     */
    public static LinkedList init(int[] datas){
        LinkedList temp = new LinkedList(0);
        LinkedList linkedList = temp;
        for(int i : datas){
            temp.next = new LinkedList(i);
            temp = temp.next;
        }
        return linkedList;
    }

    /**
     * 获取单链表的有效的节点个数（如果是带头节点的链表，则不统计头节点）
     * @param head 链表的头节点
     * @return
     */
    public static int getlength(LinkedList head){
        if(head.next==null){
            //是空链表
            return 0;
        }
        int length = 0;
        //定义一个辅助变量，来遍历链表
        LinkedList temp = head.next;
        while (temp!=null){
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 顺序打印单链表
     * @param head
     */
    public static void list(LinkedList head){
        if(head.next==null){
            System.out.println("链表为空~~");
            return;
        }
        LinkedList temp = head.next;
        int i= 1;
        while (temp!=null){
            System.out.println(temp);
            temp = temp.next;
        }
    }

    /**
     * 获取倒数第k个节点
     * 思路：
     * 1.先把链表从头到尾遍历得到这个链表的总的长度getlength
     * 2.得到size后，可以从链表的第一个开始，遍历到size-index个，就可以得到
     * @param head,k
     * @return
     */
    public static LinkedList getTheLastKNode(LinkedList head,int k){
        //判断是否为空
        if (head.next==null){
            return null;
        }
        int size = getlength(head);//获取总节点数
        if(k<=0||k>size){//k是否有效
            return null;
        }
        LinkedList temp = head.next;//辅助变量
        int index = 0;
        while (index<size-k){
            index++;
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 将单链表进行反转
     * @param head
     */
    public static void reverseList(LinkedList head) {
        //如何当前链表为空或只有一个链表,无需反转直接返回
        if (head.next==null||head.next.next==null){
            return ;
        }
        //定义个辅助的变量（指针），来遍历
        LinkedList temp = head.next;
        //记录当前节点(temp)的下一个
        LinkedList next = null;
        LinkedList reverseHead = new LinkedList(0);
        //遍历原来的链表
        //没遍历一个节点，就放到新的链表中
        while (temp!=null){
            next = temp.next;//先暂时保存当前节点的下一个节点
            temp.next = reverseHead.next;//将temp的下一个节点指向新的链表的头部
            reverseHead.next = temp;
            temp = next;//让temp后移
        }
        //将head.next指向reverseHead.next，实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 逆序打印单链表（不改变原链表的结构）
     * 思路：顺序遍历链表，获取节点数据保存到 栈（先入后出） 中，输出
     * @param head
     */
    public static void reversePrint(LinkedList head){
        if (head.next==null){
            return;//空链表，不能打印
        }
        //创建一个栈，入栈
        Stack<LinkedList> stack = new Stack<>();
        LinkedList temp = head.next;
        //将链表的所有的节点压入栈中
        while (temp!=null){
            stack.push(temp);
            temp = temp.next;
        }
        //将栈中的节点打印pop出栈
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表(有序）
     * @param head1
     * @param head2
     * @return
     */
    public static LinkedList mergeListNodes(LinkedList head1,LinkedList head2){
        if(head1.next==null){
            return head2;
        }
        if (head2.next==null){
            return head1;
        }
        LinkedList temp1 = head1.next;
        LinkedList temp2 = head2.next;
        LinkedList temp = new LinkedList(0);
        LinkedList merge = temp;
        while (temp1!=null&&temp2!=null){
            if(temp1.data<temp2.data){
                temp.next = temp1;
                temp1 = temp1.next;
            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        temp = temp1==null?temp2:temp1;
        return merge;
    }
}
