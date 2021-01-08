package leetcode.Algorithm;

/**
 * @Author: Wdz
 * @Date 2020/10/7 10:32
 * @Description: Java中实现十进制数转换为二进制
 * 扩展：
 * 位异或运算（^）：两个数转为二进制，然后从高位开始比较，如果相同则为0，不相同则为1。
 * 位与运算符（&）：两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
 * 位或运算符（|）：两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
 * 位非运算符（~）：如果位为0，结果是1，如果位为1，结果是0.
 */
public class BinaryToDecimal {
    public static void main(String[] args) {
//        System.out.println(test(15));
//        System.out.println(NumberOf2(15));
//        System.out.print("first:");
//        first(15);
//        System.out.print("first1:");
//        first1(1);
//        System.out.print("thrid:");
//        thrid(1);
//        System.out.print("second:");
//        second(1);
        System.out.println((8 ^ 11)); //8:1000  11:1011  异或得到 0011 通过二进制转换十进制就是 3
        System.out.println((129 & 128)); //129：10000001  128：10000000 位与得到 10000000 二进制转十进制就是128
        System.out.println((129 & 128)); //129：10000001  128：10000000 位或得到 10000001 二进制转十进制就是129
        System.out.println((~37));      // TODO 不太理解 而且上面的几个也不太会在实际场景中使用！


    }

    //十进制转二进制 ->给定的数循环除以2，直到商为0或者1为止。将每一步除的结果的余数记录下来，然后反过来就得到相应的二进制了。
    public static String toBinary(int num) {
        String str = "";
        while (num != 0) {
            str = num % 2 + str;
            num = num / 2;
        }
        return str;
    }
    //二进制转十进制 System.out.println(Integer.parseInt("1000",2));


    public static int NumberOf1(int n) {
        String reString = Integer.toBinaryString(n);
        System.out.println(reString);
        char a[] = reString.toCharArray();
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == '1') {
                sum += 1;
            }
        }
        return sum;
    }
    //最优解
    public static int NumberOf2(int n){
        int count=0;
        while(n!=0){
            count++;
            n=n&(n-1); //相与一次，去掉一个1
        }
        return count;
    }

    //超时
    public static int test(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res++;
            }
            n = n >> 1;
        }
        return res;
    }

    //除基倒取余法
    public static void first(int n) {
        //t:用来记录位数，bin：用来记录最后的二进制数，r用来存储余数
        int t = 0, bin = 0, r = 0;
        while (n != 0) {
            r = n % 2;
            n = n / 2;
            bin += r * Math.pow(10, t);
            t++;
        }
        System.out.println(bin);
    }

    //字符串拼接
    public static void first1(int n) {
        String str = "";
        while (n != 0) {
            str = n % 2 + str;
            n = n / 2;
        }
        System.out.println(str);
    }

    //移位操作
    public static void second(int n) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((n >>> i & 1));
        }
    }

    //调用API
    public static void thrid(int n) {
        String result = Integer.toBinaryString(n);
        System.out.println(result);
    }

}
