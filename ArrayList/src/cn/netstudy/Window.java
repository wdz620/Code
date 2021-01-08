package cn.netstudy;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Author: Wdz
 * @Date 2020/10/27 8:24
 * @Description: Java滑动窗口学习
 * 滑动窗口实际上是通过双指针实现的，[left,right]之间的范围就是窗口。通常用于解决字符串、数组相关的问题。比如最小子串等。
 */
public class Window {
    //模板
    /*
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        //记录最小覆盖子串的起始索引及长度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            //c 是将移入窗口的字符
            char c = s.charAt(right); //右移窗口
            right++;
            //进行窗口内数据的一系列更新
            // ...
            //判断左侧窗口是否要收缩
            while (...){
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;
                //进行窗口内数据的一系列更新
            }
        }
        return ...;
    }
     */
    //实战1：最小覆盖子串
    //给你一个字符串S、一个字符串T，请在字符串S里面找出：包含T所有字母的最小子串
    //输入：S=“ADOBECODEBANC”, T=“ABC”
    //输出：“BANC”
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right); // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c) == need.get(c))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 在这里更新最小覆盖子串
                // len用于记录当前最佳的长度
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        // 返回最小覆盖子串
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    //实战2：字符串排列
    //给定两个字符串s1和s2，写一个函数来判断s2是否包含s1的排列。
    //输入：s1=“ab”, s2=“eidbaooo”
    //输出:True
    //因为"ba"在s2中
    public static boolean checkInclusion(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right); // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c) == need.get(c))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right-left>=t_len) {
                // 在这里更新最小覆盖子串
                if (valid==need.size()) {
                    return true;
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        // 返回最小覆盖子串
        return false;
    }

    //实战3：找所有字母异位的词
    //给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引
    //输入：s:“cbaebabacd”, p:“abc”
    //输出：[0,6]
    public static ArrayList<Integer> checkInclusion1(String s, String t) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        ArrayList<Integer> res = new ArrayList<>();
        int t_len = t.length();
        for (int i = 0; i < t_len; i++) {
            need.put(t.charAt(i), need.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及⻓度
        int start = 0, len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right); // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if (need.containsKey(c)) {
                int tmp = window.getOrDefault(c, 0);
                window.put(c, ++tmp);
                if (window.get(c) == need.get(c))
                    valid++;
            }
            // 判断左侧窗口是否要收缩
            while (right-left>=t_len) {
                // 在这里更新最小覆盖子串
                if (valid==need.size()&&!s.substring(left,right).equals(t)) {
                    res.add(left);
                }
                // d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if (need.containsKey(d)) {
                    if (window.get(d) == need.get(d))
                        valid--;
                    int tmp = window.get(d);
                    window.put(d, --tmp);
                }
            }
        }
        // 返回最小覆盖子串
        return res;
    }

    //实战4：最长无重复子串
    //给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
    //输入：“abcabcbb”
    //输出：3
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> window = new HashMap<>();
        int res = 0;
        int left = 0, right = 0;
        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right); // 右移窗口
            int count = window.getOrDefault(c, 0);
            // 进行窗口内数据的一系列更新
            window.put(c, ++count);
            right++;
            // 判断左侧窗口是否要收缩
            while (window.getOrDefault(c, 0)>1) {
                count = window.get(s.charAt(left));
                // 将字符移除
                window.put(s.charAt(left), --count);
                // 左移窗口
                left++;
            }
            if(res<right-left){
                res= right-left;
            }
        }
        // 返回最小覆盖子串
        return res;
    }


}
