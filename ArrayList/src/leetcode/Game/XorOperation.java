package leetcode.Game;

/**
 * @Author: Wdz
 * @Date 2020/11/17 9:52
 * @Description: 1486. 数组异或操作
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。

 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 *      "^" 为按位异或 XOR 运算符。
 *
 *输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 *
 * 输入：n = 1, start = 7
 * 输出：7
 *
 * 输入：n = 10, start = 5
 * 输出：2
 */
public class XorOperation {
    // 自答
    public static int xorOperation(int n, int start) {
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = start + 2 * i;
        }
        int res = temp[0];
        for (int i = 1; i < temp.length; i++) {
            res = res ^ temp[i];
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(10, 5));
        System.out.println(xorOperation1(10, 5));

    }

    // 官方
    public static int xorOperation1(int n, int start) {
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans ^= (start + i * 2);
        }
        return ans;
    }
}
