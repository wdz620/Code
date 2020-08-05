package LeetCode.Char;

import java.util.ArrayList;
import java.util.HashMap;

/**125
 * 题目：验证回文字符串 ->是一个正读和反读都一样的字符串
     *给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 示例：
     * 输入: "A man, a plan, a canal: Panama"          输入: "race a car"
     * 输出: true                                      输出: false
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 思路：可以将字符串一分为二，然后用两个指针，分别从前后开始，往中间走。
 * 一分为二时，注意奇偶数。
 * 法二：
 * 将字符串颠倒，看是否与原字符串相同。
 *
 * 问题：
    *  怎么去计算数字字符和字母，排除其他字符。 数字 ：a>=48 && a<=57  字母 ：(a>=65 && a<=90) ||(a>=97 && a<=122)
 */
public class IsPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        IsPalindrome iP = new IsPalindrome();
        System.out.println(iP.isPalindrome(s));
    }

    /*
    自答：
     */
    public boolean isPalindrome(String s) {
        //处理字符串，将字母和数字字符抽离出来。
        char[] cs = s.toLowerCase().toCharArray();
        ArrayList<Character> cs1 = new ArrayList<>();
        for (int k = 0; k < cs.length; k++) {
            if (cs[k] >=48 && cs[k] <=57){
                cs1.add(cs[k]);
            }else if ((cs[k]>=65 && cs[k]<=90) ||(cs[k]>=97 && cs[k]<=122)){
                cs1.add(cs[k]);
            }
        }
        //法一:头尾相等判断
        int i = 0,j = cs1.size()-1;
        while (i <= j){
            if (cs1.get(i) != cs1.get(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
