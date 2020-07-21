package LeetCode.List;

import java.util.Arrays;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * eg1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 *
 * 我解决思路：
 * 方法1：双重for循环，可以用短的数组去匹配长的，如过相等就将该值放入一个数组返回
 *    问题：1、不知道怎么确定新的数组的长度
 *         2、重复的数据怎么放入，因为包括重复一次的 两次的。
 *         不同于前一个练习。
 *
 * 官方解答：排序 -> 我们对两个数组进行排序，并且使用两个指针在一次扫面找出公共的数字。
 *              算法 ：对数组 nums1 和 nums2 排序。
 *                    初始化指针 i，j 和 k 为 0。
 *                    指针 i 指向 nums1，指针 j 指向 nums2：
 *                    如果 nums1[i] < nums2[j]，则 i++。
 *                    如果 nums1[i] > nums2[j]，则 j++。
 *                    如果 nums1[i] == nums2[j]，将元素拷贝到 nums1[k]，且 i++，j++，k++。
 *                    返回数组 nums1 前 k 个元素。
 */
public class Intersect_II {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Intersect_II i = new Intersect_II();
        int[] ints = i.test(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }

    /**
    复现
     */
    public int[] test(int[] ints1,int[] ints2){
        Arrays.sort(ints1);
        Arrays.sort(ints2);
        int i = 0,j = 0,k = 0;
        while (i < ints1.length && j < ints2.length){
            if (ints1[i] < ints2[j]){
                i++;
            }else if (ints1[i] > ints2[j]){
                j++;
            }else {
                ints1[k] = ints1[i];
                i++;
                j++;
                k++;
            }
        }
        int[] nums = Arrays.copyOfRange(ints1,0,k);
        return nums;
    }
    /**
     * 官方解答
     * @param nums1
     * @param nums2
     * @return
     */

    public int[] intersect(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        int[] ints = Arrays.copyOfRange(nums1, 0, k);
        return ints;
    }

}
