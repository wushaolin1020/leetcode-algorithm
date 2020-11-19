package com.wsl.leetcode.algorithm;

import java.util.Stack;

/**
 * 二叉树展开为链表
 *
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FlattenBinaryTreeToLinkedListAlgorithm {

    /**
     * 借助栈的后入先出的原则进行遍历
     * 
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();

            if (pre != null) {
                pre.left = null;
                pre.right = cur;
            }

            TreeNode right = cur.right;
            if (right != null) {
                stack.push(right);
            }

            TreeNode left = cur.left;
            if (left != null) {
                stack.push(left);
            }

            pre = cur;

        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);

        root.left = left;
        root.right = right;

        TreeNode left_left = new TreeNode(3);
        TreeNode left_right = new TreeNode(4);

        left.left = left_left;
        left.right = left_right;

        TreeNode right_right = new TreeNode(6);

        right.right = right_right;

        FlattenBinaryTreeToLinkedListAlgorithm algorithm = new FlattenBinaryTreeToLinkedListAlgorithm();
        algorithm.flatten(root);

        System.out.println(root);
    }
}
