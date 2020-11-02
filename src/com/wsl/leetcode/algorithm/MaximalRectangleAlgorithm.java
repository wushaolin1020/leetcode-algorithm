package com.wsl.leetcode.algorithm;

import java.util.Arrays;

/**
 * 最大矩形
 *
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * 
 * 示例 1： 输入：matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']] 输出：6
 * 
 * 示例 2： 输入：matrix = [] 输出：0
 * 
 * 示例 3： 输入：matrix = [['0']] 输出：0
 * 
 * 示例 4： 输入：matrix = [['1']] 输出：1
 * 
 * 示例 5： 输入：matrix = [['0','0']] 输出：0
 *
 * 提示：
 *
 * rows == matrix.length cols == matrix.length 0 <= row, cols <= 200 matrix[i][j] 为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximal-rectangle 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalRectangleAlgorithm {

    /**
     * 核心思想：计算每一个点的高度以及左右位置
     * 
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    cur_left = j + 1;
                    left[j] = 0;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    cur_right = j - 1;
                    right[j] = n;
                }
            }

            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, height[j] * (right[j] - left[j]));
            }

        }
        return maxarea;
    }

    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}};
        MaximalRectangleAlgorithm maximalRectangleAlgorithm = new MaximalRectangleAlgorithm();
        System.out.println(maximalRectangleAlgorithm.maximalRectangle(matrix));
    }

}
