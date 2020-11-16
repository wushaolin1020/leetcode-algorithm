package com.wsl.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表 II
 *
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 说明：不允许修改给定的链表。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/linked-list-cycle-ii 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LinkedListCycleIIAlgorithm {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        head.next = node1;
        ListNode node2 = new ListNode(0);
        node1.next = node2;
        ListNode node3 = new ListNode(-4);
        node2.next = node3;
        node3.next = node1;
        LinkedListCycleIIAlgorithm linkedListCycleIIAlgorithm = new LinkedListCycleIIAlgorithm();
        System.out.println(linkedListCycleIIAlgorithm.detectCycle(head));

    }

}
