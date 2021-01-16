package realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Wdz
 * @Date 2021/1/14 9:31
 * @Description: 机器人的活动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
 * 但是不能进入行坐标和列坐标的数位之和大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
 * 输入：
 * 一行三个正整数由空格分开，分别代表行数m，列数n，和坐标数位之和的阈值k，0 < m <= 100, 0 < n <= 100, 0 < k <= 20。
 * 输出：
 * 一个正整数，代表该机器人能够到达的格子数量。
 *
 */
public class KS_35 {
    public static void main (String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();
        String[] str = s.split(" ");
        int m = Integer.valueOf(str[0]), n = Integer.valueOf(str[1]), k = Integer.valueOf(str[2]);
        boolean[][] visited = new boolean[m][n];
        System.out.print(new KS_35().dfs(m, n, k, visited, 0, 0));
    }
    public int dfs (int m, int n, int k, boolean[][] visited, int x, int y) {
        // 递归终止
        if ((get(x) + get(y) > k) || x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) {
            return 0;
        }
        // 记录读过的位置
        visited[x][y] = true;
        return 1 + dfs (m, n, k, visited, x, y + 1)
                + dfs (m, n, k, visited, x, y - 1)
                + dfs (m, n, k, visited, x + 1, y)
                + dfs (m, n, k, visited, x - 1, y);
    }
    public int get (int x) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        return res;
    }
}
