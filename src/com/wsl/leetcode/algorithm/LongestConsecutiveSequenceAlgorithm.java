package com.wsl.leetcode.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续序列
 *
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 *
 *
 * 示例 1：
 *
 * 输入：nums = [100,4,200,1,3,2]
 * 输出：4
 * 解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * 示例 2：
 *
 * 输入：nums = [0,3,7,2,5,8,4,6,0,1]
 * 输出：9
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-consecutive-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestConsecutiveSequenceAlgorithm {

    /**
     * 哈希表
     * 
     * @param nums
     * @return
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLongest = 0;

        for (int i = 0; i < nums.length; i++) {
            // 找到连续序列最小的数字开始计算序列长度
            if (!numSet.contains(nums[i] - 1)) {
                int currentLongest = 1;
                int currentNum = nums[i];

                while (numSet.contains(currentNum + 1)) {
                    currentLongest += 1;
                    currentNum += 1;
                }

                maxLongest = Math.max(maxLongest, currentLongest);
            }
        }
        return maxLongest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        LongestConsecutiveSequenceAlgorithm longestConsecutiveSequenceAlgorithm =
            new LongestConsecutiveSequenceAlgorithm();
        System.out.println(longestConsecutiveSequenceAlgorithm.longestConsecutive(nums));
    }

}
