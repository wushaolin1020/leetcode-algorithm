package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 *
 * 给定一个二叉树的根节点 root ，返回它的 中序遍历。
 *
 *
 * 示例 1：
 *
 *
 * 输入：root = [1,null,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 *
 *
 * 输入：root = [1,2]
 * 输出：[2,1]
 * 示例 5：
 *
 *
 * 输入：root = [1,null,2]
 * 输出：[1,2]
 * 
 *
 * 提示：
 *
 * 树中节点数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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

        traversal(leftNode);

        resultList.add(node.val);

        traversal(rightNode);

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
