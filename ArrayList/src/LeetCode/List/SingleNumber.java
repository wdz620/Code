package LeetCode.List;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 说明：
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 示例：{1,1,2},{1,2,2},{1,1,2,2,4} --->2,1,4
 * <p>
 * 思路：暴力法，找只出现一次的数。当然这样必然导致资源的浪费，能否优化到 比过的数字就不在进行比较。
 *
 * 定义0，让数组中的数与之异或，因为必然会有两次的导致在为0
 * 学到了最好的办法就是 异或运算 ---->相同的位为0，不同位的1 例如11000，10111 ---》01111
 */
public class SingleNumber {
    public static void main(String[] args) {
        SingleNumber findOneDemo = new SingleNumber();
        int[] n = {4,1,2,1,2};
        int i1 = findOneDemo.singleNumber2(n);
        System.out.println("唯一的数字 :" + i1);
    }
    /**
     * 复现
     */
    public int test(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            int b = 0;
            for (int j = 0; j < nums.length ; j++) {
                if (nums[i] == nums[j]){
                    b++;
                }
            }
            if (b == 1){
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 方法 1：暴力法
     *
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int b = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    b++;
                }
            }
            if (b == 1) {
                return nums[i];
            }
        }
        return 0;
    }

    /**
     * 方法 2： 位运算：异或运算 TODO 异或真的很厉害！！！
     */
    public int singleNumber2(int[] nums) {
        int a = 0;
        for (int i : nums) {
            a ^= i;
        }
        return a;
    }
}
