package week07;

/**
 * @program: test
 * @description: 岛屿数量
 * @author: ChenWeiJun
 * @create: 2020-11-15 22:23
 **/
public class NumIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++) {
            for (int j=0;j<grid[i].length;j++) {
                if (grid[i][j] == '1') {
                    count++;
                    flush(grid,i,j);
                }
            }
        }
        return count;
    }
    private void flush(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        flush(grid,i-1,j);
        flush(grid,i+1,j);
        flush(grid,i,j-1);
        flush(grid,i,j+1);
    }
}
