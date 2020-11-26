package com.wsl.leetcode.algorithm;

/**
 * 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 *  
 *
 * 提示：
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOfIslandsAlgorithm {
	
	/**
	 * 横向与纵向相邻的值为1的单元格属于同一个岛屿，用深度优先搜索算法
	 * @param grid
	 * @return
	 */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int islandsNum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    islandsNum++;
                    // 把属于当前岛屿的单元格的值改为0
                    dfs(grid,i,j);
                }
            }
        }
        
        return islandsNum;
    }
	
	/**
	 * 深度优先搜索，属于当前岛屿范围的数字改为0
	 * @param grid
	 * @param row
	 * @param column
	 */
	private void dfs(char[][] grid, int row, int column) {
    	if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length || grid[row][column] == '0') {
    		return;
	    }
    	grid[row][column] = '0';
    	dfs(grid, row-1, column );
    	dfs(grid, row+1, column);
    	dfs(grid,row,column-1);
    	dfs(grid,row,column+1);
    	
    }
	
}
