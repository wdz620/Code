package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/10/30 9:39
 * @Description: 463. 岛屿的周长
 * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
   输入：
    {
    {0, 1, 0, 0},
    {1, 1, 1, 0},
    {0, 1, 0, 0},
    {1, 1, 0, 0},
    }
 输出： 16
 */
public class IslandPerimeter {
    //暴力自答 9ms 39.7M
    public static int islandPerimeter(int[][] grid) {
        int res = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int temp =4;
                    //判断左边是否为1
                    if(j>0&&grid[i][j-1]==1) temp--;
                    //判断上边是否为1
                    if(i>0&&grid[i-1][j]==1) temp--;
                    //判断右边是否为1
                    if(j<grid[0].length-1&&grid[i][j+1]==1) temp--;
                    //判断下边是否为1
                    if(i<grid.length-1&&grid[i+1][j]==1) temp--;
                    res +=temp;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 1, 0, 0},
                {1, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0},
        };
        System.out.println(islandPerimeter(grid));
        IslandPerimeter is = new IslandPerimeter();
        System.out.println(is.islandPerimeter1(grid));

    }

    //参考答案 递归做法 或者说 DFS
    //10ms 40.3M
    public int islandPerimeter1(int[][] grid) {
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    // 题目限制只有一个岛屿，计算一个即可
                    return dfs(grid, r, c);
                }
            }
        }
        return 0;
    }

    int dfs(int[][] grid, int r, int c) {
        if (!(0 <= r && r < grid.length && 0 <= c && c < grid[0].length)) {
            return 1;
        }
        if (grid[r][c] == 0) {
            return 1;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;
        return dfs(grid, r - 1, c)
                + dfs(grid, r + 1, c)
                + dfs(grid, r, c - 1)
                + dfs(grid, r, c + 1);
    }
}
