package LeetCode.Char;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Wdz
 * @Date 2020/8/6 10:27
 * @Description: 3. 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * 注意：
 * 子串：串中任意个连续的字符组成的子序列称为该串的子串
 * 注意重复字母的思考
 *
 *
 */
public class LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring1(s));

    }

    /**
     * 思路：两层筛选，第一层控制一个指针，一个一个去排查。
     * 内循环不断去寻找最长的
     * 小细节：如何移动，将重复的排查出去，通过使用Set集合。
     */
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过,HashSet不允许重复元素
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            //此处if判断是精髓！！！！！！！！！！
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }

            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 滑动窗口
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

}
