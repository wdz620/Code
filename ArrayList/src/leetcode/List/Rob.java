package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/11/11 9:08
 * @Description: 198、打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Rob {
    // 先偷最多的那家，然后在偷其他 失败！！！
    // 测试用例 2，3，2   ----> 3 < 4
    public static int rob(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int max = 0, maxIndex = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
        }
        res = max;
        int left = maxIndex, right = maxIndex;
        while (left >= 0) {
            left = left - 2;
            if (left >= 0) {
                res = res + nums[left];
            }
        }
        while (right <= nums.length) {
            right = right + 2;
            if (right <= nums.length - 1) {
                res = res + nums[right];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        System.out.println(rob2(nums));
    }
    // 标准动态规划思想
    public static int rob1(int[] nums) {
        if (nums.length == 0)
            return 0;
        /**
         * 子问题
         * f(k) = [0,k)  先去偷前k家的钱
         * f(0) = 0
         * f(1) = nums[0]
         * f(k) = max(rob(k-1),nums[k-1]+rob(k-2))
         */
        int N = nums.length;
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[N];
    }

    // 优化
    public static int rob2(int[] nums) {
        int prev = 0;
        int curr = 0;

        // 每次循环，计算“偷到当前房子为止的最大金额”
        for (int i : nums) {
            // 循环开始时，curr 表示 dp[k-1]，prev 表示 dp[k-2]
            // dp[k] = max{ dp[k-1], dp[k-2] + i }
            int temp = Math.max(curr, prev + i);
            prev = curr;
            curr = temp;
            // 循环结束时，curr 表示 dp[k]，prev 表示 dp[k-1]
        }

        return curr;
    }

    // 官方学习
    public static int rob3(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int length = nums.length;
        if (length == 1)
            return nums[0];
        int[] dp = new int[length];
        dp[0] = 0;
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 1] + nums[i]);
        }
        return dp[length - 1];
    }

    // 上述方法使用了数组存储结果。
    // 考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。
    public static int rob4(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}
