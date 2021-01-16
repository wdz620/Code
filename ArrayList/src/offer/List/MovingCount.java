package offer.List;

/**
 * @Author: Wdz
 * @Date 2021/1/6 16:56
 * @Description: 66、机器人的运动范围
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。
 * 请问该机器人能够达到多少个格子？
 * <p>
 * 5,10,10
 * 21
 */
public class MovingCount {
    // 考虑最远的那一行有几个
    // 上一层加1个，直到第一行。
    public static int movingCount(int threshold, int rows, int cols) {
        if (threshold == 0) return 1;
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i > 10 || j > 10) {
                    int i1 = getSum(i);
                    int j1 = getSum(j);
                    if (i1 + j1 > threshold) {
                        continue;
                    } else {
                        res++;
                    }
                } else {
                    if (i + j > threshold) {
                        continue;
                    } else {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static int getSum(int m) {
        int temp = 0;
        while (m != 0) {
            temp += m % 10;
            m /= 10;
        }
        return temp;
    }

    public static void main(String[] args) {
        MovingCount m = new MovingCount();
        System.out.println(m.movingCount2(2, 3, 1));
    }
    // LeetCode官方解答
    public int movingCount1(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        boolean[][] vis = new boolean[m][n];
        int ans = 1;
        vis[0][0] = true;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if ((i == 0 && j == 0) || get(i) + get(j) > k) {
                    continue;
                }
                // 边界判断
                if (i - 1 >= 0) {
                    vis[i][j] |= vis[i - 1][j];
                }
                if (j - 1 >= 0) {
                    vis[i][j] |= vis[i][j - 1];
                }
                ans += vis[i][j] ? 1 : 0;
            }
        }
        return ans;
    }

    // 第二种解答
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        // 机器人从[0,0]坐标开始移动
        return dfs(m, n ,k , visited, 0, 0);
    }
    public int dfs(int m, int n, int k, boolean[][] visited, int x, int y){
        // 递归终止条件
        if((get(x) + get(y) > k) || x < 0 || x >= m || y < 0 || y >= n || visited[x][y]){
            return 0;
        }
        // 将该格子标记为已经访问过
        visited[x][y] = true;
        // 继续搜索四个方向
        return 1 + dfs(m, n , k, visited, x, y+1)
                + dfs(m, n , k, visited, x, y-1)
                + dfs(m, n , k, visited, x+1, y)
                + dfs(m, n , k, visited, x, y-1);
        // 回溯的返回过程
    }

    private int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
