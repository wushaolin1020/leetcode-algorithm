package com.wsl.leetcode.algorithm;

import java.util.Arrays;

/**
 * 颜色分类
 * 
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 *
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 *
 * 进阶：
 *
 * 你可以不使用代码库中的排序函数来解决这道题吗？
 * 你能想出一个仅使用常数空间的一趟扫描算法吗？
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * 示例 2：
 *
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[0]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *  
 *
 * 提示：
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] 为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-colors
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortColorsAlgorithm {

    /**
     * 定义三个指针（头部指针、当前指针、尾部指针）从左往右一次遍历，通过判断当前指针对应的值来决定指针的移动方向：
     * 
     * 当前值等于0时，需要与头部指针交换对应的值，交换完成后头部指针与当前指针右移一位；
     * 
     * 当前值等于2时，需要与尾部指针交互对应的值，交换完成后尾部指针左移一位。当前指针不能移动，因为交换后的值可能还是2，需要再次判断；
     * 
     * 当前值等于1时，已经在中间位置，不需要与首尾指针交换对应的值，当前指针右移一位即可。
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        // 头指针与当前指针初始化为0
        int head = 0, curr = 0;
        // 尾部指针初始为数组的最大值
        int tail = nums.length - 1;
        // 临时变量，用于指针交换值
        int tmp;
        while (curr <= tail) {
            if (nums[curr] == 0) {
                tmp = nums[curr];
                nums[curr++] = nums[head];
                nums[head++] = tmp;
            } else if (nums[curr] == 2) {
                tmp = nums[curr];
                nums[curr] = nums[tail];
                nums[tail--] = tmp;
            } else {
                curr++;
            }
        }
    }

    public static void main(String[] args) {
        SortColorsAlgorithm sortColorsAlgorithm = new SortColorsAlgorithm();
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColorsAlgorithm.sortColors(nums);
        System.out.println(Arrays.toString(nums));;
    }

}
