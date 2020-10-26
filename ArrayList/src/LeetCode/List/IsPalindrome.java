package LeetCode.List;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Wdz
 * @Date 2020/8/12 21:07
 * @Description: 9. 回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 输入: 121
 * 输出: true
 *
 * 输入: -121
 * 输出: false
 *
 * 输入: 10
 * 输出: false
 *
 * 进阶:
 * 你能不将整数转为字符串来解决这个问题吗？
 */
public class IsPalindrome {
    public static void main(String[] args) {
        int x = 121;
        //数学方法，将每一位存入数组中,然后通过二分进行前后对比
        System.out.println(isPalindrome1(x));

    }

    /**
     * 字符串反转
     */
    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        final StringBuilder builder = new StringBuilder(str);
        if(builder.reverse().toString().equals(str)){
            return true;
        }
        return false;
    }
    /**
     * 进阶解：不使用字符串，采用list存储int各个位置上的变量置，然后从list两端向中间比较数值是否相等
     */
    public static boolean isPalindrome1(int x) {
        if(x<0) return false;
        List list=new ArrayList();
        while(x/10!=0){
            list.add(x%10);
            x=x/10;
        }
        list.add(x);
        System.out.println((list.size() / 2));
        for(int i=0;i<list.size()/2;i++)
        {
            if(list.get(i)!=list.get(list.size()-i-1)) return false;
        }
        return true;
    }

    /**
     * 进阶解：与上面思路差不多，但是性能得到提升
     * 通过取整和取余操作获取整数中对应的数字进行比较。
     */
    public static boolean isPalindrome11(int x) {
        if (x < 0) return false;
        int div = 1;
        while (x / div >= 10) div *= 10;
        while (x > 0) {
            int left = x / div;
            int right = x % 10;
            if (left != right) return false;
            x = (x % div) / 10;
            div /= 100;
        }
        return true;
    }


    /**
     * 进阶解法---巧妙解法
     * 取出后半段数字进行翻转
     * 注意的一个点就是由于回文数的位数可奇可偶，所以当它的长度是偶数时，它对折过来应该是相等的；
     * 当它的长度是奇数时，那么它对折过来后，有一个的长度需要去掉一位数
     *
     * 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * 每取一个最低位数字，x 都要自除以 10
     * 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等
     */
    public static boolean isPalindrome2(int x) {
        //末尾为 0 就可以直接返回 false
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
