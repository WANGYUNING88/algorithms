package com.wang.leetcode1_30;

import java.util.Stack;

public class T25_reverseKGroup {

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     *
     * k 是一个正整数，它的值小于或等于链表的长度。
     *
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     *
     *  
     *
     * 示例：
     *
     * 给你这个链表：1->2->3->4->5
     *
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     *
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     *  
     *
     * 说明：
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param head
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        if (k==1||head==null)
            return head;
        return getKListNode(head,k-1);
    }

    public static ListNode getKListNode(ListNode head,int k){
        ListNode start=head,res=null;
        ListNode pre=null;
        while (true){
            int index;
            ListNode end=start;
            for (index=0;index<k;++index){
                if (end==null)
                    break;
                end=end.next;
            }
            if (index!=k||end==null)
                break;
            ListNode node=end.next;
            end.next=null;
            reverse(start);
            if (pre!=null){
                pre.next=end;
            }else {
                res=end;
            }
            pre=start;
            start=node;
        }
        if (pre!=null)
            pre.next=start;
        return res;
    }

    public static ListNode reverse(ListNode head){
        ListNode pre=head,next=pre.next;
        while (next!=null){
            ListNode tmp=next.next;
            next.next=pre;
            pre=next;
            next=tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(5);
        ListNode reverse = reverseKGroup(r,3);
        while (reverse!=null){
            System.out.print(reverse.val+"->");
            reverse = reverse.next;
        }
    }

}
