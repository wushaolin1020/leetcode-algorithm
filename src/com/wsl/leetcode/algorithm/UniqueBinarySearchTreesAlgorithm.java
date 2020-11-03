package com.wsl.leetcode.algorithm;

/**
 * 不同的二叉搜索树
 * 
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜索树
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/unique-binary-search-trees 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class UniqueBinarySearchTreesAlgorithm {

    /**
     * 由于1,2...n这个数列是递增的，所以我们从任意一个位置“提起”这课树，都满足二叉搜索树的这个条件：左边儿子数小于爸爸数，右边儿子数大于爸爸数
     *
     * 从1,2,...n数列构建搜索树，实际上只是一个不断细分的过程 例如，我要用[1,2,3,4,5,6]构建 首先，提起"2"作为树根，[1]为左子树，[3,4,5,6]为右子树
     *
     * 现在就变成了一个更小的问题：如何用[3,4,5,6]构建搜索树？ 比如，我们可以提起"5"作为树根，[3,4]是左子树，[6]是右子树
     *
     * 现在就变成了一个更更小的问题：如何用[3,4]构建搜索树？ 那么这里就可以提起“3”作为树根，[4]是右子树 或"4"作为树根，[3]是左子树
     *
     * 可见n=6时的问题是可以不断拆分成更小的问题的
     *
     * 假设f(n) = 我们有n个数字时可以构建几种搜索树 我们可以很容易得知几个简单情况 f(0) = 1, f(1) = 1, f(2) = 2
     * (注：这里的f(0)可以理解为=1也可以理解为=0，这个不重要，我们这里理解为=1,即没有数字时只有一种情况，就是空的情况）
     *
     * 那n=3时呢？ 我们来看[1,2,3] 如果提起1作为树根，左边有f(0)种情况，右边f(2)种情况，左右搭配一共有f(0)*f(2)种情况
     * 如果提起2作为树根，左边有f(1)种情况，右边f(1)种情况，左右搭配一共有f(1)*f(1)种情况 如果提起3作为树根，左边有f(2)种情况，右边f(0)种情况，左右搭配一共有f(2)*f(0)种情况 容易得知f(3) =
     * f(0)*f(2) + f(1)*f(1) + f(2)*f(0)
     *
     * 同理, f(4) = f(0)*f(3) + f(1)*f(2) + f(2)*f(1) + f(3)*f(0) f(5) = f(0)*f(4) + f(1)*f(3) + f(2)*f(2) + f(3)*f(1) +
     * f(4)*f(0)
     *
     * 作者：xiao-yan-gou
     * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees/solution/er-cha-sou-suo-shu-fu-xi-li-zi-jie-shi-si-lu-by-xi/
     * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * 
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesAlgorithm uniqueBinarySearchTreesAlgorithm = new UniqueBinarySearchTreesAlgorithm();
        System.out.println(uniqueBinarySearchTreesAlgorithm.numTrees(3));
    }

}
