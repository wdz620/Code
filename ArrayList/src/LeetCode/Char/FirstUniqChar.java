package LeetCode.Char;

import java.util.Arrays;
import java.util.HashMap;

/**题目：字符串中的第一个唯一字符
    * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 示例：
     * s = "leetcode"
     * 返回 0.
     *
     * s = "loveleetcode",
     * 返回 2.
     * 注意事项：您可以假定该字符串只包含小写字母。
 * 思路 ：
    * 利用双重for循环遍历.
 *
 * 问题:
    * 不知道怎么结束返回，而且好多情况也考虑不全。
 *
 * 解决：
 * TODO 复现net_solution,学习官网思路
 * 如果字符串长度大于26直接返回0
 * 定义一个26位的int数组，存储各个字符的出现次数，如果出现一次返回
 * 官方：
 *
 */
public class FirstUniqChar {
    public static void main(String[] args) {
        String s = "z";
        FirstUniqChar f = new FirstUniqChar();
        System.out.println(f.firstUniqChar(s));


    }

    /**
     * 自答：
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] charNum = new int[26];
        char[] cs = s.toCharArray();
        int length = cs.length;
        //第一次遍历,记录各个字符出现次数
        for (int i = 0; i < length; i++) {
            charNum[cs[i] - 'a']++;
        }
        //第二次遍历，按顺序，如果次数为1，返回下标
        for (int j = 0; j < length; j++) {
            if (charNum[cs[j] - 'a'] == 1) {
                return j;
            }
        }
        //无解
        return -1;
    }

    /**
     * 官方：
     */
    public int firstUniqChar0(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        //获取字符串长度
        int n = s.length();
        // build hash map : character and how often it appears
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

    /**
     * net_solution
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        // 分成两种情况：
        // 第一种为字符串长度小于26的，遍历字符串
        if (s.length() <= 26) {
            int[] charNum = new int[26];//存储各字符出现次数
            char[] chars = s.toCharArray();
            int length = chars.length;
            for (int i = 0; i < length; i++) {//第一次遍历,记录各个字符出现次数
                charNum[chars[i] - 'a']++;
            }
            for (int i = 0; i < length; i++) {//第二次遍历，按顺序，如果次数为1，返回下标
                if (charNum[chars[i] - 'a'] == 1) {
                    return i;
                }
            }
            return -1;//无解
        }

        // 第二种字符串长度大于26，遍历26个字母
        // 反过来，只有26个字符
        int index = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int beginIndex = s.indexOf(ch);
            // 从头开始的位置是否等于结束位置，相等说明只有一个，
            if (beginIndex != -1 && beginIndex == s.lastIndexOf(ch)) {
                //取小的，越小代表越前。
                index = (index == -1 || index > beginIndex) ? beginIndex : index;
            }
        }
        return index;
    }
}
