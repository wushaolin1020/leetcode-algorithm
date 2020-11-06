package com.wsl.leetcode.algorithm;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意: 你可以假设树中没有重复的元素。
 *
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalAlgorithm {

    /**
     * 没有思路参考官方答案：我们用一个栈和一个指针辅助进行二叉树的构造。初始时栈中存放了根节点（前序遍历的第一个节点），指针指向中序遍历的第一个节点；
     *
     * 我们依次枚举前序遍历中除了第一个节点以外的每个节点。如果 index 恰好指向栈顶节点，那么我们不断地弹出栈顶节点并向右移动 index，并将当前节点作为最后一个弹出的节点的右儿子；如果 index
     * 和栈顶节点不同，我们将当前节点作为栈顶节点的左儿子；
     *
     * 无论是哪一种情况，我们最后都将当前的节点入栈。
     *
     * 作者：LeetCode-Solution
     * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/solution/cong-qian-xu-yu-zhong-xu-bian-li-xu-lie-gou-zao-9/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);

        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                TreeNode left = new TreeNode(preorderVal);
                node.left = left;
                stack.push(left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                TreeNode right = new TreeNode(preorderVal);
                node.right = right;
                stack.push(right);
            }
        }

        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
        }

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        ConstructBinaryTreeFromPreorderAndInorderTraversalAlgorithm algorithm =
            new ConstructBinaryTreeFromPreorderAndInorderTraversalAlgorithm();
        System.out.println(algorithm.buildTree(preorder, inorder));
    }

}
