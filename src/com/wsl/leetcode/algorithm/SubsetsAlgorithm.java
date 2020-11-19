package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 子集
 * 
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class SubsetsAlgorithm {

    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> temp = new ArrayList<>();

    /**
     * 可以使用递归算法或迭代算法
     * 
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        // dfs(0, nums);
        iterate(nums);
        return ans;
    }

    /**
     * 递归算法
     * 
     * @param cur
     * @param nums
     */
    private void dfs(int cur, int[] nums) {
        if (cur == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[cur]);
        dfs(cur + 1, nums);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, nums);
    }

    /**
     * 迭代算法：用0和1分别表示元素是否在子集，参考：https://leetcode-cn.com/problems/subsets/solution/zi-ji-by-leetcode-solution/
     * 
     * @param nums
     */
    private void iterate(int[] nums) {
        int n = nums.length;
        for (int mask = 0; mask < 1 << n; mask++) {
            temp.clear();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(nums[i]);
                }
            }
            ans.add(new ArrayList<>(temp));
        }
    }

    public static void main(String[] args) {
        SubsetsAlgorithm subsetsAlgorithm = new SubsetsAlgorithm();
        int[] nums = {1, 2, 3};
        System.out.println(subsetsAlgorithm.subsets(nums));
    }

}
