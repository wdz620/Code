package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/8/6 9:42
 * @Description: 209. 长度最小的子数组
 * <p>
 * 给定一个含有n个正整数的数组和一个正整数s，找出该数组中满足其和≥s的长度最小的连续子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 * <p>
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * <p>
 * 注意：题目要求 连续子数组
 * 所以使用滑动窗口
 * <p>
 * //暴力解：遍历所有的连续子数组[i....j]
 * //计算其和sum，验证sum >= s
 * //时间复杂度O(n^3)
 */
public class MinSubArrayLen {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(3, nums));

    }

    /**
     * 网上学习，利用滑动窗口
     *  时间复杂度O(n)
     *  空间复杂度O(1)
     */
    public static int minSubArrayLen(int s, int[] nums) {
        //定义左右指针确定窗口，刚开始窗口没有元素，所以右指针为-1
        int l = 0, r = -1, sum = 0;
        //定义一个数组大小长度，默认比原数组还要多（不可能存在）
        int res = nums.length + 1;
        while (l < nums.length - 1) {
            //不断移动窗口
            if (r < nums.length - 1 && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            //不断寻找最小的子数组长度
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }
}
