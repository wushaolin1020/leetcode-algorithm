package com.wsl.leetcode.algorithm;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明:叶子节点是指没有子节点的节点。
 *
 * 示例： 给定二叉树 [3,9,20,null,null,15,7]， 返回它的最大深度3 。
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-depth-of-binary-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximumDepthOfBinaryTreeAlgorithm {

    public int maxDepth(TreeNode root) {
        return depth(root, 0);
    }

    /**
     * 递归算法：分别递归遍历左右子树的最大深度，取两者的最大值
     * 
     * @param node
     * @param depth
     * @return
     */
    private int depth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int leftDepth = depth(node.left, depth + 1);

        int rightDepth = depth(node.right, depth + 1);

        return Math.max(leftDepth, rightDepth);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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

        MaximumDepthOfBinaryTreeAlgorithm maximumDepthOfBinaryTreeAlgorithm = new MaximumDepthOfBinaryTreeAlgorithm();
        System.out.println(maximumDepthOfBinaryTreeAlgorithm.maxDepth(root));
    }
}
