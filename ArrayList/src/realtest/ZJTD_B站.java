package realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2021/1/13 22:10
 * @Description: 左神B站
 * https://www.bilibili.com/video/BV15D4y1X7Tt?p=2
 *
 * 给定长度为m的字符串aim,以及一个长度为n的字符串str，试问能否在str中找到一个长度为m的连续子串，
 * 使得这个子串刚好由aim的m个字符串组成，顺序无所谓，返回任意满足条件的一个子串的起始位置，未找到返回-1
 *
 * abc
 * axcsdacb
 * 返回5
 *
 */
public class ZJTD_B站 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String aim = bf.readLine();
        String str = bf.readLine();

        System.out.println(test3(aim, str));
    }
    public static int test1(String a, String s) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] aim = a.toCharArray();
        Arrays.sort(aim);
        String aimSort = String.valueOf(aim);
        for (int L = 0; L < s.length(); L++) {
            for (int R = L; R < s.length(); R++) {
                char[] cur = s.substring(L, R + 1).toCharArray();
                Arrays.sort(cur);
                String curSort = String.valueOf(cur);
                if (aimSort.equals(curSort)) {
                    return L;
                }
            }
        }
        return -1;
    }
    // 自答：使用一个数组存储s，然后让a去减。
    public static int test2(String a, String s) {
        int aLen = a.length(), i = s.length() - a.length();
        while (i > 0) {
            String s1 = s.substring(i, i + aLen);
            if (isYF(s1, a)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isYF(String s1, String s2) {
        char[] chars = s1.toCharArray();
        char[] chars1 = s2.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < chars.length; i++) {
            count[chars[i]]++;
        }
        for (int i = 0; i < chars1.length; i++) {
            if (count[chars1[i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    // 左神解答
    public static int test22(String a, String s) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] str = s.toCharArray();
        char[] aim = a.toCharArray();
        // 假设aim长度为M
        // 枚举。str中的子串，长度为M的所有可能
        for (int L = 0; L <= str.length - aim.length; L++) {
            if (isCountEqual(str, L, aim)) {
                return L;
            }
        }
        return -1;
    }

    private static boolean isCountEqual(char[] str, int l, char[] aim) {
        int[] count = new int[256];
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        for (int i = 0; i < aim.length; i++) {
            if (count[str[l + i]]-- == 0) {
                return false;
            }
        }
        return true;
    }

    // 左神：滑动窗口
    public static int test3(String a, String s) {
        if (s == null || a == null || s.length() < a.length()) {
            return -1;
        }
        char[] aim = a.toCharArray();
        int[] count = new int[256];
        for (int i = 0; i < aim.length; i++) {
            count[aim[i]]++;
        }
        int M = aim.length;
        char[] str = s.toCharArray();
        int inValidTime = 0;
        int R = 0;
        // 先让窗口拥有M个字符
        for (; R < M; R++) {
            if (count[str[R]]-- <= 0) {
                inValidTime++;
            }
        }

        for (; R < str.length; R++) {
            // 第一个窗口的判断
            if (inValidTime == 0) {
                return R - M;
            }
            // 其他窗口的判断
            if (count[str[R]]-- <= 0) {
                inValidTime++;
            }
            if (count[str[R - M]]++ < 0) {
                inValidTime--;
            }
        }
        // 最后一个窗口的判断
        return inValidTime == 0 ? R - M : -1;
    }

}
