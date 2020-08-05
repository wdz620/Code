package LeetCode.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/8/5 19:52
 * @Description: 11. 盛最多水的容器
 * <p>
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，
 * 使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 * <p>
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 */
public class MaxArea {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea02(nums));
    }

    //自答错误：两个指针一起移动，必然会少很多（未考虑到该哪个指针的移动）
    //利用对撞指针的思想,找到最大的一组
    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, res;
        List<Integer> ints = new ArrayList<Integer>();
        while (i < j) {
            int temp;
            if (height[i] >= height[j]) {
                temp = height[j] * (j - i);
                ints.add(temp);
                i++;
                j--;
            } else {
                temp = height[i] * (j - i);
                ints.add(temp);
                i++;
                j--;
            }
        }
        Collections.sort(ints);
        return ints.get(ints.size() - 1);
    }

    /**
     * 官方解答
     */
    public static int maxArea01(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

    //修改自答:学到了两个数学函数的运用
    public static int maxArea02(int[] height) {
        int i = 0, j = height.length - 1, res = 0;
        while (i < j) {
            int temp = Math.min(height[i], height[j]) * (j - i);
            res = Math.max(temp, res);
            if (height[i] >= height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }
}
