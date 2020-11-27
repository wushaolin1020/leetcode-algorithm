package com.wsl.leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 课程表
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 *
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 *
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 2, [[1,0]] 
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 *
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CourseScheduleAlgorithm {
	
	/**
	 * 课程的学习顺序
	 */
	private List<List<Integer>> courseList;
	/**
	 * 每个课程的遍历结果
	 */
	int[] visit;
	/**
	 * 是否验证通过
	 */
	boolean valid = true;
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        courseList = new ArrayList<>();
	
        for (int i = 0; i < numCourses; i++) {
            courseList.add(new ArrayList<>());
        }
		
        // 用List表示课程的学习顺序
        for (int[] prerequisite : prerequisites) {
	        courseList.get(prerequisite[1]).add(prerequisite[0]);
        }
        
        visit = new int[numCourses];
        
        for (int i = 0; i < numCourses && valid; i++) {
        	dfs(i);
        }
        return valid;
	}
	
	/**
	 * 深度遍历
	 * @param u
	 */
	private void dfs(int u) {
		// 0：未搜索，1：搜索中，2：已完成
		visit[u] = 1;
		
		for (int v : courseList.get(u)) {
			if (visit[v] == 0) {
				dfs(v);
				if (!valid) {
					return;
				}
			}else if (visit[v] == 1) {
				valid = false;
				return;
			}
		}
		
		visit[u] = 2;
	}
	
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = {
			{0,1}
		};
		CourseScheduleAlgorithm algorithm = new CourseScheduleAlgorithm();
		System.out.println(algorithm.canFinish(numCourses, prerequisites));
	}
	
}
