package leetcode.List;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**题目：
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *示例：
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 *
 * 思路：用target从头减去数组中数，去遍历结果是否在数组中，如果有则返回这两个数
 *
 * 问题：出现负数，计算错误 [-1,-2,-3,-4,-5]   -8
 *
 *  解决：第一次加入的if判断导致只能算正数，该题目设定已经考虑到target和数组中的数之间的关系，
 *      即数组排好序。
 *
 *  官方：哈希表 时间复杂度O(n) 空间复杂度O(n)
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;
        TwoSum t = new TwoSum();
        int[] ints = t.twoSum1(nums, target);
        System.out.println(Arrays.toString(ints));
        System.out.println("============================");

    }

    /**
     * 自答： 时间复杂度O(n2) 空间复杂度O(1)
     */
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        int i1;
        int[] results = new int[2];
        while (i < nums.length){
            i1 = target - nums[i];
            for (int j = i+1; j < nums.length ; j++) {
                if ( i1 == nums[j]){
                    results[0] = i;
                    results[1] = j;
                    return results;
                }
            }
            i++;
        }
        return results;
    }
    /**
     * 官方：
     * 为了对运行时间复杂度进行优化，我们需要一种更有效的方法来检查数组中是否存在目标元素。
     * 如果存在，我们需要找出它的索引。保持数组中的每个元素与其索引相互对应的最好方法是什么？哈希表。
     * 通过以空间换取速度的方式，我们可以将查找时间从 O(n)O(n) 降低到 O(1)O(1)。哈希表正是为此目的而构建的，
     * 它支持以 近似 恒定的时间进行快速查找。我用“近似”来描述，是因为一旦出现冲突，查找用时可能会退化到 O(n)O(n)。
     * 但只要你仔细地挑选哈希函数，在哈希表中进行查找的用时应当被摊销为 O(1)O(1)。
     * 一个简单的实现使用了两次迭代。在第一次迭代中，我们将每个元素的值和它的索引添加到表中。
     * 然后，在第二次迭代中，我们将检查每个元素所对应的目标元素（target - nums[i]target−nums[i]）是否存在于表中。
     * 注意，该目标元素不能是 nums[i]nums[i] 本身！
     *
     */
    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] { i, map.get(complement) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    /**
     * 网上学习 数组从1开始
     * 注意问题，如果没有解怎么办？出现多个解又该如何？  还是要考虑的全面
     *
     * 对撞指针方法
     * 头尾各定义一个指针i,j
     * 当i+j==target  直接返回
     * 当i+j<target  i++
     * 当i+j>target j--
     */
    public int[] twoSum2(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1,res;
        int[] nums =new int[2];
        while (i < j) {
            res = numbers[i] + numbers[j];
            if (res == target){
                nums[0] = ++i;
                nums[1] = ++j;
                return nums;
            }
            if (res < target){
                i++;
            }
            if (res > target){
                j--;
            }
        }
        return nums;
    }
}
