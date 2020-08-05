package LeetCode.List;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/8/4 16:03
 * @Description:颜色分类
 *
 * 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 *
 * 实例：
 * 输入: [2,0,2,1,1,0]
 * 输出: [0,0,1,1,2,2]
 */
public class SortColors {
    public static void main(String[] args) {
        int[] nums = {2, 0, 0, 2, 1, 1, 0, 1};
        sortColors02(nums);
        System.out.println(Arrays.toString(nums));


    }
    //第一种解法：计数排序
    //遍历整个数组，统计0，1，2的个数然后在放回数组即可！
    public static void sortColors01(int[] nums) {
        int n = 0, p = 0, q = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0){
                n++;
            }else if (nums[i] == 1){
                p++;
            }else {
                q++;
            }
        }
        for (int i = 0; i < n ; i++) {
            nums[i] = 0;
        }
        for (int i = 0; i < p ; i++) {
            nums[n + i] = 1;
        }
        for (int i = 0; i < q ; i++) {
            nums[i + n + p] = 2;
        }

    }
    //第一种方法的优化:遍历一遍数组（三路快排）
    public static void sortColors02(int[] nums) {
        int zero = -1;              //nums[0...zero] == 0
        int two = nums.length;      //nums[two...n-1] == 2
        for (int i = 0; i < two ;) {
            if (nums[i] == 1){
                i++;
            }else if (nums[i] ==2){
                two--;
                int temp = nums[two];
                nums[two] = nums[i];
                nums[i] = temp;
            }
            else { //等于0的情况
                zero++;
                int temp = nums[zero];
                nums[zero] = nums[i];
                nums[i] = temp;
                i++;
            }

        }
    }

}
