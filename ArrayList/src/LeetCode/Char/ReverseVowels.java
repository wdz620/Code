package LeetCode.Char;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2020/8/5 19:23
 * @Description: 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母(aeiou)。
 * 输入: "hello"
 * 输出: "holle"
 * 输入: "leetcode"
 * 输出: "leotcede"
 */
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leotcede";
        ReverseVowels rv = new ReverseVowels();
        System.out.println(rv.reverseVowels(s));


    }
    //使用 对撞指针方法
    public  String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            if (isVowel(chars[i]) && isVowel(chars[j])){
                swap(chars, i++, j--);
            }else{
                if (isVowel(chars[i])){
                    j--;
                }else {
                    i++;
                }
            }
        }
        return String.valueOf(chars);

    }

    //交换
    public void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }
    //判断是否是元音
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

}
