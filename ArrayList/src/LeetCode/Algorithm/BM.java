package LeetCode.Algorithm;

/**
 * @Author: Wdz
 * @Date 2020/9/30 8:25
 * @Description: BM算法的阉割版
 * 思想：让模式串从后面开始遍历，如果出现不同的，就看前面是否有改字符。如歌没有就将模式串的位置整体移动到该字符下一个继续进行匹配。
 */
public class BM {
    //在模式串中，查找index下标之前的字符是否和坏字符匹配
    private static int findCharacter(String pattern, char badCharacter, int index) {
        for (int i = index - 1; i >= 0; i--) {
            if (pattern.charAt(i) == badCharacter) {
                return i;
            }
        }
        //模式串不存在该字符，返回-1
        return -1;
    }

    public static int boyerMoore(String str, String pattern) {
        int strLength = str.length();
        int patternLength = pattern.length();
        //模式串的起始位置
        int start = 0;
        while (start <= strLength - patternLength) {
            int i;
            //从后向前，逐个字符比较
            for (i = patternLength - 1; i >= 0; i--) {
                if (str.charAt(start + i) != pattern.charAt(i))
                    //发现坏字符，跳出比较，i记录了坏字符的位置
                    break;
            }
            if (i < 0) {
                //匹配成功，返回第一次匹配的下标位置
                return start;
            }
            //寻找坏字符在模式串中的对应
            int charIndex = findCharacter(pattern, str.charAt(start + i), i);
            //计算坏字符产生的位移
            int bcOffset = charIndex >= 0 ? i - charIndex : i + 1;
            start += bcOffset;
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "aacdesadsdfer";
        String pattern = "adsd";
        int index = boyerMoore(str, pattern);
        System.out.println("首次出现的位置：" + index);
    }
}
