package realtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author: Wdz
 * @Date 2021/1/9 22:01
 * @Description: 字符串长度最大乘积
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 *
 * Input:
 * ["a","ab","abc","cd","bcd","abcd"]
 * Output:
 * 4
 * 学习到：学了一下String的replace(old，new)替换字符、substring(i, j)截取[i,j)、split(",")按照，切割 、contains(字符)是否包含
 */
public class KS_06 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        input = input.replace("\"", "");
        String[] s = input.substring(1,input.length()-1).split(",");
        int len = s.length;
        int max = 0;
        for (int i = 0; i < len; i++){
            for (int j = i + 1; j < len; j++) {
                if (!sameChar(s[i], s[j])){
                    int temp = s[i].length() * s[j].length();
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.print(max);
    }
    // 判断两个字符串是否有重复
    private static boolean sameChar(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s2.contains(s1.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    }
}
