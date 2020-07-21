package LeetCode.Char;


import java.util.Arrays;

/***题目：反转字符串
     *  编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 示例：
     * 输入：['H','a','n','n','a','h']
     * 输出：['h','a','n','n','a','H']
 * 思路：使用快排的思想，头和尾进行交换，直到相遇
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] chars ={'H','a','n','n','a','h'};
        ReverseString r = new ReverseString();
        r.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }



    public void reverseString(char[] s) {
        int l = s.length-1;
        for (int i = 0; i < s.length ; i++) {
            if (l > i) {
                char temp = s[i];
                s[i] = s[l];
                s[l] = temp;
                l--;
            }
        }
    }
}
