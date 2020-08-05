package LeetCode.Char;

/**
 * @Author: Wdz
 * @Date 2020/7/31 11:43
 * @Description:最长公共前缀
 *
 *编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"ower","flow","flight"};

        System.out.println(longestCommonPrefix(strings));

    }
    /**
     * net
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs[0].length() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            boolean same = true;
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() <= i || strs[j].charAt(i) != temp) {
                    same = false;
                    break;
                }
            }
            if(same) {
                stringBuilder.append(temp);
            }else {
                break;
            }
        }
        return stringBuilder.toString();
    }

}
