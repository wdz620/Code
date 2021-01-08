package leetcode.Math;

/**
 * @Author: Wdz
 * @Date 2020/11/16 15:46
 * @Description: 171、Excel表序列号
 */
public class TitleToNumber {
    // 愚蠢的自答
    // 首先用Map定义每个字符的大小。然后根据字符串长度进行解析。


    // 标准
    public int tittleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            res = res * 26 + num;
        }
        return res;
    }
}
