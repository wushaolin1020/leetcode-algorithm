package com.wsl.leetcode.algorithm;

import java.util.Stack;

/**
 * 柱状图中最大的矩形
 *
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例:
 *
 * 输入: [2,1,5,6,2,3] 输出: 10
 *
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleAreaAlgorithm {

    /**
     * 核心思想：针对每一个柱子的高度，分别计算左边与右边小于该柱子的高度的下标，然后遍历数组计算最大值
     * 
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        LargestRectangleAreaAlgorithm largestRectangleAreaAlgorithm = new LargestRectangleAreaAlgorithm();
        System.out.println(largestRectangleAreaAlgorithm.largestRectangleArea(heights));
    }

}
