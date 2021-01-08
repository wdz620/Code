package leetcode.List;

import java.util.Arrays;

/**
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 * 说明：
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的 原地 算法。
 * <p>
 * 方法 1：暴力旋转
 * 方法 2：使用额外的数组
 * 方法 3：使用环状替换
 */
public class Rotate_Int {
    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 6, 7, 8, 0};
        int k = 3;
        Rotate_Int xz = new Rotate_Int();
        xz.first(a, k);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 方法 1：暴力旋转
     * 时间复杂度过高
     */

    public void first(int[] nums, int k) {
        k = k % nums.length;
        for (int j = 0; j < k; j++) {
            int temp = nums[nums.length - 1];
            //System.out.println(temp);
            for (int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = temp;
        }
    }

    /**
     * 方法 2：使用额外的数组:
     * 我们可以用一个额外的数组来将每个元素放到正确的位置上，
     * 也就是原本数组里下标为 ii 的我们把它放到 (i+k)\%数组长度(i+k)%数组长度 的位置。
     * 然后把新的数组拷贝到原数组中
     */
    public void second(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < a.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 方法 3：使用环状替换
     */
    public void thrid(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    /**
     * 方法4；使用反转
     */
    public void four(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
