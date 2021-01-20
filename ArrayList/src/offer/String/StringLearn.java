package offer.String;

import java.util.Arrays;

/**
 * @Author: Wdz
 * @Date 2021/1/18 19:27
 * @Description: String/StringBuffer/StringBuilder
 * String 字符串常量
 * StringBuffer 字符串变量（线程安全）
 * StringBuilder 字符串变量（非线程安全）
 * 使用场景：
 * 使用 String 类的场景：在字符串不经常变化的场景中可以使用 String 类，例如常量的声明、少量的变量运算。
 * 使用 StringBuffer 类的场景：在频繁进行字符串运算（如拼接、替换、删除等），并且运行在多线程环境中，则可以考虑使用 StringBuffer，例如 XML 解析、HTTP 参数解析和封装。
 * 使用 StringBuilder 类的场景：在频繁进行字符串运算（如拼接、替换、和删除等），并且运行在单线程的环境中，则可以考虑使用 StringBuilder，如 SQL 语句的拼装、JSON 封装等。
 *
 * 总结：
 * 如果要操作少量的数据用 String；
 * 多线程操作字符串缓冲区下操作大量数据 StringBuffer；
 * 单线程操作字符串缓冲区下操作大量数据 StringBuilder。
 */
public class StringLearn {
    public static void main(String[] args) {
        JZ44(); // 主要学习了StringBuilder的insert方法（插入，从什么位置开始插入）append（）在后面加入
        int[] nums = {0, 3, 2, 6, 4};
        Arrays.sort(nums);
        int countZero = 0, temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                countZero++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                System.out.println("false");
            }
            temp += nums[i + 1] - nums[i] - 1;
        }
        if (countZero >= temp) {
            System.out.println("ok");
        }
        System.out.println("error");
    }

    /**
     * 翻转单词顺序列
     */
    public static void JZ44() {
        String s = "nowcoder. a am I";
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        String tempStr = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                sb.insert(0, tempStr);
                sb.insert(0, " ");
                tempStr = "";
            } else {
                tempStr += chars[i];
            }
        }
        if (!tempStr.equals("")) {
            sb.insert(0, tempStr);
        }
        System.out.println(sb);
    }
}
