package cn.netstudy;

import java.util.Scanner;

public class StringCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String input = scanner.next();

        int countUpper = 0;
        int countLower = 0;
        int countNumber = 0;
        int countOther = 0;

        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            if ('A' <= c && c <= 'Z') {
                countUpper++;
            } else if ('a' <= c && c <= 'z') {
                countLower++;
            } else if ('0' < c && c <= '9') {
                countNumber++;
            } else {
                countOther++;
            }
        }
        System.out.println(charArray.length);
        System.out.println("大写字母有：" + countUpper);
        System.out.println("小写字母有：" + countLower);
        System.out.println("数字有：" + countNumber);
        System.out.println("其他字符：" + countOther);
    }
}
