package com.wang.leetcode;

public class T19_removeNthFromEnd {
    /**
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * 示例：
     *
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     *
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     *
     * 给定的 n 保证是有效的。
     *
     * 进阶：
     *
     * 你能尝试使用一趟扫描实现吗？
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (n<1){
            return head;
        }
        ListNode left = new ListNode(0);
        left.next = head;
        ListNode result = left;
        ListNode right = head;
        while (n>1&&right!=null){
            right = right.next;
            n--;
        }
        if (n!=1){
            return head;
        }
        while (right.next!=null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return result.next;
    }

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode r = new ListNode(1);
        r.next = new ListNode(2);
        r.next.next = new ListNode(3);
        r.next.next.next = new ListNode(4);
        r.next.next.next.next = new ListNode(5);
        ListNode listNode = removeNthFromEnd(r,1);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}


