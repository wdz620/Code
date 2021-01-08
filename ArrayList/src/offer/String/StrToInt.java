package offer.String;

/**
 * @Author: Wdz
 * @Date 2020/11/16 18:53
 * @Description: JZ49 字符串变成整数 TODO
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 *
 *
 * 输入一个字符串,包括数字字母符号,可以为空
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * +2147483647
 * 1a33
 *
 * 2147483647
 * 0
 */
public class StrToInt {
    public int strToInt(String str) {
        return 0;
    }
    public static void main(String[] args) {
        String s = "123";
        // 方法一：
        System.out.println(Integer.parseInt(s));
        // 方法二：
        System.out.println(Integer.valueOf(s).intValue());
    }

}
