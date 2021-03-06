package leetcode.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/8/3 16:45
 * @Description:移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * 实例：
 * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
 * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 * 注意这五个元素可为任意顺序。
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
         int[] nums = {0,1,2,2,3,0,4,2,6};
         int val = 2;
        System.out.println(removeElement(nums, val));


    }
    public static int removeElement(int[] nums,int val){
        int j = 0;
        for (int i = 0; i < nums.length ; i++) {
            //如果不等于该元素，就将其放到左边，最终还是看J指针
            if (nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j;
    }
}
