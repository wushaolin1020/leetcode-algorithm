package com.wsl.leetcode.algorithm;

/**
 * 二叉树中的最大路径和
 *
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出：6
 * 示例2：
 *
 * 输入：[-10,9,20,null,null,15,7]
 *
 *   -10
 *  / \
 *  9 20
 *   / \
 *  15  7
 *
 * 输出：42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreeMaximumPathSumAlgorithm {

    private int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int curGain = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, curGain);

        return node.val + Math.max(leftGain, rightGain);
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
        TreeNode root = new TreeNode(2);

        TreeNode left = new TreeNode(-1);
        TreeNode right = new TreeNode(3);

        root.left = left;
        /*root.right = right;*/

        BinaryTreeMaximumPathSumAlgorithm binaryTreeMaximumPathSumAlgorithm = new BinaryTreeMaximumPathSumAlgorithm();
        System.out.println(binaryTreeMaximumPathSumAlgorithm.maxPathSum(root));
    }

}
