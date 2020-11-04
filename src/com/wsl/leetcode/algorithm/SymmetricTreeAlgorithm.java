package com.wsl.leetcode.algorithm;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称二叉树
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 * 例如，二叉树[1,2,2,3,4,4,3] 是对称的。
 *
 * 但是下面这个[1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/symmetric-tree 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SymmetricTreeAlgorithm {

    public boolean isSymmetric(TreeNode root) {
        // return check(root, root);
        return checkByIterate(root, root);
    }

    /**
     * 递归算法:转化为两个镜像数对比
     * 
     * @param node1
     * @param node2
     * @return
     */
    private boolean check(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }

        if (node1 == null || node2 == null) {
            return false;
        }

        return (node1.val == node2.val) && check(node1.left, node2.right) && check(node1.right, node2.left);
    }

    /**
     * 迭代算法
     * 
     * @param node1
     * @param node2
     * @return
     */
    private boolean checkByIterate(TreeNode node1, TreeNode node2) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(node1);
        queue.offer(node2);

        while (!queue.isEmpty()) {
            node1 = queue.poll();
            node2 = queue.poll();

            if (node1 == null && node2 == null) {
                continue;
            }

            if ((node1 == null || node2 == null) || (node1.val != node2.val)) {
                return false;
            }

            queue.offer(node1.left);
            queue.offer(node2.right);

            queue.offer(node1.right);
            queue.offer(node2.left);
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

        SymmetricTreeAlgorithm symmetricTreeAlgorithm = new SymmetricTreeAlgorithm();
        System.out.println(symmetricTreeAlgorithm.isSymmetric(root));
    }
}
