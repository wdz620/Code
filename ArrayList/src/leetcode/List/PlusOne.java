package leetcode.List;

import java.util.Arrays;

/**
 * 题目：
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 问题： 如何确定0和9的个数和位置 而且如果是{9，9} ——>{1,0,0}
 * 解决：
 *      1、从最后一位（个位）开始考虑，
 *      2、如果不是9,则+1返回； 如果是9,则该位置为0,然后考虑前一位（十位），进入下一步
 *      3、如果最高位不是9，则+1返回; 如果是9，进入下一步
 *      4、此时判断出数组中全是9，所以升高一位。
 *
 * 思考：不要想那么复杂
 *
 */
public class PlusOne {
    public static void main(String[] args) {
        int[] nums0 = {4,3,2,9};
        PlusOne plusOne = new PlusOne();
        int[] ints = plusOne.plusOne(nums0);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 自答解题
     * @param digits
     * @return
     */

    public int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0 ; i--) {
            //如果该位不是9，则加1返回
            if (digits[i] != 9){
                digits[i] += 1;
                return digits;
            }
            //若是9 ，则将该位改为0 (因为9+1=10 此时进一)
            digits[i] = 0;
        }
        //此时说明数组中全是9
        int[] nums = new int[digits.length+1];
        nums[0] = 1;
        return nums;
    }


    /**
     * 网上参考
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits){
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        //跳出for循环，说明数字全部是9
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
