package com.wang.leetcode1_30;

public class T23_mergeKLists {
    /**
     * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
     * <p>
     * 示例:
     * <p>
     * 输入:
     * [
     *   1->4->5,
     *   1->3->4,
     *   2->6
     * ]
     * 输出: 1->1->2->3->4->4->5->6
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    protected static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode listNode = mergeLists(lists, 0, lists.length - 1);
        return listNode;
    }

    public static ListNode mergeLists(ListNode[] lists, int left, int right) {
        if (left > right)
            return null;
        else if (left == right) {
            return lists[right];
        } else if (right - left == 1) {
            return mergeTwoLists(lists[left],lists[right]);
        } else {
            int mid = (right - left) / 2+left;
            System.out.println(left+" "+mid+" "+right);
            return mergeTwoLists(mergeLists(lists, left, mid), mergeLists(lists, mid + 1, right));
        }

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode temp = new ListNode(0);
        ListNode result = temp;
        while (l1 != null && l2 != null) {
            if (l2.val < l1.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }
        while (l1 != null) {
            temp.next = l1;
            l1 = l1.next;
            temp = temp.next;
        }
        while (l2 != null) {
            temp.next = l2;
            l2 = l2.next;
            temp = temp.next;
        }
        return result.next;
    }

    public static void main(String[] args) {
        /**
         * [[-10,-9,-9,-3,-1,-1,0],
         * [-5]
         * ,[4]
         * ,[-8]
         * ,[]
         * ,[-9,-6,-5,-4,-2,2,3],
         * [-3,-3,-2,-1,0]]
         */
        ListNode l1 = new ListNode(-10);
        l1.next = new ListNode(-9);
        l1.next.next = new ListNode(-9);
        l1.next.next.next = new ListNode(-3);
        l1.next.next.next.next = new ListNode(-1);
        l1.next.next.next.next.next = new ListNode(-1);
        l1.next.next.next.next.next.next = new ListNode(0);
        ListNode l2 = new ListNode(-5);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(-8);
        ListNode l5 = null;
        ListNode l6 = new ListNode(-9);
        l6.next = new ListNode(-6);
        l6.next.next = new ListNode(-5);
        l6.next.next.next = new ListNode(-4);
        l6.next.next.next.next = new ListNode(-2);
        l6.next.next.next.next.next = new ListNode(2);
        l6.next.next.next.next.next.next = new ListNode(3);
        ListNode l7 = new ListNode(-3);
        l7.next = new ListNode(-3);
        l7.next.next = new ListNode(-2);
        l7.next.next.next = new ListNode(-1);
        l7.next.next.next.next = new ListNode(0);
        ListNode listNode = mergeKLists(new ListNode[]{l1,l2,l3,l4,l5,l6,l7});
        while (listNode != null) {
            System.out.print(listNode.val + "->");
            listNode = listNode.next;
        }
    }

}
