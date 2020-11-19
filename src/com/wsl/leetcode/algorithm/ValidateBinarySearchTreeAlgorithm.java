package com.wsl.leetcode.algorithm;

/**
 * 验证二叉搜索树
 * 
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:
 *
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 * 示例 2:
 *
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *      根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidateBinarySearchTreeAlgorithm {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    /**
     * 递归算法
     * 
     * 如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树
     * 
     * @param node
     * @param lower
     * @param upper
     * @return
     */
    private boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }

        int val = node.val;

        // 当前节点的值与最小值对比
        if (lower != null && lower >= val) {
            return false;
        }

        // 当前节点的值与最大值对比
        if (upper != null && upper <= val) {
            return false;
        }

        // 遍历左边
        if (!helper(node.left, lower, val)) {
            return false;
        }

        // 遍历右边
        if (!helper(node.right, val, upper)) {
            return false;
        }

        return true;
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
        TreeNode leftNode = new TreeNode(1);
        TreeNode rightNode = new TreeNode(3);
        TreeNode rootNode = new TreeNode(2);

        rootNode.left = leftNode;
        rootNode.right = rightNode;

        ValidateBinarySearchTreeAlgorithm validateBinarySearchTreeAlgorithm = new ValidateBinarySearchTreeAlgorithm();
        System.out.println(validateBinarySearchTreeAlgorithm.isValidBST(rootNode));
    }

}
