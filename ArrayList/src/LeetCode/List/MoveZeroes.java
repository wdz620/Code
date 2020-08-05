package LeetCode.List;

import java.util.ArrayList;
import java.util.Arrays;

/**题目：
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例：
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 思路：
 * 新定义一个数组，找到非零原始赋值。
 *
 * 问题：
 * 该方法是个void，无返回。
 *
 * 解决：
 *循环将新数组的值赋到原数组  时间复杂度O(n) ,空间复杂度O(n)
 *
 *官方：快排思想 ：通过中间变量 将两边的值调换，指针从头往后移动。
 * 时间复杂度O(n) ,空间复杂度O(1)
 *
 *
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] n1 = {0,1,0,3,12,1};
        MoveZeroes m = new MoveZeroes();
        m.moveZeroes1(n1);
        System.out.println(Arrays.toString(n1));

    }

    /**
     * 自答
     * @param nums
     */
    public void moveZeroes(int[] nums){
        int i = 0,j = 0;
        int[] nums1 = new int[nums.length];
        while (i < nums.length){
            if (nums[i] != 0){
                nums1[j] = nums[i];
                i++;
                j++;
            }else {
                i++;
            }
        }
        for (int k = 0; k < nums1.length ; k++) {
            nums[k] = nums1[k];
        }
    }
    /**官方  */
    public void moveZeroes1(int[] nums) {
        if(nums==null) {
            return;
        }
        //两个指针i和j
        int j = 0;
        for(int i=0;i<nums.length;i++) {
            //当前元素!=0，就把其交换到左边，等于0的交换到右边
            if(nums[i]!=0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j++] = tmp;
            }
        }
    }
    /**官方另一种解释 */
    public void moveZeroes2(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                if (i > j) {// #1
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
