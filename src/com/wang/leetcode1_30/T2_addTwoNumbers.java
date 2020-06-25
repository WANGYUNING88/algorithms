package com.wang.leetcode1_30;

public class T2_addTwoNumbers {
    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode result = new ListNode(0);
        ListNode pointer = result;

        int sum = 0;
        int carry = 0;
        int val = 0;
        while (pointer1 != null && pointer2 != null) {
            sum = pointer1.val + pointer2.val + carry;
            carry = sum / 10;
            val = sum % 10;
            pointer.next = new ListNode(val);
            pointer = pointer.next;
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        while (pointer1 != null){
            sum = pointer1.val + carry;
            carry = sum / 10;
            val = sum % 10;
            pointer.next = new ListNode(val);
            pointer = pointer.next;
            pointer1 = pointer1.next;
        }
        while (pointer2 != null){
            sum = pointer2.val + carry;
            carry = sum / 10;
            val = sum % 10;
            pointer.next = new ListNode(val);
            pointer = pointer.next;
            pointer2 = pointer2.next;
        }
        if (carry==1){
            pointer.next = new ListNode(carry);
        }
        return result.next;
    }
}
