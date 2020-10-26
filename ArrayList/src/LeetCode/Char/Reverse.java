package LeetCode.Char;

import java.util.Arrays;

/**题目：整数反转
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *示例：
     * 输入: 123   输入: -123  输入: 120
     * 输出: 321   输出: -321  输出: 21
     *
 * 注意：
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 思路：
         * 判断是否为负数，或者个位为0
         * String.valueOf(x).toCharArray(); 将int数的每一位切割 变成一个char
         *Integer.valueOf(s)  将char拼成int数
 *
 *官方：
 *
 */
public class Reverse {
    public static void main(String[] args) {
        Reverse r = new Reverse();
        //官方测试
        System.out.println(r.reverse1(1534236469));

    }

    /**
     * 官方答案：TODO 理解之后，再来一次！
     */
    public int reverse0(int x){
        if (x == Integer.MIN_VALUE) return 0;
        int neg = x < 0 ? -1 : 1;
        x *= neg;
        int ret = 0;
        while (x > 0){
            int n = ret;
            n *= 10;
            n += x % 10;
            x /= 10;
            if (n / 10 != ret) return 0;
            ret = n;
        }
        return ret * neg;
    }



    /**
     * 自答：运行出现异常，无法通过！！！
     *
     */
    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        if (chars == null && chars.length < 0){
            return 0;
        }
        if (chars.length ==1 || (chars.length == 2 && chars[0] == '-')){
            return x;
        }
        if (x>0) {
            int l = chars.length - 1;
            for (int i = 0; i < chars.length; i++) {
                if (l > i) {
                    char temp = chars[i];
                    chars[i] = chars[l];
                    chars[l] = temp;
                    l--;
                }
            }
            String s = new String(chars);
            if (chars[0] == '0'){
                String s1 = s.substring(1);
                return Integer.valueOf(s1);
            }
            return Integer.valueOf(s);
        }else{
            int l = chars.length - 1;
            for (int i = 1; i < chars.length; i++) {
                if (l > i) {
                    char temp = chars[i];
                    chars[i] = chars[l];
                    chars[l] = temp;
                    l--;
                }
            }
            String s = new String(chars);
            if (chars[1] == '0'){
                String s1 = s.substring(1);
                String s2 = '-' + s1;
                return Integer.valueOf(s2);
            }
            return Integer.valueOf(s);
        }
    }

    /**
     * net Solution 123
     * 学习到：
     *      int数值范围[-2^31 ~ 2^32-1] 也就是 [-2147483648, 2147483647]
     *      当超过最大值，比如到2147483647+1 就变成 -2147483648,即循环赋值，一旦超出就循环到最小的值，以此类推。
     *      long数值范围[-2^63 ~ 2^63-1] 也就是[-9223372036854775808,9223372036854775807]
     */
    public int reverse1(int x){
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
