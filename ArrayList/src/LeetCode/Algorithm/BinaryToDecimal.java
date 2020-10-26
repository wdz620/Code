package LeetCode.Algorithm;

/**
 * @Author: Wdz
 * @Date 2020/10/7 10:32
 * @Description: Java中实现十进制数转换为二进制
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
    }

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
