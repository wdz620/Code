package Offer.Other;

/**
 * @Author: Wdz
 * @Date 2020/10/8 10:08
 * @Description:
 */
public class Power {
    public static void main(String[] args) {
        System.out.println(Power1(2, -3));

    }

    //自答
    public static double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;
        if (exponent > 0) {
            double temp = base;
            while (exponent > 1) {
                base = base * temp;
                exponent--;
            }
        } else {
            int e = Math.abs(exponent);
            double temp = base;
            while (e > 1) {
                base = base * temp;
                e--;
            }
            base = 1 / base;
        }
        return base;
    }

    //自答优化代码
    public static double Power0(double base, int exponent) {
        double res = 1;
        if (exponent == 0) return 1;
        if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
            return res;
        } else {
            for (int i = 0; i < Math.abs(exponent); i++) {
                res = res * base;
            }
            return 1 / res;
        }
    }

    //参考答案
    public static double Power1(double base, int exponent) {
        //除2计算
        if (exponent == 0)
            return 1.0;
        if (exponent == 1)
            return base;
        if (exponent == -1)
            return 1.0 / base;
        double half = Power(base, exponent / 2); //一半
        return half * half * Power(base, exponent % 2); //注意奇偶不同，奇数多乘一个base
    }

    //参考答案2
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        boolean xf = false, nf = false;  //这两个flag是判断x和n的正负号，先剥离开计算pow后，再做符号处理
        double temp = x;
        long nn = n; //为了防止2的-31次方是-2147483648，如果加符号的话就溢出了，所以用long类型
        if (x < 0) {
            xf = true;
            x = -x;
        }
        if (n < 0) {
            nf = true;
            nn = -nn;
        }

        x = pow(x, nn);

        if (nf) x = 1 / x;
        if (xf == true && n % 2 == 1) x = -x;
        return x;
    }

    public double pow(double x, long n) {
        if (x == 1 || n == 0) return 1;
        if (n == 1) return x;
        double temp = pow(x, n / 2);
        if (n % 2 == 1) return temp * temp * x;
        return temp * temp;
    }
}
