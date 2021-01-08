package leetcode.List;

/**
 * @Author: Wdz
 * @Date 2020/11/10 9:02
 * @Description: 35. 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
    // 思路一：暴力法
    public static int searchInsert(int[] nums, int target) {
        int index = 0;
        while (index < nums.length) {
            if (nums[index] >= target) {
                return index;
            }
            if (target > nums[index] && index == nums.length) {
                return index;
            }
            index++;
        }
        return index;
    }

    // 思路二：使用二分查找
    public static int searchInsert1(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert1(nums, 5));

    }
}
