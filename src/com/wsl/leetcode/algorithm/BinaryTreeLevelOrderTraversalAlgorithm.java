package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * <p>
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * 示例： 二叉树：[3,9,20,null,null,15,7], 返回其层次遍历结果： [ [3], [9,20], [15,7] ]
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeLevelOrderTraversalAlgorithm {

    /**
     * 广度优先搜索
     * 
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();

        if (root == null) {
            return results;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> curLevel = new ArrayList<>();

            int curLevelSize = queue.size();
            for (int i = 1; i <= curLevelSize; i++) {
                TreeNode node = queue.poll();
                curLevel.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            results.add(curLevel);
        }

        return results;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

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
        TreeNode right = new TreeNode(2);

        root.left = left;
        root.right = right;

        TreeNode left_left = new TreeNode(3);
        TreeNode left_right = new TreeNode(4);

        left.left = left_left;
        left.right = left_right;

        TreeNode right_left = new TreeNode(4);
        TreeNode right_right = new TreeNode(3);

        right.left = right_left;
        right.right = right_right;

        BinaryTreeLevelOrderTraversalAlgorithm binaryTreeLevelOrderTraversalAlgorithm =
            new BinaryTreeLevelOrderTraversalAlgorithm();
        System.out.println(binaryTreeLevelOrderTraversalAlgorithm.levelOrder(root));
    }

}
