package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树，返回它的中序遍历。
 * 
 * 前序遍历： 访问根节点->前序遍历左子树->前序遍历右子树
 * 
 * 中序遍历：中序遍历左子树->访问根节点->中序遍历右子树
 * 
 * 后序遍历：后序遍历左子树->后序遍历右子树->访问根节点
 *
 * 示例:
 *
 * 输入: [1,null,2,3]
 * 
 * 1
 * 
 * \
 * 
 * 2
 * 
 * /
 * 
 * 3
 *
 * 输出: [1,3,2]
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class BinaryTreeInorderTraversaAlgorithm {

    private List<Integer> resultList = new ArrayList<>();

    /**
     * 二叉树中序遍历，先遍历左子树，然后当前节点，再遍历右字数
     * 
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        traversal(root);
        return resultList;
    }

    /**
     * 运用递归遍历
     * 
     * @param node
     */
    private void traversal(TreeNode node) {
        if (node == null) {
            return;
        }

        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;

        if (leftNode != null) {
            traversal(leftNode);
        }

        resultList.add(node.val);

        if (rightNode != null) {
            traversal(rightNode);
        }

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

        TreeNode node2 = new TreeNode(3);

        TreeNode node1 = new TreeNode(2, node2, null);

        TreeNode root = new TreeNode(1, null, node1);

        BinaryTreeInorderTraversaAlgorithm binaryTreeInorderTraversaAlgorithm =
            new BinaryTreeInorderTraversaAlgorithm();
        System.out.println(binaryTreeInorderTraversaAlgorithm.inorderTraversal(root));
    }

}
