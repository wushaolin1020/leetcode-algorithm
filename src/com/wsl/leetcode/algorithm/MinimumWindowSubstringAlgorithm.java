package com.wsl.leetcode.algorithm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 最小覆盖子串
 * 
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 
 * 示例：
 * 
 * 输入：S = "ADOBECODEBANC", T = "ABC" 输出："BANC"
 * 
 * 提示：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/minimum-window-substring/
 */
public class MinimumWindowSubstringAlgorithm {

    Map<Character, Integer> ori = new HashMap<>();

    Map<Character, Integer> cnt = new HashMap<>();

    /**
     * 滑动窗口（该题没有解题思路，参考官网的答案，实现的原理暂时未能理解）
     * 参考：https://leetcode-cn.com/problems/minimum-window-substring/solution/zui-xiao-fu-gai-zi-chuan-by-leetcode-solution
     * 
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            ori.put(t.charAt(i), ori.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        int sLen = s.length();
        while (r < sLen) {
            ++r;
            if (r < sLen && ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    private boolean check() {
        Iterator iterator = ori.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            Character key = (Character)entry.getKey();
            Integer value = (Integer)entry.getValue();
            if (cnt.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstringAlgorithm minimumWindowSubstringAlgorithm = new MinimumWindowSubstringAlgorithm();
        System.out.println(minimumWindowSubstringAlgorithm.minWindow("ADOBECODEBANC", "ABC"));
    }

}
