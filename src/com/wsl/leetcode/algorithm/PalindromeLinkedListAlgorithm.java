package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 回文链表
 *
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeLinkedListAlgorithm {

    /**
     * 首指针
     */
    private ListNode front;

    /**
     * 遍历链表放入数组，再用双指针对比
     *
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
//        front = head;
//        return recursivelyCheck(head);

        List<Integer> vals = new ArrayList<>();

        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }

        int front = 0;
        int back = vals.size() - 1;

        while (front < back) {
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    /**
     * 递归检查,首尾两个指针对比
     *
     * @param cur
     * @return
     */
    private boolean recursivelyCheck(ListNode cur) {
        if (cur != null) {
            if (!recursivelyCheck(cur.next)) {
                return false;
            }
            if (cur.val != front.val) {
                return false;
            }

            front = front.next;
        }

        return true;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
