package leetcode.List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Wdz
 * @Date 2020/11/8 14:26
 * @Description: 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 * 总结；
 * 学习异或^ 还有 位与 &
 * 位与可以很好的去判断奇偶数 即&1，用来判断最后以为二进制是否为1
 */
public class SingleNumbers {
    // 愚蠢如猪的自答 12ms 40MB
    public static int[] singleNumbers(int[] nums) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], 2);
            }
        }
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                res[index++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        System.out.println(Arrays.toString(singleNumbers(nums)));
    }

    /**
     * 官方参考
     * 4^1^4^6 = 1^6
     *
     */
    public static int[] singleNumbers1(int[] nums) {
        // 用于将所有的数异或起来
        int ret = 0;
        for (int n : nums) {
            ret ^= n;
        }
        // 获得ret中最低位的1
        int div = 1;
        //mask = k & (-k) 这种方法也可以得到mask
        while ((div & ret) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int n : nums) {
            if ((div & n) != 0) {
                a ^= n;
            } else {
                b ^= n;
            }
        }
        return new int[]{a, b};
    }

    // 强大的网友朋友 排序
    public int[] singleNumbers2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] res = new int[2];
        boolean found_first = false;
        for (int i = 0; i + 1 < len; i += 2) {
            // 当前格子和下一个格子数相等，则i+=2直接跳过这两个数，否则这就是我们要找的数
            if (nums[i] != nums[i + 1]) {
                if (!found_first) {
                    res[0] = nums[i];
                    found_first = true;
                } else {
                    res[1] = nums[i];
                    return res;
                }
                i--; // 步长为2，要退回去一格
            }
        }
        res[1] = nums[len - 1]; // 来到这里说明第二个数在i+=2遍历时被跳过了，说明是最后一个数
        return res;
    }
    // 强大的网友朋友 分组异或
    public int[] singleNumbers3(int[] nums) {
        int xorNumber = nums[0];
        for(int k = 1; k < nums.length; k++){
            xorNumber ^= nums[k];
        }
        int onePosition = xorNumber & (-xorNumber);
        int ans1 = 0, ans2 = 0;
        for(int i = 0; i < nums.length; i++){
            if((nums[i] & onePosition) == onePosition){
                ans1 ^= nums[i];
            }else{
                ans2 ^= nums[i];
            }
        }
        return new int[] {ans1 ^ 0, ans2 ^ 0}; // 把初试赋值的0对消掉
    }
}
