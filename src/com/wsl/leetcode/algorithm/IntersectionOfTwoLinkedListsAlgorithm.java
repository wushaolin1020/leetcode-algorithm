package com.wsl.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntersectionOfTwoLinkedListsAlgorithm {

    /**
     * 双指针同时遍历链表A+链表B，找到交点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB){
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }

    public static void main(String[] args) {
        ListNode headA = new ListNode(8);
        ListNode headB = new ListNode(4);
        ListNode headB1 = new ListNode(1);
        ListNode headB2 = new ListNode(8);
        ListNode headB3 = new ListNode(4);
        ListNode headB4 = new ListNode(5);
        headB.next = headB1;
        headB1.next = headB2;
        headB2.next = headB3;
        headB3.next = headB4;

        IntersectionOfTwoLinkedListsAlgorithm algorithm = new IntersectionOfTwoLinkedListsAlgorithm();
        System.out.println(algorithm.getIntersectionNode(headA, headB));
    }
}
