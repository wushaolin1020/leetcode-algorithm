package com.wsl.leetcode.algorithm;

import org.bouncycastle.LICENSE;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 反转链表
 *
 * 反转一个单链表。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinkedList {
	
    public ListNode reverseList(ListNode head) {
	    ListNode pre = null;
	    ListNode curr = head;
	    while (curr != null) {
	    	ListNode nextTemp = curr.next;
	    	curr.next = pre;
	    	pre = curr;
	    	curr = nextTemp;
	    }
	    return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
	
	    @Override
	    public String toString() {
		    return "ListNode{" +
			    "val=" + val +
			    ", next=" + next +
			    '}';
	    }
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode node3 = new ListNode(4);
		ListNode node4 = new ListNode(5);
		head.next = node1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		
		ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
		System.out.println(reverseLinkedList.reverseList(head));
	}
  
}
