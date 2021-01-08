package offer.List;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: Wdz
 * @Date 2021/1/6 15:20
 * @Description: 32、把数组排序成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class PrintMinNumber {
    // 思路：
    // 两个数n和m
    // 如果 nm > mn 说明 n 大于 m
    // 如果 nm < mn 说明 n 小于 m
    // 如果 nm = mn 说明 n 等于 m
    class compareStr implements Comparator<String> {
        @Override
        public int compare(String m, String n) {
            String mn = m + n, nm = n + m;
            return mn.compareTo(nm); // mn小于nm返回-1，等于返回0，大于返回1
        }
    }
    public String printMinNumber(int [] numbers) {
        String res = "";
        if (numbers == null || numbers.length == 0) {
            return res;
        }
        int len = numbers.length;
        String[] strings = new String[len];
        for (int i = 0; i < len; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        compareStr str = new compareStr();
        Arrays.sort(strings, str);
        for (String s : strings) {
            res += s;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {3, 32, 321};
        String s = new PrintMinNumber().printMinNumber1(nums);
        System.out.println(s);

    }

    public String printMinNumber1(int[] numbers) {
        String str = "";
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int t = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = t;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }
}
