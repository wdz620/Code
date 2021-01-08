package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/11/18 9:13
 * @Description: 134. 加油站
 * <p>
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 * <p>
 * 说明:
 * 如果题目有解，该答案即为唯一答案。
 * 输入数组均为非空数组，且长度相同。
 * 输入数组中的元素均为非负数。
 * <p>
 * 输入:
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 输出: 3
 * 解释:
 * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
 * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
 * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
 * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
 * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
 * 因此，3 可为起始索引。
 * <p>
 * <p>
 * 输入:
 * gas  = [2,3,4]
 * cost = [3,4,3]
 * 输出: -1
 * 解释:
 * 你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
 * 我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
 * 开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
 * 开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
 * 你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
 * 因此，无论怎样，你都不可能绕环路行驶一周。
 */
public class CanCompleteCircuit {
    // 自答:
    // 1、能否启动        --->    相同索引处的比较。当gas[i] > cost[i] 说明可以到达下一个站点。
    // 2、能否回到起点     --->    考虑上一个站点的消耗，以及目前剩下的油量，是否支持到达下一个站点。
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        for (int i = 0; i < length; i++) {
            // 记录启动点和油箱内油量
            int index = i, sum = gas[i];
            // 能启动
            while (sum >= cost[index]) {
                sum = sum - cost[index] + gas[(index + 1) % length];
                index = (index + 1) % length;
                // 回到起点
                if (index == i) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
//        int[] gas = {2, 3, 4};
//        int[] cost = {3, 4, 3};
        System.out.println(canCompleteCircuit1(gas, cost));
        System.out.println(canCompleteCircuit(gas, cost));
    }
    // 参考
    public static int canCompleteCircuit1(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }
        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    // 暴力法  https://leetcode-cn.com/problems/gas-station/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by--30/
    public int first(int[] gas, int[] cost) {
        int n = gas.length;
        //考虑从每一个点出发
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            //当前剩余的油能否到达下一个点
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
        }
        //任何点都不可以
        return -1;
    }

    /**
     * 优化一
     */
    public int second(int[] gas, int[] cost) {
        int n = gas.length;
        //记录能到的最远距离
        int[] farIndex = new int[n];
        for (int i = 0; i < farIndex.length; i++) {
            farIndex[i] = -1;
        }
        //记录到达最远距离时候剩余的汽油
        int[] farIndexRemain = new int[n];
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                //到达下个点后的剩余
                remain = remain - cost[j];
                j = (j + 1) % n;
                //判断之前有没有考虑过这个点
                if (farIndex[j] != -1) {
                    //加上当时剩余的汽油
                    remain = remain + farIndexRemain[j];
                    //j 进行跳跃
                    j = farIndex[j];
                } else {
                    //加上当前点的补给
                    remain = remain + gas[j];
                }
                if (j == i) {
                    return i;
                }
            }
            //记录当前点最远到达哪里
            farIndex[i] = j;
            //记录当前点的剩余
            farIndexRemain[i] = remain;
        }
        return -1;
    }

    /**
     * 优化二
     */
    public int thrid(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            int remain = gas[i];
            while (remain - cost[j] >= 0) {
                //减去花费的加上新的点的补给
                remain = remain - cost[j] + gas[(j + 1) % n];
                j = (j + 1) % n;
                //j 回到了 i
                if (j == i) {
                    return i;
                }
            }
            //最远距离绕到了之前，所以 i 后边的都不可能绕一圈了
            if (j < i) {
                return -1;
            }
            //i 直接跳到 j，外层 for 循环执行 i++，相当于从 j + 1 开始考虑
            i = j;

        }
        return -1;
    }

}
