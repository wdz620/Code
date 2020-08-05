package LeetCode.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/8/5 18:28
 * @Description: 215. 数组中的第K个最大元素 TODO
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 *
 * 说明:
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class FindKthLargest {
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};

    }
    //思路：排序之后先查找出第一大元素，然后在查找第二大元素，以此类推看看能不能实现
    public int findKthLargest(int[] nums, int k) {
        return 0;
    }
}
