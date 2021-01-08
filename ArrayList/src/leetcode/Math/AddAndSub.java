package leetcode.Math;

/**
 * @Author: Wdz
 * @Date 2020/11/16 18:39
 * @Description: JZ 48不用加减乘除做加法
 *写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 *
 * 与运算符(&)：		如果相对应位都是1，则结果为1，否则为0
 * 或运算符(|)：		如果相对应位都是0，则结果为0，否则为1
 * 非运算符(~)：		按位取反运算符翻转操作数的每一位，即0变成1，1变成0。
 * 异或运算符(^)：	    如果相对应位值相同，则结果为0，否则为1
 */
public class AddAndSub {
    // 异或+与运算
    public static int add(int num1, int num2) {
//        if (num1 == 0 || num2 == 0)
//            return num1 != 0 ? num1 : num2;
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
        System.out.println(add(1, 2));
        System.out.println(sub(100, 55));
    }

    // 减法
    public static int sub(int num1, int num2) {
        num2 = ~num2 + 1;
        return add(num1, num2);
    }
}
