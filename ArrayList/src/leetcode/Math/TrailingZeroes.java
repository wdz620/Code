package leetcode.Math;

/**
 * @Author: Wdz
 * @Date 2020/11/16 14:09
 * @Description: 172、阶乘后的零
 *
 */
public class TrailingZeroes {
    // 思路就是看这个数里面有几个5
    public static int traiLingZeroes(int n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(traiLingZeroes(25));
    }
}
