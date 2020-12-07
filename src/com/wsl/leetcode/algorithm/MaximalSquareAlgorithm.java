package com.wsl.leetcode.algorithm;

/**
 * 最大正方形
 *
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximal-square
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaximalSquareAlgorithm {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
           return maxSide;
        }

        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    // dp(i, j)的值由其上方、左方和左上方的三个相邻位置的dp值决定,dp(i,j)=min(dp(i−1,j),dp(i−1,j−1),dp(i,j−1))+1
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }

}
